package itmian;

public class strCompress {

	public static void main(String[] args) {
		String a = "aabbccdd";
		String b = "abcdef";
		System.out.println(strCompressMethod(a));
		System.out.println(strCompressMethod(b));
	}
	public static String strCompressMethod(String s){
		StringBuffer sb = new StringBuffer();
		String result = null;
		char last = s.charAt(0);
		int count = 1;
		for(int i=1;i<s.length();i++){
			if(s.charAt(i) == last)
				count ++;
			else {
				sb.append(last);
				sb.append(count);
				last = s.charAt(i);
				count = 1;
			}
		}
		sb.append(last);
		sb.append(count);
		result = new String(sb);
		if(result.length() > s.length())
			return s;
		else {
			return result;
		}
	}
}
