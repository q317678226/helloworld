package stringTest;

public class Replace {
	public static void main(String[] args) {
		String a = "a\\b\\c\\d";
		System.out.println(a);
		String b = a.replace("\\", "/");
		System.out.println(b);
	}
}
