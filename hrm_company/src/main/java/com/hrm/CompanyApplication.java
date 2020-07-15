package com.hrm;

import com.hrm.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

//1.配置springboot包扫描
@SpringBootApplication(scanBasePackages = "com.hrm")
//2.配置jpa注解的扫码
@EntityScan(value = "com.hrm.domain.company")
public class CompanyApplication {
    /***
     * 启动方法
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }

}
