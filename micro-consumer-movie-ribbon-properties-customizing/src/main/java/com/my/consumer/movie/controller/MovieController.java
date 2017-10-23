package com.my.consumer.movie.controller;

import org.omg.IOP.ServiceIdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.my.consumer.movie.entity.User;

@RestController
public class MovieController {
	 @Autowired
	  private RestTemplate restTemplate;
	 @Value("${user.userServicePath}")
	  private String userServicePath;
	  @Autowired
	  private LoadBalancerClient loadBalancerClient;

	  @GetMapping("/movie/{id}")
	  public User findById(@PathVariable Long id) {
		 ServiceInstance serviceInstance= this.loadBalancerClient.choose("microservice-provider-user");
		 System.out.println("==="+serviceInstance.getPort());
	    return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
//	    return this.restTemplate.getForObject(this.userServicePath + id, User.class);
	  }

}
