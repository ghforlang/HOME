package JustForTest;

public class TestStringBuffer {

	public static void main(String[] args) {
		String s = "a";
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb.capacity());//17,����sb���Ȳ�������
		System.out.println(sb.reverse());
		System.out.println(sb.append("1"));
		System.out.println(sb.append(1));
		System.out.println(sb.length());
		
		//�޲ι��췽��������append���ٴΣ���appendʼ��Ϊ16
//		StringBuffer sb1 = new StringBuffer();
//		System.out.println(sb1.capacity());//16
//		sb1.append("12345678");
//		System.out.println(sb1.capacity());//16
//		sb1.append("123456789123");
		//append���ַ����ȳ���16�������·���capacity,��СΪnewCapacity = 2*(oldCapacity+1)
		//System.out.println(sb1.capacity());
	}

}
