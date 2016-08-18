package com.example.hzzhoulong.dragonweather.network;

import com.google.gson.Gson;

import retrofit2.Converter;

/**
 * @author hzzhoulong
 * @date 2016/8/18.
 */
public class WeatherConverterFactory extends Converter.Factory {

    public WeatherConverterFactory(Gson gson) {
        if (gson==null) throw new NullPointerException("gson=null");
        mGson = gson;
    }

    private Gson mGson;
    public static Converter.Factory create() {
        return create(new Gson());
    }

    public static Converter.Factory create(Gson gson) {
        return new WeatherConverterFactory(gson);
    }


}
