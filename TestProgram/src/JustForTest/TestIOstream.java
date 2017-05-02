package JustForTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

//读取某文件中第n个字节(字符)
public class TestIOstream {

	public static void main(String[] args) throws Exception{
		FileOutputStream out = new FileOutputStream("data.txt");
		
		byte[] b = {1,2,3,4,5,6,7,8,9,0};
		out.write(b);
		out.close();
		
		/*
		FileInputStream in = new FileInputStream("data.txt");
		in.skip(5);
		int c = in.read();
		in.close();
		*/
		RandomAccessFile in = new RandomAccessFile("data.txt","r");
		in.skipBytes(5);
		int c = in.readByte();
		System.out.println(c);
	}

}
