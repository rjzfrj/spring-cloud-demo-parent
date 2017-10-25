package com.my.consumer.movie.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.my.consumer.config.Configuration1;
import com.my.consumer.movie.entity.User;

import feign.Param;
import feign.RequestLine;


/**
 * 由于使用了 configuration =Configuration1.class  在Configuration1 中使用了feign的本身的配置
 * 这样在UserFeignClient2 中不在可以使用springvmc的注解必须使用feign的注解如下所示
 *
 */
@FeignClient(name = "microservice-provider-user",configuration=Configuration1.class)
public interface UserFeignClient {
	  @RequestLine("GET /simple/{id}")
	  public User findById(@Param("id") Long id);
}
