package JustForTest;


public class TestExample {
	String str = new String("helloworld");
	StringBuffer sb = new StringBuffer(str);
	char[] c = {'a','b','c'};
	public static void main(String[] args) {
		
		TestExample te = new TestExample();
		System.out.println(te.str.hashCode());
		
		te.changeStr(te.sb,te.c);
		System.out.println(te.sb + " and");
		System.out.println(te.c);
		
		te.str =te.change(te.str, te.c);
		System.out.println(te.str);
	}
	public String change(String s,char[] c){//传递String对象不能改变字符串对应值,利用返回值可以修改String对象的值
		s = "aaaa";
		c[0] = 'b';
		return s;
	}
	public void changeStr(StringBuffer sb,char[] c){//传递StringBuffer可以改变对应值
		sb = sb.replace(0, sb.length(), "cc");
		c[0] = 'b';
	}
}
