package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@Component  
@PropertySource("classpath:redis.properties")
public class JedisConfig {
	 	@Value("${redis.maxTotal}")
	    public Integer maxTotal;

	    @Value("${redis.host}")
	    public String host;

	    @Value("${redis.port}")
	    public Integer port;

	    @Value("${redis.timeout}")
	    private int timeout;
	 
	    @Value("${redis.jedis.pool.max-idle}")
	    private int maxIdle;
	 
	    @Value("${redis.jedis.pool.max-wait}")
	    private long maxWaitMillis;
	 
	    @Value("${redis.block-when-exhausted}")
	    private boolean  blockWhenExhausted;
	    @Bean
	    public JedisPoolConfig jedisPoolConfig() {
	        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
	        jedisPoolConfig.setMaxTotal(maxTotal);
	        jedisPoolConfig.setMaxIdle(maxIdle);
	        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
	        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
	        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
	        // 是否启用pool的jmx管理功能, 默认true
	        jedisPoolConfig.setJmxEnabled(true);
	        return jedisPoolConfig;
	    }

	    @Bean
	    public JedisPool jedisPool() {
	        JedisPool jedisPool = new JedisPool(host, port);
	        		//new JedisPool(jedisPoolConfig(), host, port, 20000, password);
	        return jedisPool;
	    }
	    
	    @Bean
	    public Jedis jedis() {
	    	return jedisPool().getResource();
	    }

}
