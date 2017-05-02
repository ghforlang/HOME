
public class TestOfEclipse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("TestOfEclispe running successfully!");
		/**
		 * switch 作用类型：char,byte,int,String,不能作用于long；
		 long n = 5678;
		 String s = "a";
		 Byte b = 2;
		 char c = '2';
		 switch(c){
		}
		*/
		
		/**
		 * java 中数组长度不能为long类型；
		 * long n = 5678;
		 * int[] a = new int[n];//报错
		 */
		
		/**
		 * char c = '中';
		 * System.out.println(c);
		 */
		
		char c = '过';
		System.out.println((int)c);
		Character cc = new Character(c);
		//cc.
		System.out.println((int)Character.MAX_VALUE);
	}

}
