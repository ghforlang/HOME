package cn.edu.nbu.creativepattern;
//多方法简单工厂：多个工厂方法模式是提供多个工厂方法，分别创建对象
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

