package cn.edu.nbu.creativepattern;
//抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，
//直接增加新的工厂类就可以了，不需要修改之前的代码
public class AbstractFactory {
	public static void main(String[] args) {
		Provider provider = new SmsFactory();
		provider.produce();
	}
}

interface Provider{
	public Sender produce();
}

class SmsFactory implements Provider{
	@Override
	public Sender produce() {
		return new SmsSender();
	}
	
}

class MailFactory implements Provider{
	@Override
	public Sender produce() {
		return new MailSender();
	}
	
}