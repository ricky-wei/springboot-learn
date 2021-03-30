package com.wrq;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author weiruiqi
 * @date 2021/3/31 0:09
 */
@EnableSwagger2Doc
@SpringBootApplication
public class SwaggerUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerUiApplication.class, args);
    }
}
