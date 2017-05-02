package test;


import java.util.List;

import util.TcpUtils;

public class TestTcpUtils {
	public static void main(String[] args){
		String hoString = "caoliu.com";
		List<String> strList = TcpUtils.getAllHostAddress(hoString);
		printStrList(strList);
		List<String> nameList = TcpUtils.getAllHostNames(hoString);
		printStrList(nameList);
	}
	
	public static void printStrList(List<String> list){
		if(list != null && list.size()>0){
			int i = 1;
			for(String string : list){
				System.out.println((i++) + " £º " + string);
			}
			System.out.println("******************************************");
		}
	}
}
