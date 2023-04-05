package com.baizhi.controller;

import com.baizhi.common.ResultVo;
import com.baizhi.common.pageVo;
import com.baizhi.entity.SmsHomeAdvertise;
import com.baizhi.service.SmsHomeAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dongHua
 * @create 2022/12/27 17:44
 * FileName: SmsHomeAdvertiseController
 */
@RestController
@RequestMapping("home")
@CrossOrigin
public class SmsHomeAdvertiseController {
    @Autowired
    private SmsHomeAdvertiseService smsHomeAdvertiseService;
    @RequestMapping("advertise/list")
    public ResultVo findLimit(String name,Integer type,String endTime,@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
            try{
                pageVo pageVo = smsHomeAdvertiseService.queryLimit(name,type,endTime,pageNum, pageSize);
                return new ResultVo().setCode(200).setMessage("成功").setData(pageVo);
            }catch (Exception e){
                    String s = "网络错误";
                    return  new ResultVo().setMessage(s);
            }
    }
    @RequestMapping("/advertise/update/status/{id}")
    public ResultVo update(@PathVariable Integer id,Integer status){
        try{
            smsHomeAdvertiseService.changeOneStatus(id,status);
            return new ResultVo().setCode(200).setMessage("成功").setData(1);
        }catch (Exception e){
            String s = "网络错误";
            return  new ResultVo().setMessage(s);
        }
    }
    @RequestMapping("/advertise/update/{id}")
    public ResultVo updateById(@PathVariable Integer id,@RequestBody SmsHomeAdvertise smsHomeAdvertise){
        try{
            smsHomeAdvertiseService.update(id,smsHomeAdvertise);
            return new ResultVo().setCode(200).setMessage("成功").setData(smsHomeAdvertise);
        }catch (Exception e){
            String s = "网络错误";
            return  new ResultVo().setMessage(s);
        }
    }
    @GetMapping("advertise/{id}")
    public ResultVo findById(@PathVariable Integer id){
        try{
            SmsHomeAdvertise smsHomeAdvertise = smsHomeAdvertiseService.queryById(id);
            return new ResultVo().setCode(200).setMessage("成功").setData(smsHomeAdvertise);
        }catch (Exception e){
            String s = "网络错误";
            return  new ResultVo().setMessage(s);
        }
    }
    @RequestMapping("advertise/create")
    public ResultVo addOne(@RequestBody SmsHomeAdvertise smsHomeAdvertise) {
        try{
            System.out.println(smsHomeAdvertise);
            smsHomeAdvertiseService.addOne(smsHomeAdvertise);
            return new ResultVo().setCode(200).setMessage("成功").setData(1);
        }catch (Exception e){
            String s = "网络错误";
            return  new ResultVo().setMessage(s);
        }
    }
    @RequestMapping("advertise/delete")
    public ResultVo deleteByIds(@RequestParam(value = "ids",required = true) List<Integer> ids) {
        try{
           smsHomeAdvertiseService.deleteIds(ids);
           return new ResultVo().setCode(200).setMessage("成功").setData(1);
        }catch (Exception e){
            String s = "网络错误";
            return  new ResultVo().setMessage(s);
        }
    }

}
