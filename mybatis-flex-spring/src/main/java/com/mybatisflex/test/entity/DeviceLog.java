package com.mybatisflex.test.entity;

import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备日志对象 iot_device_log
 *
 * @author kerwincui
 * @date 2022-01-13
 */
@Data
@Table("iot_device_log_202404")
public class DeviceLog implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 设备日志ID
     */
    private Long logId;

    /**
     * 类型（1=属性上报，2=事件上报，3=调用功能，4=设备升级，5=设备上线，6=设备离线）
     */
    private Integer logType;

    /**
     * 日志值
     */
    private Float logValue;

    /**
     * 设备ID
     */
    private String deviceId;


    private String deviceName;


    private String serialNumber;

    private String identity;

    private Integer isMonitor;


    private Integer mode;


    private Long userId;


    private String userName;


    private Long tenantId;


    private String tenantName;

    private String createBy;

    private String remark;

    private Date createTime;

}
