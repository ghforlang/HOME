package Chapter8;


public class RTTI {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Useful us[] = {
				new Useful(),
				new MoreUseful()
		};
		us[0].f();
		//us[1].u();
		
		((MoreUseful)us[0]).u();//can not be casted
		((MoreUseful)us[1]).u();
	}
}

class Useful{
	public void f(){}
	public void g(){}
}

class MoreUseful extends Useful{
	public void f(){}
	public void g(){}
	public void h(){}
	public void u(){}
}