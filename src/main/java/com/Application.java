package com;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling // 开启定时任务功能
@SpringBootApplication
@MapperScan("com.mapper")
public class Application {
      private static Logger logger = LoggerFactory.getLogger(Application.class);
      public static void main(String[] args){
          SpringApplication.run(Application.class,args);
          logger.info("定时任务页面管理地址:{}", "http://localhost:8089/scheduled/task/taskList");
      }
}
