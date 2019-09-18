package com.xq.bean;

import java.io.Serializable;

public class Station implements Serializable {

  private Integer id;
  private Integer station_num;
  private String name;
  private String address;
  private Integer employee_id;
  private String telephone;
  private Integer transfer_id;
  private Double max_weight;

  @Override
  public String toString() {
    return "Station{" +
            "id=" + id +
            ", station_num=" + station_num +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", employee_id=" + employee_id +
            ", telephone='" + telephone + '\'' +
            ", transfer_id=" + transfer_id +
            ", max_weight=" + max_weight +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getStation_num() {
    return station_num;
  }

  public void setStation_num(Integer station_num) {
    this.station_num = station_num;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public Integer getEmployee_id() {
    return employee_id;
  }

  public void setEmployee_id(Integer employee_id) {
    this.employee_id = employee_id;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public Integer getTransfer_id() {
    return transfer_id;
  }

  public void setTransfer_id(Integer transfer_id) {
    this.transfer_id = transfer_id;
  }


  public Double getMax_weight() {
    return max_weight;
  }

  public void setMax_weight(Double max_weight) {
    this.max_weight = max_weight;
  }

}
