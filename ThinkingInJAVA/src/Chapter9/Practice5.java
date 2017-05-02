package Chapter9;

import others.TestInterface;

public class Practice5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produce p = new Produce();
		p.get();
		p.put();
		p.send();
	}
}

class Produce implements TestInterface{

	@Override
	public void get() {
		// TODO Auto-generated method stub
		System.out.println("this is get");
	}

	@Override
	public void put() {
		// TODO Auto-generated method stub
		System.out.println("this is put");
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("this is send");
	}
	
}
