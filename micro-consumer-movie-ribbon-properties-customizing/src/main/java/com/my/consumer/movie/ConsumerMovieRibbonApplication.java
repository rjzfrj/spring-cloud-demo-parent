package com.my.consumer.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerMovieRibbonApplication 
{
	@Bean
	@LoadBalanced   //使用ribbon 十分简单1 加依赖 spring-cloud-starter-ribbon，2在ribbon需要加这个注解
	public RestTemplate restTemplate() {
			return new RestTemplate();
	}
    public static void main( String[] args )
    {
    	SpringApplication.run(ConsumerMovieRibbonApplication.class, args);
    }
}
