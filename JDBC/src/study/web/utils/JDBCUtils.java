package study.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 将jdbc创建connection连接提取程一个工具类
 * @author yeying
 */
public class JDBCUtils {

	public static String driver = null;
	public static String url = null;
	public static String user = null;
	public static String password = null;

	//加载配置文件，以及配置文件中数据
	static{
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		driver = rb.getString("driver");
		url =rb.getString("url");
		user = rb.getString("user");
		password = rb.getString("password");
	}
	
	//静态代码块，使驱动只创建依次
	static{
		//使用类反射加载Driver驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection() throws Exception{
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	//释放资源
	public static void close(Connection conn,Statement stmt,ResultSet rs){
	
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
