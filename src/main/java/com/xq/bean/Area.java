package com.xq.bean;

import java.io.Serializable;

public class Area implements Serializable {

  private Integer area_no;
  private String city_code;
  private String area_code;
  private String area_simple;
  private String area_details;

  @Override
  public String toString() {
    return "Area{" +
            "area_no=" + area_no +
            ", city_code='" + city_code + '\'' +
            ", area_code='" + area_code + '\'' +
            ", area_simple='" + area_simple + '\'' +
            ", area_details='" + area_details + '\'' +
            '}';
  }

  public Integer getArea_no() {
    return area_no;
  }

  public void setArea_no(Integer area_no) {
    this.area_no = area_no;
  }


  public String getCity_code() {
    return city_code;
  }

  public void setCity_code(String city_code) {
    this.city_code = city_code;
  }


  public String getArea_code() {
    return area_code;
  }

  public void setArea_code(String area_code) {
    this.area_code = area_code;
  }


  public String getArea_simple() {
    return area_simple;
  }

  public void setArea_simple(String area_simple) {
    this.area_simple = area_simple;
  }


  public String getArea_details() {
    return area_details;
  }

  public void setArea_details(String area_details) {
    this.area_details = area_details;
  }

}
