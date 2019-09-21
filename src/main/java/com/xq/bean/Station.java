package com.xq.bean;


public class Station {

  private Integer id;
  private Integer station_num;
  private String name;
  private String address;
  private Integer employee_id;
  private String telephone;
  private Double maxWeight;
  private Integer transfer;
  private Integer transfer_id;

  @Override
  public String toString() {
    return "Station{" +
            "id=" + id +
            ", station_num=" + station_num +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", employee_id=" + employee_id +
            ", telephone='" + telephone + '\'' +
            ", maxWeight=" + maxWeight +
            ", transfer=" + transfer +
            ", transfer_id=" + transfer_id +
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

  public Double getMaxWeight() {
    return maxWeight;
  }

  public void setMaxWeight(Double maxWeight) {
    this.maxWeight = maxWeight;
  }

  public Integer getTransfer() {
    return transfer;
  }

  public void setTransfer(Integer transfer) {
    this.transfer = transfer;
  }

  public Integer getTransfer_id() {
    return transfer_id;
  }

  public void setTransfer_id(Integer transfer_id) {
    this.transfer_id = transfer_id;
  }
}
