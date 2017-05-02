package Chapter9;

import java.util.Arrays;

public class Apply {
	static void process(Processer p,Object s){
		System.out.println("Using processer " + p.name());
		System.out.println(p.process(s));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "this is a university";
		//System.out.println(Arrays.toString(ss.split(" ")));
		process(new Upcase(), ss);
		process(new Lowwercase(), ss);
		process(new Splitter(), ss);
	}
}

class Processer{
	public String name(){
		return getClass().getSimpleName();
	}
	Object process(Object input){
		return input;
	}
}

class Upcase extends Processer{
	String process(Object input){
		return ((String)input).toUpperCase();
	}
}

class Lowwercase extends Processer{
	String process(Object input){
		return ((String)input).toLowerCase();
	}
}

class Splitter extends Processer{
	String Process(Object input){
		return Arrays.toString(((String)input).split(" "));
	}
}


//向下转型问题