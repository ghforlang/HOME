package JustForTest;

public class TestDouble {

	public static void main(String[] args) {
		Double d = new Double("3.0");
		int a = d.intValue();
		byte b = d.byteValue();
		float f = d.floatValue();
		System.out.println(a+b+f);
	}

}
