package cn.edu.nbu.creativepattern;
//��ͨ�򵥹���������һ�������࣬��ʵ����ͬһ�ӿڵ�һЩ�����ʵ���Ĵ���

public class SimpleFactory {

	public static void main(String[] args) {
		SimpleFactory simpleFactory = new SimpleFactory();
		Sender sender = simpleFactory.produce("sms");
		sender.send();
	}
	
	public Sender produce(String type){
		if("mail".equals(type)){
			return new MailSender();
		}
		else if("sms".equals(type))
			return new SmsSender();
		else
			return null;
	}
}


//Ĭ�ϰ�Ȩ�ޣ���������classҲ����ʹ��
interface Sender{
	public void send();
}


class MailSender implements Sender{

	@Override
	public void send() {
		System.out.println("this is mailSender");
	}
}

class SmsSender implements Sender{

	@Override
	public void send() {
		System.out.println("this is smsSender");
	}
	
}