
public class TestStatic {
	public static int var = 0;
	public int var2 = 0;
	public TestStatic(){
		var ++;
		var2 ++;
		System.out.println("var = " + var + "," + "var2 = " + var2);
	}
	public static void main(String[] args) {
		for(int i =0;i<5;i++){
			new TestStatic();
		}
	}

}
