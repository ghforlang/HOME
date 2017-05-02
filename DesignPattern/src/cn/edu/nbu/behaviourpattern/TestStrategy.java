package cn.edu.nbu.behaviourpattern;


public class TestStrategy {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "2*8";
		ICalculator mutipuly = new Multiply();
		int result = mutipuly.calculate(exp);
		System.out.println(result);
	}
}

//¸¨Öú¹¤¾ßÀà
abstract class AbstractCalculator{
	public int[] split(String exp,String opt){
		String array[] = exp.split(opt);
		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		
		return arrayInt;
	}
}

class Plus extends AbstractCalculator implements ICalculator{
	@Override
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int arrayInt[] = split(exp, "+");
		return arrayInt[0] + arrayInt[1];
	}
}

class Minus extends AbstractCalculator implements ICalculator{
	@Override
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int[] arrayInt = split(exp, "-");
		return arrayInt[0]-arrayInt[1];
	}
}

class Multiply extends AbstractCalculator implements ICalculator{
	@Override
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int arrayInt[] = split(exp, "\\*");
		return arrayInt[0]*arrayInt[1];
	}
}