package com.my.consumer.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.my.consumer.movie.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {
	@Autowired
	  private RestTemplate restTemplate;

	  @GetMapping("/movie/{id}")
	  @HystrixCommand(fallbackMethod = "findByIdFallback")
	  public User findById(@PathVariable Long id) {
	    return this.restTemplate.getForObject("http://micro-provider-user/simple/" + id, User.class);
	  }

	  public User findByIdFallback(Long id) {
	    User user = new User();
	    user.setId(0L);
	    return user;
	  }

}
