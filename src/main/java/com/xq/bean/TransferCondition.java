package com.xq.bean;

public class TransferCondition {
    private String startTime;
    private String lastTime;
    private String stationName;
    private String orderState;
    private String orderId;

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

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "TransferCondition{" +
                "startTime='" + startTime + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", stationName='" + stationName + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
