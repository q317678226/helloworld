package day01;

public class StaticTest {
	
	
	public static int a = 2;
	
	static{
		a = 1;
	}
	
	public static void main(String args[]) {
		System.out.println(a);
	}
}
