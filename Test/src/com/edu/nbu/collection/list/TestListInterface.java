package com.edu.nbu.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestListInterface {
	public static void main(String[] args) {
		List<Integer> listTest = new LinkedList<Integer>();
//		listTest.add(123);
//		Long[] longList = new Long[listTest.size()];
//		listTest.toArray(longList);

//		List<Long> resultList = Arrays.asList(longList);
//		for(Long long1 : resultList){
//			System.out.println(long1);
//		}
		
		//		List<Integer> list = new ArrayList<Integer>();
//		Set<Long> set = new HashSet<Long>();
		for(int i=0;i<= 21;i++){
//			set.add(i);
			listTest.add(i);
		}
		System.out.println(listTest.size());
		for(Integer integer : listTest){
			System.out.print(integer);
		}
		System.out.println();
		Iterator linkedListIterator = listTest.iterator();
		while(linkedListIterator.hasNext()){
			System.out.print(linkedListIterator.next());
		}
	}
	
	
//	public static void 
}
