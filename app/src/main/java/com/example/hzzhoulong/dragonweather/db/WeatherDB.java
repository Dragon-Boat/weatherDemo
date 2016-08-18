package com.example.hzzhoulong.dragonweather.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hzzhoulong.dragonweather.model.City;
import com.example.hzzhoulong.dragonweather.model.County;
import com.example.hzzhoulong.dragonweather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzzhoulong
 * @date 2016/8/18.
 */
public enum WeatherDB {
    INSTANCE;
    public static final String CITY = "City";
    public static final String CITY_CODE = "city_code";
    public static final String CITY_NAME = "city_name";
    public static final String COUNTY_NAME = "county_name";
    public static final String DB_NAME = "dragon_weather";
    public static final String PROVINCE = "Province";
    public static final String PROVINCE_ID = "province_id";
    public static final String PROVINCE_NAME = "province_name";

    public static final int VERSION = 1;
    public static final String PROVINCE_CODE = "province_code";
    public static final String COUNTY_CODE = "county_code";
    public static final String CITY_ID = "city_id";
    public static final String COUNTY = "County";
    private SQLiteDatabase db;

    WeatherDB() {

    }

    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put(PROVINCE_NAME, province.getProvinceName());
            values.put(PROVINCE_CODE, province.getProvinceCode());
            db.insert(PROVINCE, null, values);
        }
    }

    public void saveCity(City city) {
        if (city != null) {
            ContentValues values = new ContentValues();
            values.put(CITY_NAME, city.getCityName());
            values.put(CITY_CODE, city.getCityCode());
            values.put(PROVINCE_ID, city.getProvinceId());
            db.insert(CITY, null, values);
        }
    }

    public void saveCounty(County county) {
        if (county != null) {
            ContentValues values = new ContentValues();
            values.put(COUNTY_NAME, county.getCountyName());
            values.put(COUNTY_CODE, county.getCountyCode());
            values.put(CITY_ID, county.getCityId());
            db.insert(COUNTY, null, values);
        }
    }

    public List<Province> loadProvinces() {
        List<Province> list = new ArrayList<>();
        Cursor cursor = db
                .query(PROVINCE, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(
                        cursor.getColumnIndex(PROVINCE_NAME)
                ));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex(PROVINCE_CODE)));
                list.add(province);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }

    public List<City> loadCities(int provinceId) {
        List<City> cities = new ArrayList<>();
        Cursor cursor = db
                .query(CITY, null, "province_id = ?",
                        new String[]{String.valueOf(provinceId)}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex(CITY_NAME)));
                city.setCityCode(cursor.getString(cursor.getColumnIndex(CITY_CODE)));
                city.setProvinceId(provinceId);
                cities.add(city);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();

        }
        return cities;
    }

    public List<County> laodCounties(int cityId) {
        List<County> counties = new ArrayList<>();
        Cursor cursor = db
                .query(COUNTY, null, "city_id = ?",
                        new String[]{String.valueOf(cityId)}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex(COUNTY_NAME)));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex(COUNTY_CODE)));
                county.setCityId(cityId);
                counties.add(county);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return counties;
    }
}
