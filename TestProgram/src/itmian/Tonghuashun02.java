/**
 * input: 0x7FFF F0F0
 * output :0111 1111 1111 1111 0000 1111 0000
 */

package itmian;

public class Tonghuashun02 {
	public static String HexString = "0123456789ABCDEF";
	public static String HextoBinaString(String hexstring){
		String result = "";
		hexstring = hexstring.substring(2);
		System.out.println(hexstring);
		int temp = 0,num = 0;
		for(int j=0;j<hexstring.length();j++){
			num = HexString.indexOf(hexstring.charAt(j));
			String ss = "";
			for(int i=0;i<4;i++){
				temp = num %2;
				ss = Integer.toString(temp) + ss;
				num /= 2;
			}
			ss += " ";
			result += ss;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hexstring = "0x7FFFF0F0";
		System.out.println(HextoBinaString(hexstring));
	}
}
