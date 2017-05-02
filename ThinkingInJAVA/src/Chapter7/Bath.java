package Chapter7;

public class Bath {
	private String s1 = "aaa",s2="bbb",s3,s4;
	private Soap soap;
	private int i;
	private float f;
	
	public Bath(){
		System.out.println("Bath()");
		s3 = "ccc";
		f = 3.14f;//f = (float)3.14
		soap = new Soap();
	}
	{ i = 12;
		System.out.println(i);
	}//ÊµÀý³õÊ¼»¯
	public static void main(String[] args) {
		
	}
	
	
	public String toString(){
		return  "s1=" + s1 + "\n" +
				"s2 =" + s2 + "\n" +
				"s3 =" + s3 + "\n" +
				"s4 =" + s4 + "\n" +
				"i =" + i + "\n" +
				"f = " + f + "\n" +
				"soap = " + soap;
	}
}

class Soap{
	private String s;
	Soap(){
		System.out.println("Soap()");
		s = "constructor";
	}
}
