package com.dpc.test;

//import java.util.Scanner;

import java.util.Scanner;

import org.junit.Test;

import com.dpc.triangle.TriangleCheck;

import junit.framework.TestCase;

//TriangleCheck 测试类
public class TestTrianglecheck extends TestCase{
	
	private TriangleCheck triangleCheck=new TriangleCheck();
	
	@Test
	public void testTriangleCheck(){
		//1.接受用户输入
		@SuppressWarnings("resource")
		Scanner reader =new Scanner(System.in);
		
		int fir,sec,third;//对应用户输入的三条边
		System.out.println("输入第一条边:");
		fir =reader.nextInt();
		System.out.println("输入第二条边:");
		sec=reader.nextInt();
		System.out.println("输入第三条边:");
		third=reader.nextInt();
		
		System.out.println("fir:"+fir+"sec:"+sec+"third:"+third);
		
		//2.进行三角形逻辑判断
		System.out.println(triangleCheck.whichKingTriangle(fir,sec,third));
		assertEquals("不是三角形", triangleCheck.whichKingTriangle(fir,sec,third));
		
		
	}
	
	@Test
	public void testIsTraingle(){
		assertTrue(triangleCheck.isTraingle(5, 12, 13));
	}
	
	@Test
	public void testIsEquilteral(){
		assertTrue(triangleCheck.isEquilteral(3, 3, 3));
	}
	
	@Test
	public void testIsIsosceles(){
		assertTrue(triangleCheck.isIsosceles(5, 5, 8));
	}
	
	@Test 
	public void testIsRight(){
		assertTrue(triangleCheck.isRight(3, 4, 5));
	}
	
	@Test
	public void testIsIsoAndRight(){
		assertTrue(!triangleCheck.isIsoAndRight(4, 4,6));
	}
	
}
