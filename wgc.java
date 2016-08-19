package wgcwgc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class wgc
{
	//连接数据库
	public static Connection getConnection()throws SQLException{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//匹配数据库数据
		public static boolean judge(String str1_zhanghao,String str1_mima) throws SQLException
		{
			Connection conn = getConnection();//获取跟数据库之间的连接
//			System.out.println(getConnection());
			Statement st = conn.createStatement();//创建Statement
			ResultSet rs = st.executeQuery("select * from user");//执行SQL语句
			while(rs.next()){
				if(rs.getString(2).equals(str1_zhanghao) && rs.getString(3).equals(str1_mima))
					return true;
			}
			return false;
		}

	public static void main(String[] args)
	{
		try {
			System.out.println(judge("1" , "1"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
