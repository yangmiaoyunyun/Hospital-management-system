package jobs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Insertjobs {
	public static void insert(String Num, String Name) {
		String sql_url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=Hospital table";
		String name = "sa"; // 用户名
		String password = "wu123456"; // 密码
		Connection conn;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // 连接驱动
			conn = DriverManager.getConnection(sql_url, name, password); // 连接数据库
			preparedStatement = conn.prepareStatement("insert into 工作岗位情况表 (工作岗位代号,工作岗位名称) values ('" + Num + "','"
					+ Name + "')");
			ResultSet result1 = preparedStatement.executeQuery();
			if (result1.wasNull())
				JOptionPane.showMessageDialog(null, "结果集中无记录");
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
	}
}
