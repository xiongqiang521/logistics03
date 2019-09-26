package com.xq.bean;

/**
 * 订单中转信息类
 */
public class TransferInfo {
    /*`id` int(11) NOT NULL,
    `order_id` int(11) DEFAULT NULL COMMENT '订单id',
    `mode` varchar(255) DEFAULT NULL COMMENT '是进库还是出库',
    `station_id` int(11) DEFAULT NULL COMMENT '进出的网点',
    `employee_id` int(11) DEFAULT NULL COMMENT '进出库操作员',
    `time` datetime DEFAULT NULL,*/

    private Integer id;             //订单中转信息编号
    private Integer order_id;        //订单号
    private String mode;            //出入库状态 出库或者入库
    private String stationName;     //当前所在站点名称
    private String employeeName;    //操作员姓名
    private String time;            //操作时间

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

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TransferInfo{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", mode='" + mode + '\'' +
                ", stationName='" + stationName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
