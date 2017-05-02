package Chapter7;

public class FinalOverridingIllusion {
	public static void main(String[] args) {
		OverridingPrivate2  op2 = new OverridingPrivate2();
		op2.f();
		op2.g();
		
		//you can upcast
		OverridingPrivate op = op2;
		//op.f();can not call it
		//op.g();
		
		WithFinal wf = op2;
		//wf.f();
		//wf.g();
		//final method cannot be overrideed
	}
}

class WithFinal{
	private final void f(){
		System.out.println("WithFinal.f()");
	}
	
	private void g(){
		System.out.println("WithFinal.g()");
	}
}

class OverridingPrivate extends WithFinal{
	private final void f(){
		System.out.println("OverridingPrivate.f()");
	}
	
	public void g(){
		System.out.println("OverridingPrivate.g()");
	}
}

class OverridingPrivate2 extends OverridingPrivate{
	public final void f(){
		System.out.println("OverridingPrivate2.f()");
	}
	
	public void g(){
		System.out.println("OverridingPrivate2.g()");
	}
}

