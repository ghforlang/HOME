package itmian;

public class Permutation {

	public static void main(String[] args) {
		String a = "abcdefg";
		String b = "abdegfc";
		String c = "aadbcdd";
		System.out.println(isPermutation1(a, c));
	}
	public static boolean isPermutation(String s1,String s2){
		if(s1.length() != s2.length())
			return false;
		else {
			return sort(s1).equals(sort(s2));
		}
	}
	public static String sort(String s){
		char[] array = s.toCharArray();
		java.util.Arrays.sort(array);
		return new String(array);
	}
	
	public static boolean isPermutation1(String s1,String s2){
		if(s1.length() != s2.length())
			return false;
		int[] charset = new int[256];
		char[] array = s1.toCharArray();
		for(char c: array)
			charset[c] ++;
		for(int i=0;i<s2.length();i++){
			char c = s2.charAt(i);
			if(--charset[c] < 0)
				return false;
		}
		
		return true;
	}
}
