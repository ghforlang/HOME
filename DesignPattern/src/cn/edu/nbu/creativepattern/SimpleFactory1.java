package cn.edu.nbu.creativepattern;
//�෽���򵥹����������������ģʽ���ṩ��������������ֱ𴴽�����
public class SimpleFactory1 {

	public static void main(String[] args) {
		SimpleFactory1 simpleFactory1 = new SimpleFactory1();
		Sender sender = simpleFactory1.produceMailSender();
		sender.send();
	}
	
	public Sender produceMailSender(){
		return new MailSender();
	}
	
	public Sender produceSmsSender(){
		return new SmsSender();
	}
}

