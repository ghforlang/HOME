package itmian;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a = 1235321;
		long b = 3;
		long c = 1234322;
		System.out.println(isPalindromeNumber(a));
		System.out.println(isPalindromeNumber(b));
		System.out.println(isPalindromeNumber(c));
		
	}
	public static boolean isPalindromeNumber(long l){
		Long long1 = new Long(l);
		String s = long1.toString();
		boolean isP = true;
		int num = s.length() / 2,len = s.length();
		for(int i=0;i<num ; i++){
			if(s.charAt(i) != s.charAt(len-1-i))
				isP = false;
		}
		return isP;
	}
}
