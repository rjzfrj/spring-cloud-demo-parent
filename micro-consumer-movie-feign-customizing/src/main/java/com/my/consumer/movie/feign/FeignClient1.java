package com.my.consumer.movie.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.consumer.config.Configuration2;



@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = Configuration2.class)
public interface FeignClient1 {
  @RequestMapping(value = "/eureka/apps/{serviceName}")
  public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}