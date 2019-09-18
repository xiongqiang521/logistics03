package com.xq.bean;

import java.io.Serializable;

;


public class City implements Serializable {

  private Integer city_no;
  private String pro_code;
  private String city_code;
  private String city_simple;
  private String city_details;

  @Override
  public String toString() {
    return "City{" +
            "city_no=" + city_no +
            ", pro_code='" + pro_code + '\'' +
            ", city_code='" + city_code + '\'' +
            ", city_simple='" + city_simple + '\'' +
            ", city_details='" + city_details + '\'' +
            '}';
  }

  public Integer getCity_no() {
    return city_no;
  }

  public void setCity_no(Integer city_no) {
    this.city_no = city_no;
  }


  public String getPro_code() {
    return pro_code;
  }

  public void setPro_code(String pro_code) {
    this.pro_code = pro_code;
  }


  public String getCity_code() {
    return city_code;
  }

  public void setCity_code(String city_code) {
    this.city_code = city_code;
  }


  public String getCity_simple() {
    return city_simple;
  }

  public void setCity_simple(String city_simple) {
    this.city_simple = city_simple;
  }


  public String getCity_details() {
    return city_details;
  }

  public void setCity_details(String city_details) {
    this.city_details = city_details;
  }

}
