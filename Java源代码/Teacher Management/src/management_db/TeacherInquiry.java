package management_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherInquiry {
	
    public static final String url = "jdbc:mysql://127.0.0.1/teacher?useUnicode=true&characterEncoding=utf-8";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "19961027";  

    PreparedStatement pst;
    //һ����Ҫ�ӿڣ��������Ѿ��������ݿ����ӵĻ����ϣ������ݿⷢ��Ҫִ�е�SQL���
    //һ��SQL����Ԥ���벢�洢��һ��PreparedStatement���󡣴˶�����Ա�������Ч��ִ�д�����Ρ�
    ResultSet resultSet;
    //�����(ResultSet)�������в�ѯ������ص�һ�ֶ��󣬿���˵�������һ���洢��ѯ����Ķ���.
    //���ǽ���������������д洢�Ĺ��ܣ���ͬʱ�����в������ݵĹ��ܣ�������ɶ����ݵĸ��µȡ�
	
	
    //��ѯ�����еĵ�������
	public String teacher_inquiry_name(int uid) throws SQLException, ClassNotFoundException{
		
		Connection connection = DriverManager.getConnection(url,user,password); 
        String sql = "select * from teacher where id='" + uid + "'";
        pst = connection.prepareStatement(sql);
        resultSet = pst.executeQuery(sql);
        String sql_name = null;
        while (resultSet.next()){
        	sql_name = resultSet.getString("name");
        }
        return sql_name;
	}
	
	public String teacher_inquiry_college(int uid) throws SQLException, ClassNotFoundException{
		
		Connection connection = DriverManager.getConnection(url,user,password); 
        String sql = "select * from teacher where id='" + uid + "'";
        pst = connection.prepareStatement(sql);
        resultSet = pst.executeQuery(sql);
        String sql_college = null;
        while (resultSet.next()){
        	sql_college = resultSet.getString("college");
        }
        return sql_college;
	}
	
	public String teacher_inquiry_profession(int uid) throws SQLException, ClassNotFoundException{
		
		Connection connection = DriverManager.getConnection(url,user,password); 
        String sql = "select * from teacher where id='" + uid + "'";
        pst = connection.prepareStatement(sql);
        resultSet = pst.executeQuery(sql);
        String sql_profession = null;
        while (resultSet.next()){
        	sql_profession = resultSet.getString("profession");
        }
        return sql_profession;
	}
	
	public String teacher_inquiry_grade(int uid) throws SQLException, ClassNotFoundException{
		
		Connection connection = DriverManager.getConnection(url,user,password); 
        String sql = "select * from teacher where id='" + uid + "'";
        pst = connection.prepareStatement(sql);
        resultSet = pst.executeQuery(sql);
        String sql_grade = null;
        while (resultSet.next()){
        	sql_grade = resultSet.getString("grade");
        }
        return sql_grade;
	}
	
	public String teacher_inquiry_work_time(int uid) throws SQLException, ClassNotFoundException{
		
		Connection connection = DriverManager.getConnection(url,user,password); 
        String sql = "select * from teacher where id='" + uid + "'";
        pst = connection.prepareStatement(sql);
        resultSet = pst.executeQuery(sql);
        String sql_work_time = null;
        while (resultSet.next()){
        	sql_work_time = resultSet.getString("work_time");
        }
        return sql_work_time;
	}

	public String teacher_inquiry_tel(int uid) throws SQLException, ClassNotFoundException{
		
		Connection connection = DriverManager.getConnection(url,user,password); 
        String sql = "select * from teacher where id='" + uid + "'";
        pst = connection.prepareStatement(sql);
        resultSet = pst.executeQuery(sql);
        String sql_tel = null;
        while (resultSet.next()){
        	sql_tel = resultSet.getString("tel");
        }
        return sql_tel;
	}

}
