package com.my.consumer.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my.consumer.movie.entity.User;
import com.my.consumer.movie.feign.FeignClient1;
import com.my.consumer.movie.feign.FeignClient3;
import com.my.consumer.movie.feign.UserFeignClient;

@RestController
public class MovieController {
	 @Autowired
	  private FeignClient1 userFeignClient;
	 @Autowired
	  private FeignClient3 feignClient3;
	 @Autowired
	  private UserFeignClient userFeignClient2;

	  @GetMapping("/{serviceName}")
	  public String findById(@PathVariable String serviceName) {
	    return this.userFeignClient.findServiceInfoFromEurekaByServiceName(serviceName);
	  }
	  
	  
	  @GetMapping("/movie2/{id}")
	  public User findById2(@PathVariable Long id) {
	    return this.userFeignClient2.findById(id);
	  }
	  
	  @GetMapping("/movie3/{id}")
	  public User findById3(@PathVariable Long id) {
	    return this.feignClient3.findById(id);
	  }

}
