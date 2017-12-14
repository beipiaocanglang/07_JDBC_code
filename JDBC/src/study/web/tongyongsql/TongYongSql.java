package study.web.tongyongsql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import study.web.utils.JDBCUtils;

/**
 * 封装通用sql
 * 封装工具类
 * @author yeying
 */
public class TongYongSql {

	public List<User> queryUsers(Map<String, String> map) throws Exception{
		
		List<User> lists = new ArrayList<User>();
		Connection connection = JDBCUtils.getConnection();
		String sql = "select * from user";
		if (map.size() != 0) {
			
			sql += " where";
			int i = 0;
			
			for (Map.Entry<String, String> entry : map.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				if (i == 0) {
					sql = sql + " " +key + "= '" + value +"'";
					i++;
				}else {
					sql = sql + " and " +key + "= '" + value +"'";
				}
			}
		}
		System.out.println("********"+sql);
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt("id"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setEmail(resultSet.getString("email"));
			lists.add(user);
		}
		return lists;
	}
}
