package study.web.quick;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import study.web.utils.JDBCUtils;

/**
 * 将数据库的连接提取程工具类
 * @author yeying
 */
public class YouHuaDemo {

	public static void main(String[] args) throws Exception {
		//1、获取连接
		Connection connection = JDBCUtils.getConnection();
		//2、创建Statement
			Statement statement = connection.createStatement();
			
		//3、执行sql语句
		String sql = "select * from user";
		ResultSet query = statement.executeQuery(sql);
		
		//4、遍历结果集
		while (query.next()) {
			System.out.println(
					query.getInt("id")+"   "+
					query.getString("username")+"   "+
					query.getString("password")+"   "+
					query.getString("email"));
		}
		
		//5、关闭资源
		query.close();
		statement.close();
		connection.close();
	}
}
