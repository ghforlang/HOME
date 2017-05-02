package JustForTest;

public class TestClassOne {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username = "xxx";
		int x = 1;
		if(username.equals("xxx"))
			System.out.println(username);
		TestClassOne tco = new TestClassOne();
		System.out.println(tco.isInt(x));
		
	}
	public boolean isInt(int x){
		//return x == 1 ? true : false;
		return x==1;
	}
}
