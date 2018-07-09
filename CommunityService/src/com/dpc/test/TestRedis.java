package com.dpc.test;

import redis.clients.jedis.Jedis;

import com.dpc.pojo.Resident;

public class TestRedis {

	public static void main(String[] args) {
		Jedis jedis =new Jedis("172.25.33.162",6379);
		
		Resident resident =new Resident();
		resident.setName(jedis.hget("1220126304", "name"));
		resident.setAge(Integer.parseInt(jedis.hget("1220126304", "age")));
		resident.setSex(jedis.hget("1220126304","sex"));
		resident.setAddress(jedis.hget("1220126304", "address"));
		resident.setMoreInfoId(jedis.hget("1220126304","recordId"));
		resident.setID("1220126304");
		System.out.println(resident);
	}
}
