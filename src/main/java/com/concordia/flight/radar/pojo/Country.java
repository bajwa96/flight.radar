package com.concordia.flight.radar.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country extends BasePojo{
	public Country(){
		
	}
	public Country(String countryName, String code, String code3){
		this.countryName=countryName;
		this.code=code;
		this.code3=code3;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String countryName;
	private String code;
	private String code3;
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode3() {
		return code3;
	}
	public void setCode3(String code3) {
		this.code3 = code3;
	}
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("[countryName:").append(countryName).append(", ");
		str.append("code:").append(code).append(", ");
		str.append("code3:").append(code3).append("]");
		return str.toString();
	}
}
