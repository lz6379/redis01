package com.atguigu;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App2
{
    public static void main( String[] args )
    {
        Jedis jedis_M=new Jedis("192.168.1.65",6379);
        Jedis jedis_S=new Jedis("192.168.1.65",6380);
        jedis_M.lpush("k9","keke","aiai","hehe");
        System.out.println(jedis_S.lrange("k9",0,-1));
    }
}
