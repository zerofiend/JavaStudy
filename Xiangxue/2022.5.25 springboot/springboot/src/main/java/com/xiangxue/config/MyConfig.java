package com.xiangxue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 在springboot中没有xml配置文件，因此我们使用一个java类做配置
 */
@Configuration  //  是@Component的衍生注解，一般放在配置类中
public class MyConfig implements WebMvcConfigurer {
    //  放行resources下static中的静态资源

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:static/");
    }
}
