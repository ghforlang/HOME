package JustForTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerializable {
	public static void main(String[] args) {
		String fileName = "time.txt";//�ļ�����λ��
		Person p =new Person("marson", "mark");
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			//���루���л�����һ����ʽ
			fos = new FileOutputStream(fileName);//���屣����ļ�����
			oos = new ObjectOutputStream(fos);//����������������
			oos.writeObject(p);
			
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			p = (Person)ois.readObject();
			
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(p);
	}
}

class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	transient private Thread myThread;//�˴�û���õ�myThread������ʾ��transient
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Person(String firstName,String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.myThread = new Thread();
	}
	
	public String toString(){
		return "Person[firstName=" + firstName +",lastName=" + lastName + "]";
	}
	
}