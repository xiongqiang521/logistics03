package com.xq.bean;

import java.io.Serializable;

;


public class Province implements Serializable {

  private Integer prov_no;
  private String prov_code;
  private String prov_simple;
  private String prov_details;

  @Override
  public String toString() {
    return "Province{" +
            "prov_no=" + prov_no +
            ", prov_code='" + prov_code + '\'' +
            ", prov_simple='" + prov_simple + '\'' +
            ", prov_details='" + prov_details + '\'' +
            '}';
  }

  public Integer getProv_no() {
    return prov_no;
  }

  public void setProv_no(Integer prov_no) {
    this.prov_no = prov_no;
  }


  public String getProv_code() {
    return prov_code;
  }

  public void setProv_code(String prov_code) {
    this.prov_code = prov_code;
  }


  public String getProv_simple() {
    return prov_simple;
  }

  public void setProv_simple(String prov_simple) {
    this.prov_simple = prov_simple;
  }


  public String getProv_details() {
    return prov_details;
  }

  public void setProv_details(String prov_details) {
    this.prov_details = prov_details;
  }

}
