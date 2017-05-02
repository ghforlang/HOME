package cn.edu.nbu.creativepattern;

//��̬���������������������ģʽ��ķ�����Ϊ��̬�ģ�����Ҫ����ʵ����ֱ�ӵ��ü���
public class SimpleFactory2 {

	public static void main(String[] args) {
		Sender sender = SimpleFactory2.produceMailSender();
		sender.send();
	}
	
	public static Sender produceSms(){
		return new SmsSender();
	}
	
	public static Sender produceMailSender(){
		return new MailSender();
	}

}

