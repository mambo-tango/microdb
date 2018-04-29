package com.tango.microdb;

import java.util.ArrayList;
import java.util.List;

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
        List<String> list = new ArrayList<String>();
        list.add("test");
        list.add("add new remote branch");
        list.add("modify master");
        list.add("fix bug");
        list.add("tango running...");
        list.add("master merge other");
        SpringApplication.run(App.class, args);
    }
}
