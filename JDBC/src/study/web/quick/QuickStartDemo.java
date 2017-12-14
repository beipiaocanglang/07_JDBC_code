package study.web.quick;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
/**
 * jdbc入门案例
 * 	步骤：
 * 		1、注册驱动
 * 		2、创建连接数据库
 * 			参数讲解：
 * 				url:数据库地址
 * 				user:数据库登录名
 * 				password:数据库密码
 * 		3、创建Statement
 * 		4、执行sql语句
 * 		5、遍历结果集
 * 		6、关闭资源
 * @author yeying
 */
public class QuickStartDemo {

	public static void main(String[] args) throws Exception {
		//1、注册驱动
		DriverManager.registerDriver(new Driver());
		
		/**
		 * 2、创建连接数据库
		 * 参数讲解：
		 * 		url:数据库地址
		 * 		user:数据库登录名
		 * 		password:数据库密码
		 */
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		
		//3、创建Statement
		Statement statement = connection.createStatement();
		
		//4、执行sql语句
		String sql = "select * from user";
		ResultSet query = statement.executeQuery(sql);
		
		//5、遍历结果集
		while (query.next()) {
			System.out.println(
				query.getInt("id")+"   "+
				query.getString("username")+"   "+
				query.getString("password")+"   "+
				query.getString("email"));
		}
		
		//6、关闭资源
		query.close();
		statement.close();
		connection.close();
		
	}
}
