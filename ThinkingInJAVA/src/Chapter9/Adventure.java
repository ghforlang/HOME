package Chapter9;
//子类继承父类的方法与实现的接口方法重名时，此时默认该方法已经被重写（实现）
interface CanFight{
	void fight();
}

interface CanSwim{
	void swim();
}

interface CanFly{
	void fly();
}

class ActionCharacter{
	public void fight(){}
}

class Hero extends ActionCharacter implements CanFight,CanSwim,CanFly{

	@Override
	public void fly() {}

	@Override
	public void swim() {}
	
}
public class Adventure {

	public static void t(CanFight x){x.fight();}
	public static void u(CanSwim x){x.swim();}
	public static void v(CanFly x){x.fly();}
	public static void w(ActionCharacter c){c.fight();}
	public static void main(String[] args){
		Hero h = new Hero();
		t(h);
		u(h);
		v(h);
		w(h);
	}
}
