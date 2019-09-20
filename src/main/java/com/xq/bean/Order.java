package com.xq.bean;;


public class Order {

  private String id;
  private Integer order_id;
  private String send_time;
  private Integer send_user_id;
  private String send_address;
  private String receive_time;
  private Integer receive_user_id;
  private String receive_address;
  private Double weight;
  private String money;
  private Integer order_state_id;
  private Integer order_info_id;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Integer getOrder_id() {
    return order_id;
  }

  public void setOrder_id(Integer order_id) {
    this.order_id = order_id;
  }


  public String getSend_time() {
    return send_time;
  }

  public void setSend_time(String send_time) {
    this.send_time = send_time;
  }


  public Integer getSend_user_id() {
    return send_user_id;
  }

  public void setSend_user_id(Integer send_user_id) {
    this.send_user_id = send_user_id;
  }


  public String getSend_address() {
    return send_address;
  }

  public void setSend_address(String send_address) {
    this.send_address = send_address;
  }


  public String getReceive_time() {
    return receive_time;
  }

  public void setReceive_time(String receive_time) {
    this.receive_time = receive_time;
  }


  public Integer getReceive_user_id() {
    return receive_user_id;
  }

  public void setReceive_user_id(Integer receive_user_id) {
    this.receive_user_id = receive_user_id;
  }


  public String getReceive_address() {
    return receive_address;
  }

  public void setReceive_address(String receive_address) {
    this.receive_address = receive_address;
  }


  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }


  public String getMoney() {
    return money;
  }

  public void setMoney(String money) {
    this.money = money;
  }


  public Integer getOrder_state_id() {
    return order_state_id;
  }

  public void setOrder_state_id(Integer order_state_id) {
    this.order_state_id = order_state_id;
  }


  public Integer getOrder_info_id() {
    return order_info_id;
  }

  public void setOrder_info_id(Integer order_info_id) {
    this.order_info_id = order_info_id;
  }

}
