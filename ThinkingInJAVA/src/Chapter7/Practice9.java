package Chapter7;

public class Practice9 extends Root{

	public static void main(String[] args) {
		Practice9 p = new Practice9();
	}
	public Practice9(){
		System.out.println("this is Practice9");
	}
}

class Root{
	public Root(){
		Compenent1 c1 = new Compenent1();
		Compenent2 c2 = new Compenent2();
		Compenent3 C3 = new Compenent3();
		System.out.println("this is Root");
	}
}

class Compenent1{
	public Compenent1(){
		System.out.println("this is Compenent1");
	}
}
class Compenent2{
	public Compenent2(){
		System.out.println("this is Compenent2");
	}
}
class Compenent3{
	public Compenent3(){
		System.out.println("this is Compenent3");
	}
}
