package com.edu.nbu.jdk.threadlocal;

public class TestThreadLocal2 implements Sequence{
	
	private static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		}
	};
	@Override
	public int getNumber() {
		numberContainer.set(numberContainer.get() + 1);
		// TODO Auto-generated method stub
		return numberContainer.get();
	}

	public static void main(String[] args){
		Sequence sequence = new TestThreadLocal2();
		
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
