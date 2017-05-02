import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class TestChannel {
	public static void main(String[] args) throws Exception{
//		String path = TestChannel.class.getClass().getResource("/").getPath();
//		System.out.println(path);
		RandomAccessFile raFile = new RandomAccessFile("nio-data.txt", "rw");
		FileChannel inChannel = raFile.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = inChannel.read(buf);
		while(bytesRead != -1){
			System.out.println("Read : " + bytesRead);
			buf.flip();
			
			while(buf.hasRemaining()){
				System.out.println((char)buf.get());
			}
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		raFile.close();
	}
}
