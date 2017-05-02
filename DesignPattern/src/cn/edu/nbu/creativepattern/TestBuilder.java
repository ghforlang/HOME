package cn.edu.nbu.creativepattern;

import java.util.ArrayList;
import java.util.List;
//������ģʽ�����������϶�����ν���϶������ָĳ������в�ͬ������
//�빤��ģʽ�����𣺹���ģʽ��ע�����������󣬽�����ģʽ���ע�������϶���
public class TestBuilder {
	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceMailSender(10);
	}
}

class Builder{
	private List<Sender> list = new ArrayList<Sender>();
	
	public void produceMailSender(int count){
		for(int i=0;i<count;i++){
			list.add(new MailSender());
		}
	}
	
	public void produceSmsSender(int count){
		for(int i=0;i<count;i++){
			list.add(new SmsSender());
		}
	}
}
