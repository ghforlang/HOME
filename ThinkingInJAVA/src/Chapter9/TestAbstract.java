package Chapter9;

public class TestAbstract {
	
}

abstract class AAAA{
	abstract void print();
	abstract void printf();
}
//若方法不提供具体实现，则默认是抽象,要求添加abstract关键字
abstract class BBBB extends AAAA{
	abstract void print();
	abstract void sss();
}
