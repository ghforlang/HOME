package algorithm;

public class StrCount {

	public static void main(String[] args) {
		String[] test = {
				"your Your your your",
				"none of your business",
				"try your best to get your first success",
				"this is your first test"
		};
		String p = "your";
		String[] result = strCount(test,p);
		for(String s: result)
			System.out.println(s);
	}
	public static String[] strCount(String[] s,String p){
		String t[] = {};
		return t;
	}
}
