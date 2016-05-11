package com.rpd.moviletest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rpd.moviletest.R;
import com.rpd.moviletest.model.Episode;

import java.util.ArrayList;
/**
 * Created by Rafael Paz.
 *
 * Base Adapter to display epidose list *
 */
public class EpisodeAdapter extends BaseAdapter {
    private ArrayList<Episode> listEpisodes;
    private LayoutInflater layoutInflater;

    public EpisodeAdapter(Context context, ArrayList<Episode> episodes) {
        this.listEpisodes = episodes;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listEpisodes.size();
    }

    @Override
    public Object getItem(int position) {
        return listEpisodes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list, null);
            holder = new ViewHolder();
            holder.episode_number = (TextView) convertView.findViewById(R.id.text_episode_number);
            holder.episode_title = (TextView) convertView.findViewById(R.id.text_episode_title);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.episode_number.setText("E"+listEpisodes.get(position).getNumber());
        holder.episode_title.setText(listEpisodes.get(position).getTitle());
        return convertView;
    }

    static class ViewHolder {
        TextView episode_number;
        TextView episode_title;
    }
}
