public class TestPI {
	public static final int ARRSIZE = 1010;
	public static final int DISPCNT = 1000;
	public static void main(String[] args) {
		char x[] = new char[ARRSIZE],z[] = new char[ARRSIZE];
		int a=1,b=3,c=0,d=0,run=0,cnt=0;
		x[1]= 2;
		z[1] =2;
		while(run>0 && (++cnt < 200000000)){
			d = 0;
			for(int i=ARRSIZE-1;i>0;i--){
				c = z[i] * a + d;
				z[i] = (char) (c % 10);
				d = c / 10;		
			}
			d = 0;
			for(int i = 0;i<ARRSIZE;i++){
				c = z[i] + d*10;
				z[i] = (char) (c /b);
				d = c % b;
			}
			run = 0;
			for(int i= ARRSIZE-1;i >0;i--){
				c = x[i] + z[i];
				x[i] = (char) (c % 10);
				x[i-1] += c/10;
				run |= z[i];
			}
			a ++;
			b += 2;
		}
		System.out.println("counting:" + cnt);
		System.out.println("pi = " + (int)x[0] + "" + (int)x[1] + ".");
		for(int i=0;i<DISPCNT;i++){
			if(i >0 && ((i%100)==0))
				System.out.println();
			System.out.println((int)x[i+2]);
		}
	}
}
