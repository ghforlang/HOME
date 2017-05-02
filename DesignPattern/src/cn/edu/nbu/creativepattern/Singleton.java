package cn.edu.nbu.creativepattern;

public class Singleton {
	//����˽�о�̬ʵ������ֹ�����ã���ֵΪnull,ʵ���ӳټ���
	private static Singleton instance = null;
	
	//˽�й��췽������ֹ��ʵ����
	private Singleton(){}
	
	//��̬����������ʵ��
	//���̻߳����»�������⣻instace = new Singleton()������ִ�У�����μ�package-info
	//���ü�������
	public synchronized static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	//��С��������
	public static Singleton getInstance1(){
		synchronized (instance) {
			if(instance == null)
				instance = new Singleton();
		}
		return instance;
	}
	
	//�������л�����
	public Object readResolve(){
		return instance;
	}
}
