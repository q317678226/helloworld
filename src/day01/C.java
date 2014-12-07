package day01;

interface B {
	public static final S s = new S(){
		@Override
		public void add() {
			System.out.println("ssssssssss");
		}
	};
}

interface S {
	public void add();
}

public class C implements B{
	public static void main(String args[]) {
		s.add();
	}

}
