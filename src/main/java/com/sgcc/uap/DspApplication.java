package com.sgcc.uap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.client.RestTemplate;

import com.taobao.pandora.boot.PandoraBootstrap;
/**
 * 微服务应用服务启动类 
 * 1、（@EnableDiscoveryClient）注解为链接微服务注册中心用，如实际环境中使用注册中心，请取消注释部分，
 *     与配置文件中相关注册中心配置信息结合使用。
 * 2、如果不使用分布式服务总线，需要将SpringBootApplication注解注释掉
 *
 */
//@SpringBootApplication(scanBasePackages={"com.sgcc.uap","com.sgcc.uap.rest.annotation","com.sgcc.uap.mdd.runtime"})
//@EnableDiscoveryClient
public class DspApplication {
	 @Bean
	    public EDASConfigContextRefresher edasConfigContextRefresher(ContextRefresher contextRefresher){
	        return new EDASConfigContextRefresher(contextRefresher);
	    }
	    @Bean
	    public ConfigurationPropertiesConfig configurationPropertiesConfig(){
	        return new ConfigurationPropertiesConfig();
	    }
	    @Bean
	    @LoadBalanced
	    RestTemplate restTemplate(){
	        return new RestTemplate();
	    }
		
		public static void main(String[] args) {
	      PandoraBootstrap.run(args);
	      ConfigurableApplicationContext context = SpringApplication.run(DspApplication.class, args);
	      ConfigurableEnvironment env = context.getEnvironment();
	      PandoraBootstrap.markStartupAndWait();
		}
}
