package wgcwgc;
import java.sql.*;
public class wgcwgc
{
    public static void main(String[] args)
    {
    	//Class.forName("com.mysql.jdbc.Driver");//�������ݿ�����
		//conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        // ����������
        String driver = "com.mysql.jdbc.Driver";
        // URLָ��Ҫ���ʵ����ݿ���game
        //String url = "jdbc:mysql://127.0.0.1:3306/game";
        String url = "jdbc:mysql://localhost:3306/test";
        // MySQL����ʱ���û���
        String user = "root";
        // MySQL����ʱ������
        String password = "root";
        try
        {
            // ������������
            Class.forName(driver);
            // �������ݿ�
            Connection conn = DriverManager.getConnection(url, user, password);
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            // statement����ִ��SQL���
            Statement statement = conn.createStatement();
            // Ҫִ�е�SQL���
            String sql = "select user_id,user_name from user_index order by user_id desc limit 0,5";
            // �����
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("ִ�н��������ʾ:");
            System.out.println("-----------------");
            System.out.println(" user_id" + "\t" + " �û���");
            System.out.println("-----------------");
            String name = null;
            while(rs.next())
            {
                // ѡ��username��������
                name = rs.getString("user_name");
                // ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
                // Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
                name = new String(name.getBytes("ISO-8859-1"),"GB2312");
                // ������
                System.out.println(rs.getString("user_id") + "\t" + name);
            }
            rs.close();
            conn.close();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
