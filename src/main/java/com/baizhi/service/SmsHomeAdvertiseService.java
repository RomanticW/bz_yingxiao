package com.baizhi.service;

import com.baizhi.common.pageVo;
import com.baizhi.entity.SmsHomeAdvertise;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
* @author Lenovo
* @description 针对表【sms_home_advertise(首页轮播广告表)】的数据库操作Service
* @createDate 2022-12-27 17:12:20
*/
public interface SmsHomeAdvertiseService{
    pageVo queryLimit(String name,Integer type,String endTime,Integer pageNum,Integer pageSize);
    void update(Integer id,SmsHomeAdvertise smsHomeAdvertise);
    SmsHomeAdvertise queryById(Integer id);
    void changeOneStatus(Integer id,Integer status);
    void addOne(SmsHomeAdvertise smsHomeAdvertise);
    void deleteIds(List<Integer> ids);
}
