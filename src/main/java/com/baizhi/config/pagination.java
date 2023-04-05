package com.baizhi.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author dongHua
 * @create 2022/12/8 14:56
 * FileName: paginationInterceptor
 */
@Configuration
public class pagination {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    @Profile({"dev","test"})  //只应用在开发环境和测试环境
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000);//ms  设置sql执行的最大时间，如果超过则报错不执行
        performanceInterceptor.setFormat(true);// 开启格式化
        return performanceInterceptor;
    }
}
