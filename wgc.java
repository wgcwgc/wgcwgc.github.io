package wgcwgc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class wgc
{
	//�������ݿ�
	public static Connection getConnection()throws SQLException{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//�������ݿ�����
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//ƥ�����ݿ�����
		public static boolean judge(String str1_zhanghao,String str1_mima) throws SQLException
		{
			Connection conn = getConnection();//��ȡ�����ݿ�֮�������
//			System.out.println(getConnection());
			Statement st = conn.createStatement();//����Statement
			ResultSet rs = st.executeQuery("select * from user");//ִ��SQL���
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
