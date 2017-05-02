import java.math.*;
public class TestRound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 11.2;
		double b = 11.7;
		double c = -11.2;
		double d = -11.7;
		System.out.println(a + "," + Math.ceil(a));
		System.out.println(b + "," + Math.ceil(b));
		System.out.println(c + "," + Math.ceil(c));
		System.out.println(d + "," + Math.ceil(d));
		
		System.out.println("*********************");
		System.out.println(a  + "," + Math.floor(a));
		System.out.println(b + "," + Math.floor(b));
		System.out.println(c + "," + Math.floor(c));
		System.out.println(d + "," + Math.floor(d));
		
		System.out.println("*********************");
		System.out.println(a + "," + Math.round(a));
		System.out.println(b + "," + Math.round(b));
		System.out.println(c + "," + Math.round(c));
		System.out.println(d + "," + Math.round(d));
	}

}
