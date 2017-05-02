package itmian;

public class DiffString {

	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "bcd";
		String s3 = "cdef";
		String s4 = "abcd";
		System.out.println(dif(s2, s3));
	}
	public static String dif(String str1,String str2){
		String result = "";
		boolean isFound = false;
		if(str1.equals(str2))
			return "the same";
		else{
			for(int i=0;i<str1.length();i++){
				isFound = false;
				for(int j=0;j<str2.length();j++){
					if(str1.charAt(i) == str2.charAt(j)){
						isFound = true;
						break;
					}
				}
				if(!isFound){
					result += "-" + str1.charAt(i);
					result += ",";
				}
			}
			return result;
		}
		
	}
}
