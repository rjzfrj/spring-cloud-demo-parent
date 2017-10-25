package com.my.consumer.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;
@Configuration
public class Configuration1 {
	@Bean
	  public Contract feignContract() {
	    return new feign.Contract.Default(); //这句很关键指定了feign的契约为默认契约这样就是使用了feign本身的契约了
	  }
	  @Bean
	  Logger.Level feignLoggerLevel() {
	    return Logger.Level.FULL;
	  }
}
