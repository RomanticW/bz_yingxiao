package com.baizhi.controller;

import com.baizhi.common.ResultVo;
import com.baizhi.common.pageVo;
import com.baizhi.service.SmsHomeRecommendSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dongHua
 * @create 2022/12/28 17:32
 * FileName: SmsHomeRecommendSubjectController
 */
@RestController
@CrossOrigin
@RequestMapping("home")
public class SmsHomeRecommendSubjectController {
    @Autowired
    private SmsHomeRecommendSubjectService smsHomeRecommendSubjectService;
    @RequestMapping("recommendSubject/list")
    public ResultVo queryLimit(String subjectName,Integer recommendStatus,Integer pageNum,Integer pageSize){
        try {
            pageVo pageVo = smsHomeRecommendSubjectService.queryLimit(subjectName, recommendStatus, pageNum, pageSize);
            return new ResultVo().setCode(200).setMessage("成功").setData(pageVo);
        }catch (Exception e){
            String s = "网络错误";
            return  new ResultVo().setMessage(s);
        }
    }
    @PostMapping("recommendSubject/update/recommendStatus")
    public ResultVo changeBatchStatus(@RequestParam(value = "ids",required = true) List<Long> ids,Integer recommendStatus){
        try {
            smsHomeRecommendSubjectService.updateBatchStatus(ids,recommendStatus);
            return new ResultVo().setCode(200).setMessage("成功").setData(1);
        }catch (Exception e){
            String s = "网络错误";
            return  new ResultVo().setMessage(s);
        }
    }
    @RequestMapping("/recommendSubject/update/sort/{id}")
    public ResultVo changeSort(@PathVariable Long id,Integer sort){
        try {
            System.out.println("----"+id);
            smsHomeRecommendSubjectService.updateSort(id,sort);
            return new ResultVo().setCode(200).setMessage("成功").setData(1);
        }catch (Exception e){
            String s = "网络错误";
            return  new ResultVo().setMessage(s);
        }
    }
    @RequestMapping("recommendSubject/delete")
    public ResultVo deleteByIds(@RequestParam(value = "ids",required = true) List<Long> ids) {
        try{
           smsHomeRecommendSubjectService.deleteIds(ids);
            return new ResultVo().setCode(200).setMessage("成功").setData(1);
        }catch (Exception e){
            String s = "网络错误";
            return  new ResultVo().setMessage(s);
        }
    }
}
