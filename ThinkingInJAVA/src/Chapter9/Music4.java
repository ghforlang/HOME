//package Chapter9;
//
//public class Music4 {
//	static void tune(Instrument i){
//		i.play(Note.MIDDLE_C);
//	}
//	static void tuneAll(Instrument[] e){
//		for(Instrument i:e)
//			tune(i);
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Instrument[] orchestra = {
//				new Wind(),
//				new Percussion(),
//				new Stringed(),
//				new Brass(),
//				new Woodwind()
//		};
//		tuneAll(orchestra);
//	}
//}
//
//abstract class Instrument{
//	private int i;
//	public abstract void play(Note n);
//	public String what(){
//		return "Instrument";
//	}
//	public abstract void adjust();
//}
//
//class Wind extends Instrument{
//	public void play(Note n){
//		System.out.println("wind.play " + n);
//	}
//	public String  what(){
//		return "Wind";
//	}
//	public void adjust(){}
//}
//
//class Percussion extends Instrument{
//	public void play(Note n){
//		System.out.println("percussion.play " + n);
//	}
//	public String what(){
//		return "percussion";
//	}
//	public void adjust(){}
//}
//
//class Stringed extends Instrument{
//	public void play(Note n){
//		System.out.println("stringed.play " + n);
//	}
//	public String what(){
//		return "stringed";
//	}
//	public void adjust(){}
//}
//
//class Brass extends Wind{
//	public void play(Note n){
//		System.out.println("brass.play " + n);
//	}
//	public void adjust(){
//		System.out.println("brass.adjust");
//	}
//}
//
//class Woodwind extends Wind{
//	public void play(Note n){
//		System.out.println("woodwind.play" + n);
//	}
//	public String what(){
//		return "woodwind";
//	}
//}
//
