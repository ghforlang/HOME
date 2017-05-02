package JustForTest;

import java.util.ArrayList;
public class TestInterview{

	public static void main(String[] args) {
		//Coffe   20
        TestInterview ti = new TestInterview();
        System.out.println(ti.pay(ti.order()));
		
		//System.out.println(c.sum());
		//Coffe + W  28
		//W w = new W(c);
		//System.out.println(w.sum());
		//Coffe + W + M  33
		//M m = new M(w);
		//System.out.println(m.sum());
		
		//Marsh 10
		
		//System.out.println(marsh.sum());
		//Marsh + w 18
		//W ww = new W(marsh);
		//System.out.println(ww.sum());
		//Marsh + W + M 23
		//M mm = new M(ww);
		//System.out.println(mm.sum());
	}
	public Sourceable order(){
		Coffe c = new Coffe(null); 
		W w = new W(c);
		M m = new M(w);		
		return m;
	}
	public int pay(Sourceable source){
		return source.sum();
	}
}

interface Sourceable {
	public int sum();
}

class Coffe implements Sourceable{
	private Sourceable source;
	public Coffe(Sourceable source){
		super();
		this.source = source;
	}
	@Override
	public int sum() {
		if(source == null)
			return 20;
		else
		 return 20 + source.sum();
	}
}
class Marsh implements Sourceable{
	private Sourceable source;
	public Marsh(Sourceable source){
		super();
		this.source = source;
	}
	@Override
	public int sum() {
		if(source == null)
			return 10;
		else {
			return 10 + source.sum();
		}
	}
}
class W implements Sourceable{
    private Sourceable source;
    public W(Sourceable source){
    	super();
    	this.source = source;
    }
	@Override
	public int sum() {
		if(source == null)
			return 8;
		else {
			return 8+source.sum();
		}
	}
}
class M implements Sourceable{
	private Sourceable source;
	public M(Sourceable source){
		super();
		this.source = source;
	}
	@Override
	public int sum() {
		if(source == null)
			return 5;
		else {
			return 5 + source.sum();
		}
	}
	
}