package JustForTest;

public class TestTimu {

	public
	static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"aaa","bbb"};
		String s2 = "aaa";
		String s3 = "bbb";
		String temp;
		//StringBuffer sb = new StringBuffer(s2);
		//sb.append(s3);
		//System.out.println(sb);
		//s2 += s3;
		//System.out.println(s2);
		swap(s);
		System.out.println(s[0] + "," + s[1]);
		swap(s2,s3);
		//直接交换执行成功
//		temp = s2;
//		s2 = s3;
//		s3 = temp;
		System.out.println(s2 + "," + s3);
	}
	public static void swap(String s1,String s2){
		String temp;
		temp = s1;
		s1 = s2;
		s2 = temp;
	}
	public static void swap(String[] a){
		String temp;
		temp = a[0];
		a[0] = a[1];
		a[1] = temp;
	}
}
