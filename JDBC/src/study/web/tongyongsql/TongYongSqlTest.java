package study.web.tongyongsql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装通用sql\
 * 模拟客户端
 * @author yeying
 */
public class TongYongSqlTest {

	public static void main(String[] args) throws Exception {

		TongYongSql tongYong = new TongYongSql();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "1");
		map.put("username", "tom");
		
		List<User> users = tongYong.queryUsers(map);
		
		System.out.println(users);
	}
}
