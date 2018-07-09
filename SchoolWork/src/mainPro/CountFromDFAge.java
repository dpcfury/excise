package mainPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;

//根据总库中的身份证号码中关于年龄的字段，统计各个年龄段的人数。如：17岁以下20人、18岁30人……30岁2人。
public class CountFromDFAge {
	private static char[] id;// 用来暂存省份证的信息
	private static Connection con;// 与数据库的链接
	private static int sum = 0;
	private static int[] flag;// 进行统计的标志数组 第N位代表的是N岁的年龄段
	private static int yearOfBir;
	
	public static void main(String args[]) {
	
		init();
		
		try {

			PreparedStatement pstmt = con
					.prepareStatement("select sfzh from student where xb='女'");
			ResultSet result =pstmt.executeQuery();
			while(result.next()){
				//业务逻辑处理
				//获得字段并放入byte数组
				id=result.getString(1).toCharArray();
				//从charArray中去除特定的年份的四个字节组成出生的年
				
//				for(int i=0;i<id.length;i++){
//					System.out.print("第"+i+"个" +id[i]+"\t");
//					
//				}
				yearOfBir=getYear(id);
				//进行年龄的判断
				judge(yearOfBir);
				sum++;
				
			}
			System.out.println("sum=="+sum);
			printResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 初始化
	public static void init() {

		flag = new int[50];
		con = DBConnection.getConnection();
	}

	// 从id数组中获得想要的一部分组成年份
	public static int getYear(char[] res) {
		String temp = new String(res, 6, 4);
		return Integer.parseInt(temp);

	}
	
	//年龄的判断和统计人数
	public static void judge(int year){
		int age =2014-year;
		//判断统计
		if(age<17){
			flag[16]++;
		}
		else{
			flag[age]++;
		}
	}
	
	public static void printResult(){
		int count=0;
		for(int i=16;i<50;i++){
			if(i==16){
				System.out.println("小于17岁的人数为:"+flag[i]+"\n");
			}
			else{
				System.out.println(i+"岁的人数为:"+flag[i]+"\n");
			}
			count+=flag[i];
		}
		System.out.println("count=:"+count+"\n");
		
	}
}
