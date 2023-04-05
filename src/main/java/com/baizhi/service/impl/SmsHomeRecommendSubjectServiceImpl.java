package com.baizhi.service.impl;

import com.baizhi.common.pageVo;
import com.baizhi.entity.SmsHomeAdvertise;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baizhi.entity.SmsHomeRecommendSubject;
import com.baizhi.service.SmsHomeRecommendSubjectService;
import com.baizhi.mapper.SmsHomeRecommendSubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
* @author Lenovo
* @description 针对表【sms_home_recommend_subject(首页推荐专题表)】的数据库操作Service实现
* @createDate 2022-12-28 17:12:24
*/
@Service
@Transactional
public class SmsHomeRecommendSubjectServiceImpl extends ServiceImpl<SmsHomeRecommendSubjectMapper, SmsHomeRecommendSubject>
    implements SmsHomeRecommendSubjectService{
    @Autowired
    private SmsHomeRecommendSubjectMapper smsHomeRecommendSubjectMapper;
    @Override
    public pageVo queryLimit(String subjectName, Integer recommendStatus, Integer pageNum, Integer pageSize) {
        Page<SmsHomeRecommendSubject> pages = new Page<>(pageNum, pageSize);
        QueryWrapper<SmsHomeRecommendSubject> wrapper = new QueryWrapper<>();
        if(StringUtils.hasText(subjectName)){
            wrapper.like("subject_name",subjectName);
        }
        if(recommendStatus!=null){
            wrapper.eq("recommend_status",recommendStatus);
        }
        IPage<SmsHomeRecommendSubject> IPage = smsHomeRecommendSubjectMapper.selectPage(pages, wrapper);
        List<SmsHomeRecommendSubject> list = new ArrayList<>();
        for (SmsHomeRecommendSubject record : IPage.getRecords()) {
            list.add(record);
        }
        Integer total = Math.toIntExact(pages.getTotal());
        Integer totalPage = Math.toIntExact(pages.getPages());
        return new pageVo().setPageNum(pageNum).setPageSize(pages.getRecords().size()).setTotalPage(totalPage).setTotal(total).setList(list);
    }

    @Override
    public void updateBatchStatus(List<Long> ids, Integer recommendStatus) {
        for (SmsHomeRecommendSubject selectBatchId : smsHomeRecommendSubjectMapper.selectBatchIds(ids)) {
            selectBatchId.setRecommendStatus(recommendStatus);
            smsHomeRecommendSubjectMapper.updateById(selectBatchId);
        }
    }

    @Override
    public void updateSort(Long id, Integer sort) {
        SmsHomeRecommendSubject smsHomeRecommendSubject = smsHomeRecommendSubjectMapper.selectById(id);
        smsHomeRecommendSubject.setSort(sort);
        smsHomeRecommendSubjectMapper.updateById(smsHomeRecommendSubject);
    }

    @Override
    public void deleteIds(List<Long> ids) {
        smsHomeRecommendSubjectMapper.deleteBatchIds(ids);
    }
}




