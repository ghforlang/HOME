package cn.edu.nbu.creativepattern;

//静态工厂方法：多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可
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

