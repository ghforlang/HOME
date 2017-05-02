package cn.edu.nbu.creativepattern;
//���󹤳�ģʽ��������������࣬����һ����Ҫ�����µĹ��ܣ�
//ֱ�������µĹ�����Ϳ����ˣ�����Ҫ�޸�֮ǰ�Ĵ���
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