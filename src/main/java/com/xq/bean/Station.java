package com.xq.bean;


public class Station {

  private Integer id;
  private Integer stationNum;
  private String name;
  private String address;
  private Integer employeeId;
  private String telephone;
  private Double maxWeight;
  private Integer transfer;
  private Integer transferId;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getStationNum() {
    return stationNum;
  }

  public void setStationNum(Integer stationNum) {
    this.stationNum = stationNum;
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


  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
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


  public Integer getTransferId() {
    return transferId;
  }

  public void setTransferId(Integer transferId) {
    this.transferId = transferId;
  }

}
