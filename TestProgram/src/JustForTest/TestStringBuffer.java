package JustForTest;

public class TestStringBuffer {

	public static void main(String[] args) {
		String s = "a";
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb.capacity());//17,后随sb长度不断增大
		System.out.println(sb.reverse());
		System.out.println(sb.append("1"));
		System.out.println(sb.append(1));
		System.out.println(sb.length());
		
		//无参构造方法，无论append多少次，其append始终为16
//		StringBuffer sb1 = new StringBuffer();
//		System.out.println(sb1.capacity());//16
//		sb1.append("12345678");
//		System.out.println(sb1.capacity());//16
//		sb1.append("123456789123");
		//append的字符长度超过16，则重新分配capacity,大小为newCapacity = 2*(oldCapacity+1)
		//System.out.println(sb1.capacity());
	}

}
