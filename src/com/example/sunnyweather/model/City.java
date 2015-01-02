package com.example.sunnyweather.model;

public class City {
	private String cityCode;
	private String cityName;
	private int id;
	private int provinceId;
	public String getCityCode() {
		return cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public int getId() {
		return id;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	
}
