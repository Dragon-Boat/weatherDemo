package com.example.hzzhoulong.dragonweather.network;

import com.example.hzzhoulong.dragonweather.model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author hzzhoulong
 * @date 2016/8/18.
 */
public interface ProGetWeatherInfo {
    @GET("weather")
    Call<Weather> getWeatherInfo(@Query("id") int cityId);

    @GET("weather")
    Call<Weather> getWeatherInfo(@Query("q=") String cityName);
}
