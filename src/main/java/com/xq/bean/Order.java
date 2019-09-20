package com.xq.bean;


public class Order {

  private String id;
  private Integer orderId;
  private String sendTime;
  private Integer sendUserId;
  private String sendAddress;
  private String receiveTime;
  private Integer receiveUserId;
  private String receiveAddress;
  private double weight;
  private String money;
  private Integer orderStateId;
  private Integer orderInfoId;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }


  public String getSendTime() {
    return sendTime;
  }

  public void setSendTime(String sendTime) {
    this.sendTime = sendTime;
  }


  public Integer getSendUserId() {
    return sendUserId;
  }

  public void setSendUserId(Integer sendUserId) {
    this.sendUserId = sendUserId;
  }


  public String getSendAddress() {
    return sendAddress;
  }

  public void setSendAddress(String sendAddress) {
    this.sendAddress = sendAddress;
  }


  public String getReceiveTime() {
    return receiveTime;
  }

  public void setReceiveTime(String receiveTime) {
    this.receiveTime = receiveTime;
  }


  public Integer getReceiveUserId() {
    return receiveUserId;
  }

  public void setReceiveUserId(Integer receiveUserId) {
    this.receiveUserId = receiveUserId;
  }


  public String getReceiveAddress() {
    return receiveAddress;
  }

  public void setReceiveAddress(String receiveAddress) {
    this.receiveAddress = receiveAddress;
  }


  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }


  public String getMoney() {
    return money;
  }

  public void setMoney(String money) {
    this.money = money;
  }


  public Integer getOrderStateId() {
    return orderStateId;
  }

  public void setOrderStateId(Integer orderStateId) {
    this.orderStateId = orderStateId;
  }


  public Integer getOrderInfoId() {
    return orderInfoId;
  }

  public void setOrderInfoId(Integer orderInfoId) {
    this.orderInfoId = orderInfoId;
  }

}
