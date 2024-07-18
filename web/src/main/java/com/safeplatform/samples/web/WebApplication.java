package com.safeplatform.samples.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableScheduling
@EnableDiscoveryClient
@EnableFeignClients
//@ImportResource("classpath:META-INF/spring/user.bean.xml")
@RefreshScope
public class WebApplication {
  private static final Logger LOGGER = LoggerFactory.getLogger(WebApplication.class);

  public static void main(String[] args) {
    try {
      SpringApplication.run(WebApplication.class, args);
    } catch (Throwable e) {
      LOGGER.error("start up failed.", e);
    }
  }

}
