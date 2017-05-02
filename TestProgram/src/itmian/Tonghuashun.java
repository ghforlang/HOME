package itmian;
/**
 * @author lenovo
 * input: 2014-12-31 23:59:56 ,n
 * output: 2015-01-01 00:00:06
 *
 */
public class Tonghuashun {
	public static final int S = 60;
	public static final int H = 24;
	public static String changeTime(String arr,int n){
		String result = "";
		int leapm[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int nleapm[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};
		int y,mo,d,h,mi,s = 0;
		boolean isleap=false;
		char a[] = arr.toCharArray();
		
		y = (a[0]-'0')*1000 + (a[1]-'0')*100+(a[2]-'0')*10+(a[3]-'0');
		mo = (a[5]-'0')*10 + (a[6] -'0');
		d = (a[8]-'0')*10 + (a[9] -'0'); 
		h = (a[11]-'0')*10 + (a[12] -'0');
		mi = (a[14]-'0')*10 + (a[15] -'0');
		s = (a[17]-'0')*10 + (a[18] -'0');
		System.out.println(y+ "-" + mo + "-" + d + " " + h+ ":"+ mi+ ":" + s);	
		s += n;
		if(s >= S){
			int ss = s;
			s %= S;
			mi += (ss/S);
			if(mi >= S){
				int mm = mi;
				mi %= S;
				h += (mm/S);
				if(h >= H){
					int hh = h;
					h %= H;
					d += (hh/H);
				}
			}
		}
		System.out.println(y+ "-" + mo + "-" + d + " " + h+ ":"+ mi+ ":" + s);
		if(y%400 == 0||(y%4 == 0 && y%100 != 0))
			isleap = true;
		if(isleap){
			if(d > leapm[mo]){
				int day = d;
				d -= leapm[mo];
				mo += (day/leapm[mo]);
				if(mo > 12){
					int month = mo;
					mo %= 12;
					y += (month /12);
				}
			}
		}else{
			if(d > nleapm[mo]){
				int day = d;
				d -= nleapm[mo];
				mo += (day/nleapm[mo]);
				if(mo > 12){
					int month = mo;
					mo %= 12;
					y += (month /12);
				}
			}	
		}
		System.out.println(y+ "-" + mo + "-" + d + " " + h+ ":"+ mi+ ":" + s);
		String yString = Integer.toString(y);
		String moString = Integer.toString(mo);
		String dString = Integer.toString(d);
		String hString = Integer.toString(h);
		String miString = Integer.toString(mi);
		String sString = Integer.toString(s);
		result += yString;
		if(mo < 10)
			moString = "0" + moString;
		result += ("-" + moString);
		if(d < 10)
			dString = "0" + dString;
		result += ("-" + dString);
		if(h < 10)
			hString = "0" + hString;
		result += (" " + hString);
		if(mi < 10)
			miString = "0" + miString;
		result += (":"+ miString);
		if(s < 10)
			sString = "0" + sString;
		result += (":" + sString);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "2014-12-31 23:59:56";
		int n = 10;
		System.out.println(changeTime(test,n));
	}

}
