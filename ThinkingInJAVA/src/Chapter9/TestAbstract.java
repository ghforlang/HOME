package Chapter9;

public class TestAbstract {
	
}

abstract class AAAA{
	abstract void print();
	abstract void printf();
}
//���������ṩ����ʵ�֣���Ĭ���ǳ���,Ҫ�����abstract�ؼ���
abstract class BBBB extends AAAA{
	abstract void print();
	abstract void sss();
}
