package com.atguigu;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class TestTransaction
{
    public static void main( String[] args )
    {
        int consume=20;
        Jedis jedis_M=new Jedis("192.168.1.65",6379);
        jedis_M.watch("bank1");
        int bank1 = Integer.parseInt(jedis_M.get("bank1"));
        //jedis_M.incrBy("bank1",50);
        if (bank1<consume){
            jedis_M.unwatch();
            System.out.println("费用不足");
            return;
        }else {
            Transaction multi = jedis_M.multi();
            multi.decrBy("bank1",consume);
            multi.incrBy("bank2",consume);
            List<Object> list = multi.exec();
            list.stream().forEach(System.out::print);
            System.out.println(jedis_M.get("bank1"));
            System.out.println(jedis_M.get("bank2"));
        }
    }
}
