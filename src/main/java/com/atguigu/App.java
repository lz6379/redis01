package com.atguigu;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Jedis jedis_M=new Jedis("192.168.1.65",6379);
        User user=new User(1,"王强","123456");
        Map map=new HashMap();
        map.put("name",user.getName());
        map.put("pass",user.getPass());
        jedis_M.del("user");
        jedis_M.hmset("user",map);
        System.out.println(jedis_M.hgetAll("user"));
    }
}
