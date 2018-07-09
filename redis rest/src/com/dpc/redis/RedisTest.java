package com.dpc.redis;

import java.util.HashMap;
import java.util.Map;

import com.dpc.pojo.Resident;

import redis.clients.jedis.Jedis;

public class RedisTest {
	static Jedis jedis = new Jedis("172.25.33.162", 6379);
	
	public static void main(String[] args) {

//		 jedis.lpush("hl", "beautiful");
//		//
//		 jedis.lpush("hl", "cute");
//		System.out.println(jedis.lrange("hl", 0, -1));

//		jedis.hset("1220126304", "name", "dpc");
//		jedis.hset("1220126304", "age", "21");
//		jedis.hset("1220126304", "sex", "man");
//		jedis.hset("1220126304", "address", "suzhou,js,china");
//		jedis.hset("1220126304", "email", "978364051");
//
//		System.out.println(jedis.hkeys("1220126304"));
		
//		Map<String,String> map=new HashMap<String,String>();
//		map.put("name","wwt");
//		map.put("age","20");
//		map.put("email","978364051@qq.com");
//		
//		jedis.hmset("shuaibi", map);
//		
		System.out.println(jedis.hvals("shuaibi"));
		initData();
		Resident resident =new Resident();
		resident.setName(jedis.hget("1220126304", "name"));
		resident.setAge(Integer.parseInt(jedis.hget("1220126304", "age")));
		resident.setSex(jedis.hget("1220126304","sex"));
		resident.setAddress(jedis.hget("1220126304", "address"));
		resident.setMoreInfoId(jedis.hget("1220126304","recordId"));
		System.out.println(resident);
	}
	
	
	public static void initData(){
		
		//初始化部分数据
		
		Map<String ,String> rsInfo =new HashMap<String,String>();
		rsInfo.put("name", "dpc");
		rsInfo.put("age", "21");
		rsInfo.put("sex", "man");
		rsInfo.put("address", "suzhou,js,china");
		rsInfo.put("recordId", "1220126304_record");
		
		jedis.hmset("1220126304", rsInfo);
		
	}
	
}