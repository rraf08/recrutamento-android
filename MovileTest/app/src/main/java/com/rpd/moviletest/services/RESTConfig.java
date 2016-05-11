package com.rpd.moviletest.services;

import retrofit.RestAdapter;

/**
 * Created by Rafael Paz
 *
 * Class used to define REST API adapter having a caller method to make requests from another class
 */
public class RESTConfig {

    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(APIParam.API_URL)
            .build();

    private static final APITrakt CALLER_APP = REST_ADAPTER.create(APITrakt.class);

    public static APITrakt getAPI() {
        return CALLER_APP;
    }
}