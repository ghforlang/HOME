package JustForTest;

public class Testtest {

	public static void main(String[] args) {
		Sub s = new Sub("sub");
		System.out.println(s.getName());
		try {
			//返回该方法的声明与定义出
			System.out.println(s.getClass().getMethod("getName",null));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

}
class Base{
	String name;
	public Base(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
class Sub extends Base{
	public Sub(String n){
		super(n);
	}
	//重写（覆盖）getName方法
	//public String getName(){
	//	return null;
	//}
 }
