package Chapter7;

public class Practice8 extends BaseClass{
	String s = "Practice8";
	public static void main(String[] args) {
		
	}
	//由于基类带有自定义的构造方法，因此不再有默认无参构造方法，此处定义不合法
	//public Practice8(){
	//	System.out.println("this is constructor");
	//}
	public Practice8(String s){
		super(s);
		System.out.println("this is constructor2");
	}
}

class BaseClass{
	String s = "BaseClass";
	public BaseClass(String s){
		System.out.println(s);
	}
}
