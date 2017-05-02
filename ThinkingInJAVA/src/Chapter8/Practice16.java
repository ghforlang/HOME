package Chapter8;

public class Practice16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StarShip ss = new StarShip();
		ss.performTrans();
		ss.transform();
		ss.performTrans();
	}
}

class StarShip{
	private AlertStatus as = new RightStatus();
	public void transform(){
		as = new LeftStatus();
	}
	
	public void performTrans(){
		as.change();
	}
	
}

class AlertStatus{
	public void change(){}
}

class RightStatus extends AlertStatus{
	public void change(){
		System.out.println("turn right");
	}
}

class LeftStatus extends AlertStatus{
	public void change(){
		System.out.println("turn left");
	}
}

class BackStatus extends AlertStatus{
	public void change(){
		System.out.println("turn back");
	}
}
