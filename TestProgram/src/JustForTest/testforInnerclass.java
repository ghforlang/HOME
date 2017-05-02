package JustForTest;

public class testforInnerclass {
	
	static int NO = 1;
	private int no = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testforInnerclass.Test tt = new Test();
		tt.getTest();
		testforInnerclass.Test.setTest();
		}
	static class Test{
		public void getTest(){
			System.out.println(NO);
			System.out.println(new testforInnerclass().no);
		}
		
		public static void setTest(){
			System.out.println(NO);
			System.out.println(new testforInnerclass().no);
		}
	}
}
