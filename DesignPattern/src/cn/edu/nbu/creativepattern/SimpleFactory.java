package cn.edu.nbu.creativepattern;
//普通简单工厂：建立一个工厂类，对实现了同一接口的一些类进行实例的创建

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


//默认包权限，包内其他class也可以使用
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