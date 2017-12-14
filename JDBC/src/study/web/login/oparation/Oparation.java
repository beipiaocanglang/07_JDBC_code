package study.web.login.oparation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import study.web.login.domain.User;
import study.web.utils.JDBCUtils;

/**
 * 校验用户名和密码
 * @author yeying
 */
public class Oparation {
	//用户登录案例
	public User login(String username, String password){
		
		User user = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			//获取connection连接
			connection = JDBCUtils.getConnection();
			
			String sql = "select * from user where username=? and password=?";
			statement = connection.prepareStatement(sql);//这一行执行完成后，上面的sql语句已经生成了固定的结构
			
			statement.setString(1, username);
			statement.setString(2, password);//这两行执行完成后，只是将值赋值进去，不会修改sql语句的结构，即使使用sql注入也不行，会将拼的字符串当作一个整体
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(connection, statement, resultSet);
		}
		
		return user;
	}
}
