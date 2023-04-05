package com.baizhi.service;

import com.baizhi.common.pageVo;
import com.baizhi.entity.SmsHomeRecommendSubject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Lenovo
* @description 针对表【sms_home_recommend_subject(首页推荐专题表)】的数据库操作Service
* @createDate 2022-12-28 17:12:24
*/
public interface SmsHomeRecommendSubjectService extends IService<SmsHomeRecommendSubject> {
    pageVo queryLimit(String subjectName, Integer recommendStatus, Integer pageNUm, Integer pageSize);
    void updateBatchStatus(List<Long> ids,Integer recommendStatus);
    void updateSort(Long id,Integer sort);
    void deleteIds(List<Long> ids);
}
