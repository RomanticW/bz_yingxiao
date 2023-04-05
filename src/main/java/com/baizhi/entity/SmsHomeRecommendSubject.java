package com.baizhi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 首页推荐专题表
 * @TableName sms_home_recommend_subject
 */
@TableName(value ="sms_home_recommend_subject")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmsHomeRecommendSubject implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long subjectId;

    /**
     * 
     */
    private String subjectName;

    /**
     * 
     */
    private Integer recommendStatus;

    /**
     * 
     */
    private Integer sort;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}