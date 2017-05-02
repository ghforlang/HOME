
public class TestFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String ss = "12  ";
		System.out.println(ss.hashCode());
		ss.trim();//ss指向的对象没有变，但是对象内容发生了变化
		System.out.println(ss.hashCode());
		System.out.println(ss);
	}

}
