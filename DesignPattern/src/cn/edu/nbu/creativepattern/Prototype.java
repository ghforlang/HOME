package cn.edu.nbu.creativepattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype implements Cloneable,Serializable{

	private static final long serialVersionUID = 1L;
	
	private SerializableObj obj;
	private String string;
	//浅拷贝
	public Object clone() throws CloneNotSupportedException{
		Prototype proto = (Prototype)super.clone();
		return proto;
	}
	//深拷贝
	public Object deepClone() throws IOException,ClassNotFoundException{
		//写入当前对象二进制流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		//读出当前对象二进制流
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		return ois.readObject();
	}
	public static void main(String[] args) {
		Prototype proto = new Prototype();
		SerializableObj obj = new SerializableObj();
		String s = "aaa";
		proto.setString(s);
		proto.setObj(obj);
		
		//拷贝前
		System.out.println(proto.getString());
		System.out.println(proto.getObj().hashCode());
		
		//浅拷贝
		try {
			Prototype p  = (Prototype)proto.clone();
			System.out.println(p.getString());
			System.out.println(p.getObj().hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		//深拷贝
		try {
			Prototype pp = (Prototype)proto.deepClone();
			System.out.println(pp.getString());
			System.out.println(pp.getObj().hashCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public SerializableObj getObj() {
		return obj;
	}
	public void setObj(SerializableObj obj) {
		this.obj = obj;
	}
}

class SerializableObj implements Serializable{
	private static final long serialVersionUID = 1L;
	
}
