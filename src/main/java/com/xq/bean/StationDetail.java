package com.xq.bean;

import java.io.Serializable;

;


public class StationDetail implements Serializable {

  private Integer id;
  private Integer station_id;
  private Integer order_id;
  private String in_time;
  private String out_time;

  @Override
  public String toString() {
    return "StationDetail{" +
            "id=" + id +
            ", station_id=" + station_id +
            ", order_id=" + order_id +
            ", in_time='" + in_time + '\'' +
            ", out_time='" + out_time + '\'' +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getStation_id() {
    return station_id;
  }

  public void setStation_id(Integer station_id) {
    this.station_id = station_id;
  }


  public Integer getOrder_id() {
    return order_id;
  }

  public void setOrder_id(Integer order_id) {
    this.order_id = order_id;
  }


  public String getIn_time() {
    return in_time;
  }

  public void setIn_time(String in_time) {
    this.in_time = in_time;
  }


  public String getOut_time() {
    return out_time;
  }

  public void setOut_time(String out_time) {
    this.out_time = out_time;
  }

}
