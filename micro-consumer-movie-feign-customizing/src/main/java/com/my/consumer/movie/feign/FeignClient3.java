package com.my.consumer.movie.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.consumer.config.Configuration2;
import com.my.consumer.movie.entity.User;




@FeignClient(name = "microservice-provider-user2",configuration=Configuration2.class)
public interface FeignClient3 {
  @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
  public User findById(@PathVariable("id") Long id);
}