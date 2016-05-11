package com.rpd.moviletest.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nineoldandroids.view.ViewHelper;
import com.rpd.moviletest.R;
import com.rpd.moviletest.adapter.EpisodeAdapter;
import com.rpd.moviletest.model.Episode;
import com.rpd.moviletest.model.Season;
import com.rpd.moviletest.observablescrollview.ObservableListView;
import com.rpd.moviletest.observablescrollview.ObservableScrollViewCallbacks;
import com.rpd.moviletest.observablescrollview.ScrollState;
import com.rpd.moviletest.observablescrollview.ScrollUtils;
import com.rpd.moviletest.services.RESTConfig;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
/**
 * Created by Rafael Paz
 */
public class EpisodesListParallaxActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {

    //Activity main variables
    private View mImageView;
    private View mToolbarView;
    private View mListBackgroundView;
    private ObservableListView mListView;
    private int mParallaxImageHeight;
    private ArrayList<Episode> episodes;
    private EpisodeAdapter mListAdapter;
    private String url_banner;
    private String url_thumb;
    private Double rating_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main) ;

        //Customizing toolbar title
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_list);

        //Obtaining layout elements
        mImageView = findViewById(R.id.thumb_image);
        mToolbarView = findViewById(R.id.toolbar);
        mListBackgroundView = findViewById(R.id.list_background);
        mListView = (ObservableListView) findViewById(R.id.list);

        //Indicate this class as the implementor of Scrollable interface
        mListView.setScrollViewCallbacks(this);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.primary)));
        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);

        //Adding header to listview
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.detail_header, mListView,false);
        mListView.addHeaderView(header);

        //Only retrieve data once
        if(savedInstanceState==null) {
            getEpisodes();
            getSeasonInfo();
            getThumbImage();
        }

    }

    //Using OnSaveInstanceState and onRestoreInstanceState to retain values for device rotation
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putSerializable("eps",episodes);
        savedInstanceState.putInt("pos",mListView.getCurrentScrollY());
        savedInstanceState.putDouble("rating",rating_value);
        savedInstanceState.putString("url_banner",url_banner);
        savedInstanceState.putString("url_thumb",url_thumb);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        episodes = (ArrayList<Episode>)savedInstanceState.getSerializable("eps");
        showList();
        mListView.scrollVerticallyTo(savedInstanceState.getInt("pos"));
        onScrollChanged(mListView.getCurrentScrollY(), false, false);
        rating_value=savedInstanceState.getDouble("rating");
        url_banner=savedInstanceState.getString("url_banner");
        url_thumb=savedInstanceState.getString("url_thumb");
        showSeasonInfo();
        showThumb();
        super.onRestoreInstanceState(savedInstanceState);
    }

    // Implementing callback method for scroll changes and also toolbar color change
    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.primary);
        float alpha = Math.min(1, (float) scrollY / mParallaxImageHeight);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(mImageView, -scrollY / 2);

        // Translate list background
        ViewHelper.setTranslationY(mListBackgroundView,Math.max(0, -scrollY +  mParallaxImageHeight));
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

    // Retrieving episodes list from REST API web service and filling ArrayList
    private void getEpisodes(){
        if(episodes==null) {
            final ProgressDialog loading = ProgressDialog.show(this, "Loading", "Please wait...", false, false);

            RESTConfig.getAPI().getEpisodes(new Callback<ArrayList<Episode>>() {
                @Override
                public void success(ArrayList<Episode> list, Response response) {
                    loading.dismiss();
                    episodes = list;
                    showList();
                }

                @Override
                public void failure(RetrofitError error) {
                    loading.dismiss();
                    mListView.setAdapter(mListAdapter);
                    showErrorToast();

                }
            });
        }
    }
    // Retrieving rating value for predefined season and url banner image using REST API web service
    private void getSeasonInfo(){
        if(rating_value==null || url_banner==null) {
            RESTConfig.getAPI().getSeasonInfo(new Callback<ArrayList<Season>>() {
                @Override
                public void success(ArrayList<Season> list, Response response) {

                    for (int i = 0; i < list.size(); i++) {

                        if (list.get(i).getNumber() == 5) {
                            rating_value = list.get(i).getRating();

                            float density = getResources().getDisplayMetrics().density;
                            // return 0.75 if it's LDPI
                            // return 1.0 if it's MDPI
                            // return 1.5 if it's HDPI
                            // return 2.0 if it's XHDPI
                            // return 3.0 if it's XXHDPI
                            // return 4.0 if it's XXXHDPI
                            if (density == 3.0 || density == 4.0) {
                                url_banner = list.get(i).getImages().getPoster().get("full");
                            } else if (density == 2.0 || density == 1.5) {
                                url_banner = list.get(i).getImages().getPoster().get("medium");
                            } else if (density == 1.0 || density == 0.75) {
                                url_banner = list.get(i).getImages().getPoster().get("thumb");
                            }

                        }
                    }

                    showSeasonInfo();
                }

                @Override
                public void failure(RetrofitError error) {
                    showErrorToast();
                }
            });
        }
    }
    //Retrieving url thumb header image using REST API web service
    private void getThumbImage(){
        if(rating_value==null || url_banner==null) {
            RESTConfig.getAPI().getThumb(new Callback<Season>() {
                @Override
                public void success(Season season, Response response) {

                    float density = getResources().getDisplayMetrics().density;
                    // return 0.75 if it's LDPI
                    // return 1.0 if it's MDPI
                    // return 1.5 if it's HDPI
                    // return 2.0 if it's XHDPI
                    // return 3.0 if it's XXHDPI
                    // return 4.0 if it's XXXHDPI
                    if (density == 3.0 || density == 4.0) {
                        url_thumb = season.getImages().getFanart().get("full");
                    } else if (density == 2.0 || density == 1.5) {
                        url_thumb = season.getImages().getFanart().get("medium");
                    } else if (density == 1.0 || density == 0.75) {
                        url_thumb = season.getImages().getFanart().get("thumb");
                    }
                    showThumb();

                }

                @Override
                public void failure(RetrofitError error) {
                    showErrorToast();
                }
            });
        }
    }


    //Setting adapter with ArrayList to show episode list
    private void showList(){
        mListAdapter = new EpisodeAdapter(this,episodes);
        mListView.setAdapter(mListAdapter);
    }

    //Setting rating value for textview and retrieving image from url to set in imageview
    private void showSeasonInfo() {

        TextView rating_text = (TextView) findViewById(R.id.rating_text);
        ImageView banner = (ImageView) findViewById(R.id.banner);

        rating_text.setText(String.valueOf(rating_value));
        Glide.with(this)
                .load(url_banner)
                .into(banner);
    }

    //Retrieving image from url to set in imageview
    private void showThumb(){

        ImageView thumb = (ImageView) findViewById(R.id.thumb_image);

        Glide.with(this)
                .load(url_thumb)
                .fitCenter()
                .into(thumb);
    }

    //Method to display a Toast when exist a network error in web services
    private void showErrorToast(){
        Context context = getApplicationContext();
        CharSequence text=getResources().getText(R.string.error_message);
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
