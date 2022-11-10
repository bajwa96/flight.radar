package com.concordia.flight.radar.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "country")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Country extends BasePojo{
	
	public Country(String countryName, String code, String code3){
		this.countryName=countryName;
		this.code=code;
		this.code3=code3;
	}
	
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
}
