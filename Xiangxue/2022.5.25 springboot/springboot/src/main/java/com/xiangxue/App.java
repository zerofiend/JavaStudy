package com.xiangxue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot的启动类
 * 这里面的写法是完全固定的
 * 启动类推荐放在所有类的父包中，启动时会自动扫描同一级包或下级所有包中的类
 */
@SpringBootApplication  //  springboot的核心注解
public class App {
    public static void main(String[] args) {
        // 启动springboot
        SpringApplication.run(App.class, args);
    }
}
