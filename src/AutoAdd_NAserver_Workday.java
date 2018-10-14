/*
	function:为NA旧报修网添加工作日
	author:龙猫
	date:2018/10/14
 */

import java.sql.*;

public class AutoAdd_NAserver_Workday {
	public static void main(String args[]){
		Connection conn = null ;
		Statement myStatement = null;
		ResultSet mySet = null;
		String url = "jdbc:mysql://172.16.6.207:3306/naservice";	//jdbc连接目标
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("com.mysql.jdbc.Driver ");
			conn = DriverManager.getConnection(url,"","");		//账号密码
			myStatement = conn.createStatement();				//建立JDBC连接
		}catch (Exception e){
			e.printStackTrace();
		}

		try{
			mySet = myStatement.executeQuery("select * from maintain_workday_setting where id\n" +
					" = (select max(id) from maintain_workday_setting);");			//获取ID最大值的记录
			mySet.next();
			String date = mySet.getString("date");			//获取ID最大值的记录的日期
			//ReturnSql ReturnSql = new ReturnSql();		//声明返回语句对象
			CheckWorkday checkWorkday = new CheckWorkday();	//声明 调用查询是否周末方法 对象
			DateAddOne dateAddOne = new DateAddOne();		//声明 调用日期加一方法 对象
			//String sql = ReturnSql.ReturnSqlFunction(date);
			int time = 1;		//循环次数

			date = dateAddOne.DateAddOneFunction(date);		//将获取到的日期+1
			for (int i = 0;i < time;i++){
				if (checkWorkday.checkWorkDay(date)){			//检测该日是否为工作日,是则插入
					String sql1 = "insert into maintain_workday_setting set date = '" + date + "',class = '1';";
					String sql2 = "insert into maintain_workday_setting set date = '" + date + "',class = '2';";
					myStatement.executeUpdate(sql1);
					myStatement.executeUpdate(sql2);
					System.out.println("已成功插入\"" + date + "\"的数据！");
					date = dateAddOne.DateAddOneFunction(date);		//将获取到的日期+1
				}else {											//不是工作日则日期+1
					System.out.println(date + "不是工作日，插入日期顺延!");
					date = dateAddOne.DateAddOneFunction(date);		//将获取到的日期+1
				}
			}




		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
