package JustForTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestTransient {

	public static void main(String[] args) {
		User user = new User();
		user.setName("fan");
		user.setPasswd("1111");
		
		System.out.println("before serializable");
		System.out.println("user.name:" + user.getName());
		System.out.println("user.passwd:" + user.getPasswd());
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt"));
			oos.writeObject(user);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			user.setName("Alex");//验证静态变量没有被序列化
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.txt"));
			try {
				user = (User)ois.readObject();
				ois.close();
				
				System.out.println("after serializable");
				System.out.println("user.name:" + user.getName());
				System.out.println("user.passwd:" + user.getPasswd());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static String name;
	private transient String passwd;//transient修饰的变量没有被序列化
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}