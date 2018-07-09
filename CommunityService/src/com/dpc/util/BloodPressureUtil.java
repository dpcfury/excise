package com.dpc.util;

//对测量值进行逻辑判断的工具类
public class BloodPressureUtil {
	
	//收缩压上限
	public static final int BLOODPRESSURE_HIGH=140;
	//收缩压上限
	public static final int BLOODPRESURE_LOW=90;
	//连续几次确定不正常的常量
	public static final int INNORMAL_COUNT=3;
	
	//判断一组收缩压和舒张压是否在正常范围内(后期要加上关于年龄的判断)
	public static boolean checkRecord(int high,int low){
		if(high>BLOODPRESSURE_HIGH||low>BLOODPRESURE_LOW){
			return false;
		}
		return true;
	}
}
