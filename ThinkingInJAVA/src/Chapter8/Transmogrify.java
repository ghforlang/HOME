package Chapter8;

public class Transmogrify {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
		stage.performPlay();
		stage.change();
		stage.performPlay();
	}
}

class Actor{
	public void act(){}
}


class HappyActor extends  Actor{
	public void act(){
		System.out.println("this is happyactor");
	}
}

class SadActor extends Actor{
	public void act(){
		System.out.println("this is sadactor");
	}
}

class Stage{
	private Actor actor = new HappyActor();
	public void change(){
		actor = new SadActor();
	}
	
	public void performPlay(){
		actor.act();
	}
}