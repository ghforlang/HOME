package JustForTest;


public class TestFac {
	public static void main(String[] args) {
		int n = 3;
		TestFac tf = new TestFac();
		System.out.println(tf.fac(n));
	}
	public int TestFac(int a){
		return a;
	}
	public int fac(int n){
		if(n <= 1)
			return 1;
		else {
			return fac(n-1)*n;
		}
	}
}
