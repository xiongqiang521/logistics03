package com.xq.bean;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/22 10:17
 */
public class OrderTransferInfoName {

    private String mode;
    private String stationName;
    // private String employeeName;
    private String time;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
