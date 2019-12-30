package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Link extends Login {
	Connection connection = null;
	public Link() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		// 接下来，DriverManager试图从已注册的JDBC驱动程序集中选择一个适当的驱动程序。
		// sqlserver 数据库 url
		String urlSqlServer = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=Hospital table";
		// sqlserver 数据库
		@SuppressWarnings("unused")
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(urlSqlServer, "sa", "wu123456");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("sqlserver 数据库驱动加载成功");
	}
	
	public static int identify(String username,String userpsd) {
		String sql_url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=Hospital table";	//数据库路径（一般都是这样写），test是数据库名称
		String name = "sa";		//用户名
		String password = "wu123456";	//密码
		PreparedStatement preparedStatement = null;	
		Connection conn;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(sql_url, name, password);
		preparedStatement = conn.prepareStatement("select * from 系统的用户口令表");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String username1=rs.getString(1).trim();
				String userpsd1=rs.getString(2).trim();
				String root=rs.getString(3).trim();
				if(username.equals(username1)&&userpsd.equals(userpsd1)&&root.equals("root")) {
					return 1;
				}
				if(username.equals(username1)&&userpsd.equals(userpsd1)&&root.equals("user")) {
					return 2;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功加载驱动。");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
			e.printStackTrace();
		}
		return 0;
	}

}
