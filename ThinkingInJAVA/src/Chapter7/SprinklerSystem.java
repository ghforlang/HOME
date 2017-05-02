package Chapter7;

public class SprinklerSystem {
	String s1,s2,s3,s4;
	private WaterSource waterSource = new WaterSource();
	private int i;
	private double d;
	
	public String toString(){
		return  "s1=" + s1 + ",s2=" + s2 + ",s3="
				+ s3 + ",s4=" + s4 + ",i=" + i + ",d=" + d
				+ ",waterSource=" + waterSource;
	}
	public static void main(String[] args) {
		SprinklerSystem ss = new SprinklerSystem();
		System.out.println(ss);
	}
}

class WaterSource{
	private String s;
	WaterSource(){
		System.out.println("WaterSource");
		s = "Constructor";
	}
	public String toString(){
		return s;
	}
}
