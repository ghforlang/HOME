package Chapter7;

public class Practice5 extends P{
	public static void main(String[] args) {
		String ss = "test";
		PP pp = new PP(ss);
		Practice5 p = new Practice5(ss);
	}
	public Practice5(String s){
		super(s);
		System.out.println(s + "t");
	}
}

class P{
	String s;
	public P(String s){
		System.out.println("this is p" + s);
	}
}

class PP{
	String ss;
	public PP(String ss){
		System.out.println("this is pp" + ss);
	}
}