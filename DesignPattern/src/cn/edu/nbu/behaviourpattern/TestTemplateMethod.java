package cn.edu.nbu.behaviourpattern;

public class TestTemplateMethod {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractCaculator ac = new Pluses();
		String exp = "2+2";
		int result = ac.calculate(exp, "\\+");
		System.out.println(result);
	}
}

abstract class AbstractCaculator{
	//主方法，实现对本类其他方法的调用
	public final int calculate(String exp,String opt){
		int array[] = split(exp, opt);
		return calculate(array[0], array[1]);
	}
	
	//需要被子类重写的方法
	abstract public int calculate(int num1,int num2);
	
	public int[] split(String exp,String opt){
		String array[] = exp.split(opt);
		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}
}

class Pluses extends AbstractCaculator{
	@Override
	public int calculate(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}
}