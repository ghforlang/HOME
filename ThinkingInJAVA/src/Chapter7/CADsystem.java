package Chapter7;
//清理顺序须与对象声明顺序相反；
public class CADsystem extends Shape{
	private Circle c;
	private Triangle t;
	private Line[] l = new Line[3];
	
	public CADsystem(int i){
		super(i+1);
		for(int j=0;j<3;j++)
			l[j] = new Line(j, j*j);
		c = new Circle(i);
		t = new Triangle(i);
		System.out.println("combined Constructor");
	}
	public static void main(String[] args) {
		CADsystem cad = new CADsystem(1);
		try {
			System.out.println("try-catch block");
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			cad.dispose();
		}
	}
	public void dispose(){
		System.out.println("CADsystem dispose");
		t.dispose();
		c.dispose();
		for(int i=0;i<3;i++)
			l[i].dispose();
		super.dispose();
	}
}

class Shape{
	public Shape(int i){
		System.out.println("Shape Constructor");
	}
	
	public void dispose(){
		System.out.println("Shape dispose");
	}
}

class Circle extends Shape{
	public Circle(int i){
		super(i);
		System.out.println("Circle Constructor");
	}
	public void dispose(){
		System.out.println("Circle dispose");
		super.dispose();
	}
}

class Triangle extends Shape{
	public Triangle(int i){
		super(i);
		System.out.println("Triangle Constructor");
	}
	public void dispose(){
		System.out.println("Triangle dispose");
		super.dispose();
	}
}

class Line extends Shape{
	private int start,end;
	public Line(int start,int end){
		super(start);
		this.start = start;
		this.end = end;
		System.out.println("Line Constructor");
	}
	public void dispose(){
		System.out.println("Line dispose");
		super.dispose();
	}
}
