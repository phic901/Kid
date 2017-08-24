package com.seoulitelab.kididic.common.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@EnableRedisHttpSession
public class RedisSessionController {
	
	
	@Autowired
	private Environment env;
	
	@Bean
	public JedisConnectionFactory connectionFactory(){
		JedisConnectionFactory conn = new JedisConnectionFactory();
		conn.setHostName(env.getProperty("redis.host"));
		conn.setPort(Integer.valueOf(env.getProperty("redis.port")));
		conn.setDatabase(Integer.valueOf(env.getProperty("redis.database")));
		conn.setTimeout(1000);
		return conn;	
	}

	@Bean
	public CookieSerializer cookieSerializer(){
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		// 위 레디스 처럼 serializer 의 각종 설정 가능.
		// tomcat context 로 설정한 쿠키 기능들도 여기서 설정가능.
		return serializer;
	}
	
	/*	@Bean
	public RedisOperationsSessionRepository redisOperationsSessionRepository(JedisConnectionFactory jcf){
		RedisOperationsSessionRepository rosr = new RedisOperationsSessionRepository(jcf);
		rosr.setDefaultMaxInactiveInterval(10000);
		return rosr;
	}*/	
	

}
