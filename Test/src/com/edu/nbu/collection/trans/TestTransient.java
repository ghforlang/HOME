package com.edu.nbu.collection.trans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestTransient {
	public static void main(String[] args) {
		test1();
//		test2();
	}
	
	public static void test1(){
		LoggingInfo logInfo = new LoggingInfo("MIKE", "MECHANICS");
		System.out.println(logInfo.toString());
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
					"logInfo.out"));
			o.writeObject(logInfo);
			o.close();
		} catch (Exception e) {// deal with exception
			e.printStackTrace();
		}

		// To read the object back, we can write

		try {
			LoggingInfo.name = "lisi";//反序列化之前改变static变量值，查看最终static变量值
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"logInfo.out"));
			LoggingInfo logInfo2 = (LoggingInfo) in.readObject();
			System.out.println(logInfo2.toString());
		} catch (Exception ex) {// deal with exception
			ex.printStackTrace();
		}
	}
	
	public static void test2(){
		GuestLoggingInfo logInfo = new GuestLoggingInfo();
		System.out.println(logInfo.toString());
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
					"logInfo.out"));
			o.writeObject(logInfo);
			o.close();
		} catch (Exception e) {// deal with exception
			e.printStackTrace();
		}

		// To read the object back, we can write

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"logInfo.out"));
			GuestLoggingInfo logInfo2 = (GuestLoggingInfo) in.readObject();
			System.out.println(logInfo2.toString());
		} catch (Exception ex) {// deal with exception
			ex.printStackTrace();
		}
	}
}
