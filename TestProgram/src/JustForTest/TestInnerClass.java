package JustForTest;


public class TestInnerClass {
	public static void main(String[] args) {
		System.out.println(TestInnerClass.class.getSuperclass().getName());
		//String s = "a" + "b" + "c" + "d"; 
		//System.out.println(s == "abcd"); 
		String s1 = "a"; 
		String s2 = s1 + "b"; 
		String s3 = "a" + "b"; 
		System.out.println(s2 == "ab"); 
		System.out.println(s3 == "ab"); 
		System.out.println(2 + 3 + ",2" + 3 + 1);
		System.out.println(TestInnerClass.printf());
	}
	public static int printf(){
		int i = 2;
		try{
			++i;
			System.out.println((System.currentTimeMillis()));
			return i;
		}finally{
			++i;
			System.out.println(i + "," +  System.currentTimeMillis());
		}
		//System.out.println(i);
	}
}
