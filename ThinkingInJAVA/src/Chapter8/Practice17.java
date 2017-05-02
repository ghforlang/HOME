package Chapter8;

class Cycle{
	public void ride(){
		System.out.println("cycle riding");
	};
}
class Unicycle extends Cycle{
	public void ride(){
		System.out.println("uncycle riding");
	}
	public void balance(){
		System.out.println("unicycle banlance");
	}
}
class Bicycle extends Cycle{
	public void ride(){
		System.out.println("bicycle riding");
	}
	public void balance(){
		System.out.println("bicycle banlance");
	}
}

class Tricycle extends Cycle{
	public void ride(){
		System.out.println("tricycle riding");
	}
}
public class Practice17 {
	public static void main(String[] args) {
		Cycle c[] = {
				new Unicycle(),
				new Bicycle(),
				new Tricycle(),
		};//向上转型
		((Unicycle) c[0]).balance();//向下转型
		((Bicycle) c[1]).balance();
		//((Tricycle) c[2]).balance();
	}
	public static void speed(Cycle c){
		c.ride();
	}
}
