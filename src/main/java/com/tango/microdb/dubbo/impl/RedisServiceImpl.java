package com.tango.microdb.dubbo.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.tango.microdb.dubbo.RedisService;

import redis.clients.jedis.ShardedJedis;

@Service(version = "1.0.0")
public class RedisServiceImpl implements RedisService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);
    
    public static final String TRACK_PREFFIX = "T_INFO_";
    
    @Autowired
    ShardedJedis shardedJedis;
    
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate jdbc;

//    @Override
//    public String setRedis(String key, String value) {
//        
//        for (int i = 0; i < 10; i++) {
//            shardedJedis.set(i+key, i+value);
//        }
//        return null;
//    }

    @Override
    public String getRedis(String key) {
//        List<String> list = shardedJedis.lrange(TRACK_PREFFIX + key, 0, 1);
//        LOGGER.info(key + " -----> " + list.toString());
//        return list.toString();
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        jdbc.execute("insert into test_record(source, waybill_no) value('"+ip+"','"+key+"')");
        LOGGER.info("插入数据成功 waybillNo：" + key);
        return "1";
    }

//    @Override
//    public void delRedis(String key) {
//        shardedJedis.del(TRACK_PREFFIX + key);
//        
//    }
    
}
