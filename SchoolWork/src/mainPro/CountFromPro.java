package mainPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import util.DBConnection;

//负责统计来自各个省的男生有多少人
public class CountFromPro {

	private static char[] id;// 用来暂存省份证的信息
	private static Connection con;// 与数据库的链接
	private static int sum = 0;
	private static int proFlag;
	private static Map<String,Integer> countResult;
	
	public static void main(String[] args) {

		init();
		try{
			PreparedStatement pstmt =con.prepareStatement("select sfzh from student");
			ResultSet result =pstmt.executeQuery();
			while(result.next()){
				//抽取身份证的前两位
				id=result.getString(1).toCharArray();
				proFlag =getFlag(id);
				//处理统计
				countAll(proFlag);
				sum++;
			}
			System.out.println("男生共计"+sum+"\n");
			//打印输出结果
			printResult();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}

	//处理统计的方法
	private static void countAll(int flag) {
		int temp;
		switch (flag) {
		case 11:
			temp= countResult.get("北京");
			countResult.put("北京",temp+1);
			break;
		case 12:
			temp= countResult.get("天津");
			countResult.put("天津",temp+1);
			break;
		case 13:
			temp= countResult.get("河北");
			countResult.put("河北",temp+1);
			break;
		case 14:
			temp= countResult.get("山西");
			countResult.put("山西",temp+1);
			break;
		case 15:
			temp= countResult.get("内蒙古");
			countResult.put("内蒙古",temp+1);
			break;
		case 21:
			temp= countResult.get("辽宁");
			countResult.put("辽宁",temp+1);
			break;
		case 22:
			temp= countResult.get("吉林");
			countResult.put("吉林",temp+1);
			break;
		case 23:
			temp= countResult.get("黑龙江");
			countResult.put("黑龙江",temp+1);
			break;
		case 31:
			temp= countResult.get("上海");
			countResult.put("上海",temp+1);
			break;
		case 32:
			temp= countResult.get("江苏");
			countResult.put("江苏",temp+1);
			break;
		case 33:
			temp= countResult.get("浙江");
			countResult.put("浙江",temp+1);
			break;
		case 34:
			temp= countResult.get("安徽");
			countResult.put("安徽",temp+1);
			break;
		case 35:
			temp= countResult.get("福建");
			countResult.put("福建",temp+1);
			break;
		case 36:
			temp= countResult.get("江西");
			countResult.put("江西",temp+1);
			break;
		case 37:
			temp= countResult.get("山东");
			countResult.put("山东",temp+1);
			break;
		case 41:
			temp= countResult.get("河南");
			countResult.put("河南",temp+1);
			break;
		case 42:
			temp= countResult.get("湖北");
			countResult.put("湖北",temp+1);
			break;
		case 43:
			temp= countResult.get("湖南");
			countResult.put("湖南",temp+1);
			break;
		case 44:
			temp= countResult.get("广东");
			countResult.put("广东",temp+1);
			break;
		case 45:
			temp= countResult.get("广西");
			countResult.put("广西",temp+1);
			break;
		case 46:
			temp= countResult.get("海南");
			countResult.put("天津",temp+1);
			break;
		case 50:
			temp= countResult.get("重庆");
			countResult.put("重庆",temp+1);
			break;
		case 51:
			temp= countResult.get("四川");
			countResult.put("四川",temp+1);
			break;
		case 52:
			temp= countResult.get("贵州");
			countResult.put("贵州",temp+1);
			break;
		case 53:
			temp= countResult.get("云南");
			countResult.put("云南",temp+1);
			break;
		case 54:
			temp= countResult.get("西藏");
			countResult.put("西藏",temp+1);
			break;
		case 61:
			temp= countResult.get("陕西");
			countResult.put("陕西",temp+1);
			break;
		case 62:
			temp= countResult.get("甘肃");
			countResult.put("甘肃",temp+1);
			break;
		case 63:
			temp= countResult.get("青海");
			countResult.put("青海",temp+1);
			break;
		case 64:
			temp= countResult.get("宁夏");
			countResult.put("宁夏",temp+1);
			break;
		case 65:
			temp= countResult.get("新疆");
			countResult.put("新疆",temp+1);
			break;
		}
	}

	//提取身份证的前两位
	private static int getFlag(char [] res) {
		String temp= new String(res, 0, 2);
//		System.out.println("temp="+temp);
		
		return Integer.parseInt(temp);
	}

	// 初始化
	public static void init() {
		
		con = DBConnection.getConnection();
		countResult =new HashMap<String,Integer>();
		countResult.put("北京",0);
		countResult.put("天津",0);
		countResult.put("河北",0);
		countResult.put("山西",0);
		countResult.put("内蒙古",0);
		countResult.put("辽宁",0);
		countResult.put("吉林",0);
		countResult.put("黑龙江",0);
		countResult.put("上海",0);
		countResult.put("江苏",0);
		countResult.put("浙江",0);
		countResult.put("安徽",0);
		countResult.put("福建",0);
		countResult.put("江西",0);
		countResult.put("山东",0);
		countResult.put("河南",0);
		countResult.put("湖北",0);
		countResult.put("湖南",0);
		countResult.put("广东",0);
		countResult.put("广西",0);
		countResult.put("海南",0);
		countResult.put("重庆",0);
		countResult.put("四川",0);
		countResult.put("贵州",0);
		countResult.put("云南",0);
		countResult.put("西藏",0);
		countResult.put("陕西",0);
		countResult.put("甘肃",0);
		countResult.put("青海",0);
		countResult.put("宁夏",0);
		countResult.put("新疆",0);
		
		
		
		
		
	}
	
	public static void printResult(){
		Set set=countResult.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String temp=it.next();
			System.out.println(temp+"省共有"+countResult.get(temp)+"名学生\n");
		}
	}
	
	
}
