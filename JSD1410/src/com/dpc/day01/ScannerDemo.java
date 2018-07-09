package com.dpc.day01;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入总秒数:");
		int userInput =sc.nextInt();
		
		int hour=userInput/3600;
		int min=userInput%3600/60;
		int sec=userInput%60;
		
		System.out.println(hour+"小时"+min+"分"+sec+"秒");
	}
	
}
