package management_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;


public class TeacherTable extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
    
    public static final String url = "jdbc:mysql://127.0.0.1/teacher?useUnicode=true&characterEncoding=utf-8";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "19961027";  
	Connection connection = DriverManager.getConnection(url,user,password); 
    PreparedStatement pst;
    //һ����Ҫ�ӿڣ��������Ѿ��������ݿ����ӵĻ����ϣ������ݿⷢ��Ҫִ�е�SQL���
    //һ��SQL����Ԥ���벢�洢��һ��PreparedStatement���󡣴˶�����Ա�������Ч��ִ�д�����Ρ�
    ResultSet resultSet;
    //�����(ResultSet)�������в�ѯ������ص�һ�ֶ��󣬿���˵�������һ���洢��ѯ����Ķ���.
    //���ǽ���������������д洢�Ĺ��ܣ���ͬʱ�����в������ݵĹ��ܣ�������ɶ����ݵĸ��µȡ�
	
	String[] columnNames = 
		{"���", "����", "ѧԺ", "רҵ", "�༶", "����ʱ��", "��ϵ��ʽ"};
	 Object [][]data = new Object[20][7];
	public TeacherTable() throws SQLException{
		int dex = 0;
		String sql = "select * from teacher";
		pst = connection.prepareStatement(sql);
        resultSet = pst.executeQuery(sql);
		try {
			resultSet = pst.executeQuery(sql);
			while(resultSet.next()){
				data[dex][0] = resultSet.getInt("id");
				data[dex][1] = resultSet.getString("name");
				data[dex][2] = resultSet.getString("college");
				data[dex][3] = resultSet.getString("profession");
				data[dex][4] = resultSet.getString("grade");
				data[dex][5] = resultSet.getString("work_time");
				data[dex++][6] = resultSet.getString("tel");
			}
			resultSet.close();
		//	c.close();		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public int getColumnCount() {
		return columnNames.length; 
	}

	@Override
	public int getRowCount() {
		return data.length;  
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];  
	}
	public String getColumnName(int column)  
    {  
        return columnNames[column];  
    } 
	public boolean isCellEditable(int rowIndex, int columnIndex)  
    {  
		return false;
    }
	 public void setValueAt(Object aValue, int rowIndex, int columnIndex)  
     {  
         data[rowIndex][columnIndex] = aValue;  
         /*֪ͨ���������ݵ�Ԫ�����Ѿ��ı�*/  
         fireTableCellUpdated(rowIndex, columnIndex);  
     }
}
