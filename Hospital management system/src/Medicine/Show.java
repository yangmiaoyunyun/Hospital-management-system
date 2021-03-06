package Medicine;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;

public class Show extends Showmedicine {

	static int max=500;
	public static String[][] getRows(){
		String sql_url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=Hospital table";	//数据库路径（一般都是这样写），test是数据库名称
		String name = "sa";		//用户名
		String password = "wu123456";	//密码
		Connection conn;
		PreparedStatement preparedStatement = null;
 
		String[][] rows = null;
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		//连接驱动
			conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库
			preparedStatement = conn.prepareStatement("select * from 药剂信息表");
			ResultSet result1 = preparedStatement.executeQuery();
			
			if(result1.wasNull())
				JOptionPane.showMessageDialog(null, "结果集中无记录");
			
			rows = new String[max][5];
			String[] s = null;
			s = new String[5];
			ResultSetMetaData rsmd = result1.getMetaData();
			int i=0;
			while(result1.next()){
				s=getNextRow(result1,rsmd);
				for(int p=0;p<5;p++)
				{
					rows[i][p]=s[p].trim();
				}
				i++;
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
		return rows;
	}
	
	// 得到数据库表头
	public static String[] getHead(){
		String sql_url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=Hospital table";	//数据库路径（一般都是这样写），test是数据库名称
		String name = "sa";		//用户名
		String password = "wu123456";	//密码
		Connection conn;
		PreparedStatement preparedStatement = null;
 
		String[] columnHeads = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		//连接驱动
			conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库
//			if(!conn.isClosed())
//				System.out.println("成功连接数据库");
			preparedStatement = conn.prepareStatement("select * from 药剂信息表");
			ResultSet result1 = preparedStatement.executeQuery();
			
			boolean moreRecords = result1.next();
			if(!moreRecords)
				JOptionPane.showMessageDialog(null, "结果集中无记录");
			
			columnHeads = new String[5];
			ResultSetMetaData rsmd = result1.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
				columnHeads[i-1]=rsmd.getColumnName(i).trim();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功加载驱动。");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
			e.printStackTrace();
		}
		return columnHeads;
	}
	
	// 得到数据库中下一行数据
	private static String[] getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
		String[] currentRow = null;
		currentRow = new String[5];
		for(int i = 1; i <= rsmd.getColumnCount(); i++){
			{
				currentRow[i-1]=rs.getString(i).trim();
				//System.out.println(currentRow[i-1]+" "+(i-1));
			}
		}
		return currentRow;
	}
	

}


 

