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
	public String change(String s,char[] c){//����String�����ܸı��ַ�����Ӧֵ,���÷���ֵ�����޸�String�����ֵ
		s = "aaaa";
		c[0] = 'b';
		return s;
	}
	public void changeStr(StringBuffer sb,char[] c){//����StringBuffer���Ըı��Ӧֵ
		sb = sb.replace(0, sb.length(), "cc");
		c[0] = 'b';
	}
}
