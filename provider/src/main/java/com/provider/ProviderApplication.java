package com.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

/**
 * @ClassName ProviderApplication
 * @Description: TODO 服务提供者启动类
 * @Author lxc
 * @Date 2020/2/21
 * @Version V1.0
 **/
@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
@MapperScan("mapper")
@EnableTransactionManagement
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
        System.out.println("服务提供者启动成功!");

        try{
            System.in.read();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}