package com.example.hzzhoulong.dragonweather.network;

import retrofit2.Retrofit;

/**
 * @author hzzhoulong
 * @date 2016/8/18.
 */
public enum RetrofitClient {
    INSTANCE,;
    private static final String URL = "api.openweathermap.org/data/2.5/";

    private Retrofit mRetrofit;

    RetrofitClient() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(WeatherConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
