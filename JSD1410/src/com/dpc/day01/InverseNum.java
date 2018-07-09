package com.dpc.day01;

import java.util.Scanner;

public class InverseNum {

	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int num =sc.nextInt();
		
		StringBuilder temp =new StringBuilder(String.valueOf(num));
		temp.reverse();
		
		System.out.println(temp);
		
	}
}
