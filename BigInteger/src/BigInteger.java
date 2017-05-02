
public class BigInteger {
	
	public static void main(String args[]){
		Byte bb = new Byte((byte)12);
		String sss = "1234567890";
		String aaa = "1234567890123456789012345678901234567890";
		
		int lens = sss.length();
		int lena = aaa.length();
		int[] sum;
//		int max = lens > lena ? lens :lena;
		if(lens == lena){
			sum = new int[lens +1];
			System.out.println(sum.length);
			for(int i = sum.length-1,j = lena-1;j>=0;i--,j--){
				int jiashu = sss.charAt(j) - 48;
				int beijiashu = aaa.charAt(j) - 48;
				sum[i] += (jiashu + beijiashu);
				if(sum[i] > 9){
					sum[i] -= 10;
					sum[i-1]  ++;
				}
				System.out.print(sum[i]);
			}
			System.out.println(sum[0]);
		}else if(lens < lena){
			sum = new int[lena + 1];
			int k = lens - 1;
			for(int i = sum.length-1,j = lena-1;j>=0;i--,j--){
				
				int beijiashu = aaa.charAt(j) - 48;
				if(k >= 0)
				{
					int jiashu = sss.charAt(k) - 48;
					k --;
					sum[i] += (jiashu + beijiashu);
				}
				else
					sum[i] += beijiashu;
				
				if(sum[i] > 9){
					sum[i] -= 10;
					sum[i-1] ++;
				}
				System.out.print(sum[i]);
			}
			System.out.println(sum[0]);
		}
//		byte[] b = new byte[1000];
//		b = sss.getBytes();
//		for(byte a:b)
//			System.out.println(a);
		//System.out.println();
	}
}

