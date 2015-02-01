package day01;

public class GotoTest {
	public static void main(String[] args) {
		System.out.println("args==========="+args.length);
		int fee = 200;
		saveDefault:save(fee);
	}
	
	public static void saveDefault() {
		System.out.println("没执行");
	}
	
	static void save(int fee) {
		System.out.println("fee==============="+fee);
	}
}
