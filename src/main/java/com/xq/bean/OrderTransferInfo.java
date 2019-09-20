package com.xq.bean;;


public class OrderTransferInfo {

  private Integer id;
  private Integer order_id;
  private String mode;
  private Integer station_id;
  private Integer employee_id;
  private String time;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getOrder_id() {
    return order_id;
  }

  public void setOrder_id(Integer order_id) {
    this.order_id = order_id;
  }


  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }


  public Integer getStation_id() {
    return station_id;
  }

  public void setStation_id(Integer station_id) {
    this.station_id = station_id;
  }


  public Integer getEmployee_id() {
    return employee_id;
  }

  public void setEmployee_id(Integer employee_id) {
    this.employee_id = employee_id;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

}
