package Chapter7;

public class Beetle extends Insect{
	private int k = printInit("Beetle.k initilized");
	public Beetle(){
		System.out.println("k=" + k);
		System.out.println("j=" + j);
	}
	
	private static int x2 = printInit("static Beetle.x2 initilized");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Beetle constructor");
		Beetle b = new Beetle();
	}
}

class Insect{
	private int i = 9;
	protected int j;

	Insect(){
		System.out.println("i=" + i + " j=" + j);
		j = 89;
	}
	
	private static int x1 = printInit("static Insect.x1 initialized");
	static int printInit(String s){
		System.out.println(s);
		return 45;
	}
}