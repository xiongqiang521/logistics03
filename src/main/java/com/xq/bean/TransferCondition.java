package com.xq.bean;

public class TransferCondition {
    private String startTime;
    private String lastTime;
    private String stationName;
    private Integer orderId;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "TransferCondition{" +
                "startTime='" + startTime + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", stationName='" + stationName + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
