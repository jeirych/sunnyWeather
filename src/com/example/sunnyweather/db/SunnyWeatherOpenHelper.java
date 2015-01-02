package com.example.sunnyweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SunnyWeatherOpenHelper extends SQLiteOpenHelper {

	/**
	 *ProvinceDB
	 */
	public final static String CREAT_PROVINCE="create table Province("
			+"id integer primary key autoincrement,"
			+"province_name text,"
			+"province_code text)";
	/**
	 * CityDB
	 */
	public final static String CREAT_CITY="create table City("
			+"id integer primary key autoincrement,"
			+"city_name text,"
			+"ctiy_code text,"
			+"province_id integer)";
	/**
	 * CountyDB	 
	 * 
	 */
	public final  static String CREATE_COUNTY="create table Country("
			+"id integer primary key autoincrement,"
			+"country_name text,"
			+"country_code text,"
			+"city_id integer)";
	public SunnyWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREAT_CITY);
		db.execSQL(CREAT_PROVINCE);
		db.execSQL(CREATE_COUNTY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
