package study.web.login.client;

import java.util.Scanner;

import study.web.login.domain.User;
import study.web.login.oparation.Oparation;

/**
 * 模拟客户端
 * @author yeying
 */
public class Client {

	//在控制台输入用户名和密码来校验用户是否存在
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入用户名：");
		String username = scanner.nextLine();
		System.out.println("请输入密码");
		String password = scanner.nextLine();
		
		//将用户名和密码传递到操作类型
		Oparation op = new Oparation();
		User user = op.login(username, password);
		if(user!=null){
			System.out.println(user);
		}else{
			System.out.println("对不起，用户不存在或密码错误！！！");
		}
		
	}
}
