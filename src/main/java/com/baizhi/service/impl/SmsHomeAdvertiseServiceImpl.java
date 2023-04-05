package com.baizhi.service.impl;

import com.baizhi.common.pageVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baizhi.entity.SmsHomeAdvertise;
import com.baizhi.service.SmsHomeAdvertiseService;
import com.baizhi.mapper.SmsHomeAdvertiseMapper;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author Lenovo
* @description 针对表【sms_home_advertise(首页轮播广告表)】的数据库操作Service实现
* @createDate 2022-12-27 17:12:20
*/
@Service
@Transactional
public class SmsHomeAdvertiseServiceImpl implements SmsHomeAdvertiseService{
    @Resource
    private SmsHomeAdvertiseMapper smsHomeAdvertiseMapper;
    @Override
    public pageVo queryLimit(String name,Integer type,String endTime,Integer pageNum, Integer pageSize) {
        Page<SmsHomeAdvertise> pages = new Page<>(pageNum, pageSize);
        QueryWrapper<SmsHomeAdvertise> wrapper = new QueryWrapper<>();
        if(StringUtils.hasText(name)){
            wrapper.like("name",name);
        }
        if(type!=null){
            wrapper.eq("type",type);
        }
        if(StringUtils.hasText(endTime)){
            String start = endTime + " 00:00:00";
            String end = endTime + " 23:59:59";
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date start1 = sdf.parse(start);
                Date end1 = sdf.parse(end);
                wrapper.ge("end_time",start1);
                wrapper.le("end_time",end1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        IPage<SmsHomeAdvertise> smsHomeAdvertiseIPage = smsHomeAdvertiseMapper.selectPage(pages, wrapper);
        List<SmsHomeAdvertise> list = new ArrayList<>();
        for (SmsHomeAdvertise record : smsHomeAdvertiseIPage.getRecords()) {
            list.add(record);
        }
        Integer total = Math.toIntExact(pages.getTotal());
        Integer totalPage = Math.toIntExact(pages.getPages());
        return new pageVo().setPageNum(pageNum).setPageSize(pages.getRecords().size()).setTotalPage(totalPage).setTotal(total).setList(list);
    }

    @Override
    public void update(Integer id,SmsHomeAdvertise smsHomeAdvertise) {
        System.out.println(smsHomeAdvertise);
        smsHomeAdvertiseMapper.updateById(smsHomeAdvertise);
    }

    @Override
    public SmsHomeAdvertise queryById(Integer id) {
        SmsHomeAdvertise smsHomeAdvertise = smsHomeAdvertiseMapper.selectById(id);
        return smsHomeAdvertise;
    }

    @Override
    public void changeOneStatus(Integer id,Integer status) {
        SmsHomeAdvertise smsHomeAdvertise = new SmsHomeAdvertise();
        smsHomeAdvertise.setId(id.longValue());
        smsHomeAdvertise.setStatus(status);
        smsHomeAdvertiseMapper.updateById(smsHomeAdvertise);
    }

    @Override
    public void addOne(SmsHomeAdvertise smsHomeAdvertise) {
        smsHomeAdvertise.setStartTime(new Date());
        smsHomeAdvertise.setEndTime(new Date());
        smsHomeAdvertiseMapper.insert(smsHomeAdvertise);
    }

    @Override
    public void deleteIds(List<Integer> ids) {
        smsHomeAdvertiseMapper.deleteBatchIds(ids);
    }
}




