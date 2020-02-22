package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName CustomerApplication
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/21
 * @Version V1.0
 **/
@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class);
        System.out.println("消费端启动成功!");
    }
}
