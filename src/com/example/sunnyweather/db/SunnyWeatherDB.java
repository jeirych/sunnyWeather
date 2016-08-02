package com.example.sunnyweather.db;

import java.util.ArrayList;
import java.util.List;

import com.example.sunnyweather.model.City;
import com.example.sunnyweather.model.Country;
import com.example.sunnyweather.model.Province;

import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PorterDuff;

public class SunnyWeatherDB {
	public static final String DB_NAME = "sunny_weather";
	public static final int VERSION = 1;
	private static SunnyWeatherDB sunnyWeatherDB;
	private SQLiteDatabase db;
	//私有化构造方法
	private SunnyWeatherDB(Context context) {
		SunnyWeatherOpenHelper dbHelper = new SunnyWeatherOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}
	//创建实例
	public synchronized static SunnyWeatherDB getInstance(Context context) {
		if(sunnyWeatherDB == null) {
			sunnyWeatherDB = new SunnyWeatherDB(context);
		}
		return sunnyWeatherDB;
	}
	//保存省份信息
	public void saveProvince(Province province){
		if(province != null) {
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.insert("Province", null, values);
		}
	}
	//保存城市信息
	public void saveCity(City city){
		if(city != null) {
			ContentValues values = new ContentValues();
			values.put("city_name", city.getCityName());
			values.put("city_code", city.getCityCode());
			values.put("province_id", city.getProvinceId());
			db.insert("City", null, values);
		}
	}
	//保存县信息
	public void saveCountry(Country country){
		if(country != null) {
			ContentValues values = new ContentValues();
			values.put("country_name", country.getCountryName());
			values.put("country_code", country.getCountryCode());
			values.put("city_id", country.getCityId());
			db.insert("Country", null, values);
		}
	}
	//遍历省份信息
	public List<Province> loadProvinces() {
		List<Province> list = new ArrayList<>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToFirst()) {
			do{
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
				province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
				list.add(province);
			}while(cursor.moveToNext());
		}
		if(cursor!= null){
			cursor.close();
		}		
         	return list;
	}
	//注意命名规范：City 的复数为 Cities
	public List<City> loadCitys() {
		List<City> list = new ArrayList<>();
		Cursor cursor = db.query("City", null, null, null, null, null, null);
		if(cursor.moveToFirst()) {
			do{
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
				city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setProvinceId(provinceId);
				list.add(city);
			}while(cursor.moveToNext());
		}
		if(cursor!= null)		
			cursor.close();
         return list;
	}
	//注意命名规范：Country 的复数为 Countries
	public List<Country> loadCountrys() {
		List<Country> list = new ArrayList<>();
		Cursor cursor = db.query("Country", null, null, null, null, null, null);
		if(cursor.moveToFirst()) {
			do{
				Country country = new Country();
				country.setId(cursor.getInt(cursor.getColumnIndex("id")));
				country.setCountryCode(cursor.getString(cursor.getColumnIndex("country_code")));
				country.setCountryName(cursor.getString(cursor.getColumnIndex("country_name")));
				country.setCityId(cityId);
				list.add(country);
			}while(cursor.moveToNext());
		}
		if(cursor!= null)		
			cursor.close();
         return list;
	}
}
