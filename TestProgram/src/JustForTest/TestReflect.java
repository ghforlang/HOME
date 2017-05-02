package JustForTest;

import java.lang.reflect.Constructor;

public class TestReflect {

	public static void main(String[] args) throws Exception {
		Areflect a = Areflect.class.newInstance();
		System.out.println(a);
		
		/*
		Constructor<Areflect> c = Areflect.class.getConstructor(Class<Areflect> );
		Areflect aa = c.newInstance(null);
		System.out.println(aa);
		*/
	}

}

class Areflect{
	
}
