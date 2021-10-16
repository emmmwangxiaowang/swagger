package com.wang.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/10/16 0016
 */

//将swagger交给springboot管理
@Configuration
//开启swagger2
@EnableSwagger2
public class SwaggerConfig {

    //配置swagger的bean实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //RequestHandlerSelectors配置要扫描的接口的方式
                //basePackage: 指定要扫描的包  一般用这个, basePackage("com.wang.swagger.controller.helloController)
                //any()扫描全部
                //none()全不扫描
                //withClassAnnotation扫描类上注解,参数是一个注解的反射对象
                //withMethodAnnotation扫描方法上的注解
                //RequestHandlerSelectors.withClassAnnotation(GetMapping.class)  只会去扫描类上面有GetMapping注解的类
                .apis(RequestHandlerSelectors.withClassAnnotation(GetMapping.class))
                //.paths 过滤什么路径
                .paths(PathSelectors.ant("/wang/**"))
                .build();
        //这个apiInfo没有没有set方法，所以必须通过构造器去创建
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("王小王的swaggerAPI文档",
                "加油吧",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
