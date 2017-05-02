package itmian;
//È¥ÄÄÍøÌâÄ¿1
public class PadString {

	public static void main(String[] args) {
		String s = "aa";
		System.out.println(padString(s, 5, '*'));
		
	}
	public static String padString(String s,int minLength,char c ){
		int len = s.length();
		StringBuilder sb = new StringBuilder(s);
		if(len >= minLength)
			return s;
		for(int i=0;i<minLength-len;i++)
			sb.insert(0, c);
		return sb.toString();
	}
}
