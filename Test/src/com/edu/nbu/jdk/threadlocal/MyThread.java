package com.edu.nbu.jdk.threadlocal;

public class MyThread extends Thread{
	private Sequence sequence;
	
	public MyThread(Sequence sequence){
		this.sequence = sequence;
	}


	@Override
	public void run() {
		for(int i=0;i<3;i++){
			System.out.println(Thread.currentThread().getName() + "=>" + sequence.getNumber());
		}
	}
}
