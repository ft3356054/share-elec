package com.sgcc.uap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;



/**
 * 微服务应用服务启动类 
 * 1、（@EnableDiscoveryClient）注解为链接微服务注册中心用，如实际环境中使用注册中心，请取消注释部分，
 *     与配置文件中相关注册中心配置信息结合使用。
 * @author zhangzz
 *
 */

@SpringBootApplication(scanBasePackages={"com.sgcc.uap","com.sgcc.uap.rest.annotation","com.sgcc.uap.mdd.runtime"})
//@EnableDiscoveryClient
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30) //HttpSession存放的信息直接放入redis中
@EnableScheduling
@EnableAsync //开启异步调用
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
