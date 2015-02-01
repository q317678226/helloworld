package stringTest;

public class SplitTest {
	public static void main(String[] args) {
		String filename = "20150121144600.001.txt";
		String[] suffix_arr = filename.split("\\.");
		System.out.println("length========="+ suffix_arr.length);
		for (int i=0;i<suffix_arr.length;i++) {
			System.out.println(suffix_arr[i]);
		}
	}
}
