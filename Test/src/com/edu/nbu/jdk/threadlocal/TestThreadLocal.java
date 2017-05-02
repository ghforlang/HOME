package com.edu.nbu.jdk.threadlocal;

public class TestThreadLocal implements Sequence{
	//非线程安全实现，多线程共享变量number;
	private static int number = 0;
	@Override
	public int getNumber() {
		number ++;
		return number;
	}
	
	public static void main(String[] args) {
		Sequence sequence = new TestThreadLocal();
		
		MyThread thread1 = new MyThread(sequence);
		MyThread thread2 = new MyThread(sequence);
		MyThread thread3 = new MyThread(sequence);
		MyThread thread4 = new MyThread(sequence);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
