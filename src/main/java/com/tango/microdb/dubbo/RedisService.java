package com.tango.microdb.dubbo;

public interface RedisService {
    /**
     * 
     * @param key
     * @param value
     * @return
     */
//    public String setRedis(String key, String value);
    
    /**
     * 
     * @param key
     * @return
     */
    String getRedis(String key);
    
    /**
     * 删除key
     * @param key
     */
//    public void delRedis(String key);
}
