package com.xq.bean;

import java.io.Serializable;

;


public class Transfer implements Serializable {

  private Integer id;
  private String name;
  private String address;
  private Double max_weight;

  @Override
  public String toString() {
    return "Transfer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", max_weight=" + max_weight +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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


  public Double getMax_weight() {
    return max_weight;
  }

  public void setMax_weight(Double max_weight) {
    this.max_weight = max_weight;
  }

}
