package com.my.consumer.movie.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.consumer.movie.entity.User;


@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id); // 两个坑：1. @GetMapping不支持 2. @PathVariable得设置value
}
