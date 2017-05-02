import java.math.BigInteger;
public class TestBigInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1234567890123456789012345678901234567890";
		String b= "1234567890";
		BigInteger aa = new BigInteger(a);
		BigInteger bb = new BigInteger(b);
		BigInteger sum = aa.add(bb);
		BigInteger multi = aa.multiply(bb);
		BigInteger sub = aa.subtract(bb);
		BigInteger div = aa.divide(bb);
		BigInteger mod = aa.mod(bb);		
		System.out.println(sum);
		System.out.println(multi);
		System.out.println(sub);
		System.out.println(div);
		System.out.println(mod);
	}

}
