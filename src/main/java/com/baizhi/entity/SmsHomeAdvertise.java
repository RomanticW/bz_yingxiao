package com.baizhi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 首页轮播广告表
 * @TableName sms_home_advertise
 */
@TableName(value ="sms_home_advertise")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmsHomeAdvertise implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    private Integer type;

    /**
     * 
     */
    private String pic;

    /**
     * 
     */
    private Date startTime;

    /**
     * 
     */
    private Date endTime;

    /**
     * 上下线状态：0->下线；1->上线
     */
    private Integer status;

    /**
     * 点击数
     */
    private Integer clickCount;

    /**
     * 下单数
     */
    private Integer orderCount;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 备注
     */
    private String note;

    /**
     * 排序
     */
    private Integer sort;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}