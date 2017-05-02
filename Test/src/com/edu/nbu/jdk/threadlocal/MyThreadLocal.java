package com.edu.nbu.jdk.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {
	private Map<Thread, T> containerMap = Collections.synchronizedMap(new HashMap<Thread, T>());
	
	public void set(T value){
		containerMap.put(Thread.currentThread(), value);
	}
	
	public T get(){
		Thread thread = Thread.currentThread();
		T value = containerMap.get(thread);
		if(value == null && !containerMap.containsKey(thread)){
			value = initialValue();
			containerMap.put(thread, value);
		}
		return value;
	}

	public void remove(){
		containerMap.remove(Thread.currentThread());
	}
	
	private T initialValue() {
		// TODO Auto-generated method stub
		return null;
	}
}
