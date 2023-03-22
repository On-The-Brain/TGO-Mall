package com.mall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

@SpringBootApplication
@Slf4j
public class TgoMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(TgoMallApplication.class, args);
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("Local HostAddress: "+addr.getHostAddress());
            Runtime.getRuntime().exec("cmd   /c   start   http://"+addr.getHostAddress()+":8082/");//可以指定自己的路径
            log.info("---------------------------------------------------");
            log.info("\n访问地址："+"http://"+addr.getHostAddress()+":8080/");
            log.info("---------------------------------------------------");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
