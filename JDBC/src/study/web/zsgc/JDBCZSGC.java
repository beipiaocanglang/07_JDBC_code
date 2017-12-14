package study.web.zsgc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import study.web.utils.JDBCUtils;

/**
 * 对jdbc的增删改查
 * @author yeying
 */
public class JDBCZSGC {

	//增
	@Test
	public void addUser() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sql = "insert into user values(null,'haha','159','haha@ha.com');";
		int executeUpdate = statement.executeUpdate(sql );
		
		if (executeUpdate>0){
			System.out.println("保存成功！！！");
		}else {
			System.out.println("保存失败！！！");
		}
		JDBCUtils.close(connection, statement, null);
	}
	//改
	@Test
	public void updataUser() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sql = "update user set username='lisi',password='123',email='li@lis.com' where id=4";
		int executeUpdate = statement.executeUpdate(sql );
		
		if (executeUpdate>0){
			System.out.println("修改成功！！！");
		}else {
			System.out.println("修改失败！！！");
		}
		JDBCUtils.close(connection, statement, null);
	}
	//查询
	@Test
	public void findUser() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sql = "select * from user where id=3";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id")+"   "+
					resultSet.getString("username")+"   "+
					resultSet.getString("password")+"   "+
					resultSet.getString("email"));
			
		}
		JDBCUtils.close(connection, statement, resultSet);
	}
	//删除
	@Test
	public void deleteUser() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sql = "delete user where id=4";
		int update = statement.executeUpdate(sql);
		if(update>0){
			System.out.println("删除成功！！！");
		}else {
			System.out.println("删除成功！！！");
			
		}
		JDBCUtils.close(connection, statement, null);
	}
}
