package map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import user.User;

public class ListTest {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		User user1 = new User("zhao");
		users.add(user1);
		User user2 = new User("wen");
		users.add(user2);
		User user3 = new User("zhou");
		users.add(user3);
		for (User user : users) {
			System.out.println(user.getName());
		}
		System.out.println("*******************************");
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			User user = it.next();
			user.setName("tong");
		}
		for (User user : users) {
			System.out.println(user.getName());
		}
	}
}
