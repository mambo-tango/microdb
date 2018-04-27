package com.tango.microdb.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;

@Configuration
@PropertySource("classpath:redisconfig/redis.properties")
public class RedisConfig {
    @Autowired
    private Environment env;
    
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig getJedisPoolConfig() {
        return new JedisPoolConfig();
    }
    
    @Bean
    public ShardedJedis getShardedJedis() {
        try {
            List<JedisShardInfo> shardList = new ArrayList<>();
            String shardedsStr = env.getProperty("spring.redis.shards");
            if (shardedsStr != null) {
                for(String hostAndPorts: shardedsStr.split(";")) {
                    String[] hostAndPort = hostAndPorts.split(":");
                    JedisShardInfo info = new JedisShardInfo(hostAndPort[0], Integer.valueOf(hostAndPort[1]), 3000);
                    shardList.add(info);
                }
            }
           
            return new ShardedJedis(shardList);
        } catch (Exception e) {
            throw new RuntimeException("无法加载资源文件!");
        }
//        try {
//            List<JedisShardInfo> shardList = new ArrayList<>();
//            int index = 1;
//            while(true){
//                //读取host
//                String host = env.getProperty("spring.redis.shard."+index+".host");
//                if(StringUtils.isEmpty(host)){
//                    break;
//                }
//                //读取port
//                String port = env.getProperty("spring.redis.shard."+index+".port");
//                JedisShardInfo info = new JedisShardInfo(host, Integer.valueOf(port), 3000);
//                shardList.add(info);
//                index++;
//            }
//            if(shardList.size() == 0){
//                //无法加载redis
//                throw new IOException();
//            }
//            return new ShardedJedis(shardList);
//        } catch (Exception e) {
//            throw new RuntimeException("无法加载资源文件!");
//        }
    }

//    @Bean
//    public ShardedJedisPool getJedisPool() {
//        try {
//            List<JedisShardInfo> shardList = new ArrayList<>();
//            int index = 1;
//            while(true){
//                //读取host
//                String host = env.getProperty("spring.redis.shard."+index+".host");
//                if(StringUtils.isEmpty(host)){
//                    break;
//                }
//                //读取port
//                String port = env.getProperty("spring.redis.shard."+index+".port");
//                JedisShardInfo info = new JedisShardInfo(host, Integer.valueOf(port), 0, "");
////                //读取password
////                String password = env.getProperty("spring.redis.shard."+index+".password");
////                if(!StringUtils.isEmpty(password)){
////                    info.setPassword(password);
////                }
//                shardList.add(info);
//                index++;
//            }
//            if(shardList.size() == 0){
//                //无法加载redis
//                throw new IOException();
//            }
//            return new ShardedJedisPool(getJedisPoolConfig(), shardList);
//        } catch (Exception e) {
//            throw new RuntimeException("无法加载资源文件!");
//        }
//    }
}
