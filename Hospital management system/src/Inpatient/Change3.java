package Inpatient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Change3 extends Changeinpatientbed {
	public static void change(String S,String Num, String State) {
	String sql_url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=Hospital table";	
	String name = "sa";		//用户名
	String password = "wu123456";	//密码
	Connection conn;
	PreparedStatement preparedStatement = null;
	
	try {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		//连接驱动
	conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库
	preparedStatement = conn.prepareStatement("update 床位信息表 set 床位号 = '"+Num+"', 床位状态 ='"+State+"' where 床位号 = '"+S+"'");
	ResultSet result1 = preparedStatement.executeQuery();
	if(result1.wasNull())
		JOptionPane.showMessageDialog(null, "结果集中无记录");
	} catch (ClassNotFoundException e) {
	} catch (SQLException e) {
	}
	}
}
