package Chapter7;

public class Practice8 extends BaseClass{
	String s = "Practice8";
	public static void main(String[] args) {
		
	}
	//���ڻ�������Զ���Ĺ��췽������˲�����Ĭ���޲ι��췽�����˴����岻�Ϸ�
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
