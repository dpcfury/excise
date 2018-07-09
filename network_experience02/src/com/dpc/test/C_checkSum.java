package com.dpc.test;

import java.util.ArrayList;
import java.util.List;

public class C_checkSum {

	
	public static void main(String []args){
		List<Short> buff=new ArrayList<>();
		for(int i =0;i<20;i++){
			buff.add((short)i);
		}
		
		System.out.println("sum=="+checksum(buff));
		
	}
	
	public static Short checksum(List<Short> buff){
		long sum=0;
		for(int i=0;i<buff.size();i++){
			System.out.println("i="+i+"sum:"+sum);
			sum +=buff.get(i);
			sum = ((sum>>16)+(sum & 0xffff));
		}
		return (short) ~sum;
		
	}
}
