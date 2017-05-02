package JustForTest;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class TestExternalizable implements Externalizable{
	private transient String content = "�ǵ��ҽ������л����������Ƿ�transient����";
	
	public static void main(String[] args) throws Exception{
		TestExternalizable te = new TestExternalizable();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
		//oos.writeObject(te);
		te.writeExternal(oos);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));
		te.readExternal(ois);
		//te = (TestExternalizable)ois.readObject();
		System.out.println(te.content);
		
		oos.close();
		ois.close();
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		content = (String)in.readObject();//�ֶ�ʵ����Ҫ���л��ı���
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(content);
	}

}
