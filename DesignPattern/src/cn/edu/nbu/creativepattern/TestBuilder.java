package cn.edu.nbu.creativepattern;

import java.util.ArrayList;
import java.util.List;
//建造者模式用来创建复合对象，所谓复合对象就是指某个类具有不同的属性
//与工厂模式的区别：工厂模式关注创建单个对象，建造者模式则关注创建复合对象。
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
