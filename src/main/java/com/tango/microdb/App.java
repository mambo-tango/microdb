package com.tango.microdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class App {
    
//    @Autowired
//    RedisService rs;
    
//    @RequestMapping("/")
//    void test() {
////       rs.setRedis("_dubbo_test_key", "_测试数据_test_value");
//        System.out.println(rs.getRedis("887056912592317862"));
//        
//    }
    
    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }
}
