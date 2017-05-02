/**Object obj = new Object();
 * String a = new String("abc");
 * String b = new String("abc");
 * obj所对应的内存中存储的数值就是对象占用的那块内存的首地址
 * 对于指向对象类型的变量，如果要比较两个变量是否指向同一个对象，
 * 即要看这两个变量所对应的内存中的数值是否相等，这时候就需要用==操作符进行比较。
 * @author lenovo
 *
 */
public class TestEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = new String("abc");
		String b = new String("abc");
		System.out.println(a.equals(b));
		System.out.println(a == b);//比较a、b所指向的对象内存首地址
		
	}

}
