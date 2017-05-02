package com.edu.nbu.collection.trans;

public class Test {
	public static void main(String[] args) {
		int[] aa = {1,2};
		swap2(aa,0,1);
		for(int i = 0;i<aa.length;i++){
			System.out.println(aa[i]);
		}
		
		int a = 11;
		int b = 12;
		swap3(a,b);
//		System.out.println("aa=" + aa + " b = " + b);
		Test test = new Test();
//		test.test(a);
//		System.out.println("main方法中的a = " + a);
	}
	
	public static void swap(int[]a,int i,int j){
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
//		int temp = i;
//		i = j;
//		j = temp;
	}
	
	public static void swap2(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void swap3(int a,int b){
		int temp = a;
		a = b;
		b = temp;
	}

	public static void test(int a){
		a = 5;
		System.out.println("test方法中的a = " + a);
	}
}
