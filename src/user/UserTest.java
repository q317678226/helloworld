package user;

public class UserTest {
	public static void main(String[] args) {
		User user = new User();
		user.setName("ss");
		if (user.getName()!=null && !"".equals(user.getName())) {
			System.out.println(user.getName());
		}else {
			System.out.println("用户名为空！！！");
		}
	}
}
