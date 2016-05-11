package com.rpd.moviletest.services;

import com.rpd.moviletest.model.Episode;
import com.rpd.moviletest.model.Season;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
/**
 * Created by Rafael Paz
 *
 * Interface to define methods from Trakt API and also necessary headers in requests
 */
public interface APITrakt {

    @Headers({
            "trakt-api-version: "+APIParam.API_VERSION,
            "trakt-api-key: "+APIParam.API_KEY
    })
    @GET("/shows/how-i-met-your-mother/seasons/5/episodes")
    void getEpisodes(Callback<ArrayList<Episode>> response);

    @Headers({
            "trakt-api-version: "+APIParam.API_VERSION,
            "trakt-api-key: "+APIParam.API_KEY
    })
    @GET("/shows/how-i-met-your-mother/seasons?extended=full,images")
    void getSeasonInfo(Callback<ArrayList<Season>> response);



    @Headers({
            "trakt-api-version: "+APIParam.API_VERSION,
            "trakt-api-key: "+APIParam.API_KEY
    })
    @GET("/shows/how-i-met-your-mother?extended=full,images")
    void getThumb(Callback<Season> response);
}
