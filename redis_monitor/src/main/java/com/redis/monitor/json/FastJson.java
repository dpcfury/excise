package com.redis.monitor.json;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;


/**
 * @JSONField(serialize=false) 
 * 在属性get方法上加serialize=false可设置属性不输出 
 * name="" 可设置序列化后的属性名称   
 * 试用场景  实体对象往协议层数据转换
 * @author Fe
 *
 */
public class FastJson {
	
	public static final Logger logger = LoggerFactory.getLogger(FastJson.class);
	
	public static SerializeConfig mapping = new SerializeConfig();
	
	public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	static {
		mapping.put(Date.class, new SimpleDateFormatSerializer(DEFAULT_DATE_FORMAT));
	}
	
	public static <T> String toJson(T t) {
		return JSON.toJSONString(t, mapping);
	}
	
	public static <T> T fromJson(String json,Class<T> t) {
		return (T) JSON.parseObject(json, t);
	}
	
	public static JSONObject fromJson(String json) {
		return JSON.parseObject(json);
	}
	
	
	public static <T> List<T> jsonToList(String json,Class<T> t) {
		return (List<T>) JSON.parseArray(json,t);
	}

	public static JSONArray jsonToList(String json) {
		return JSON.parseArray(json);
	}
	
	
	
	
	
}
