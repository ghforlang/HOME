package cn.edu.nbu.creativepattern;

public class TestSingleton {
	
	//˽�й��췽������ֹ��ʵ����
	private TestSingleton(){}
	//�ڲ���ά������
	private static class SingletonFactory{
		private static TestSingleton instance = new TestSingleton();
	}
	//��ȡʵ��
	public static TestSingleton getInstance(){
		return SingletonFactory.instance;
	}
	//���ö����������л������Ա�֤���������л�ǰ�󱣳�һ��
	public Object readResolve(){
		return getInstance();
	}
}
