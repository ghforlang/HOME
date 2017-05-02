package Chapter9;

public class Practice10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playable orchestra[] = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new WoodWind()
		};
		tuneAll(orchestra);
	}
	static void tune(Playable p){
		p.play(Note.MIDDLE_C);
	}
	static void tuneAll(Playable[] p){
		for(Playable play:p)
			tune(play);
	}
}

interface Playable{
	void play(Note n);
}

interface Instrument{
	int VALUE = 5;
	void adjust();
}

class Wind implements Playable,Instrument{
	public void play(Note n){
		System.out.println(this + ".play" + n);
	}
	public void adjust(){
		System.out.println(this + ".adjust");
	}
}

class Percussion implements Playable ,Instrument{
	public void play(Note n){
		System.out.println(this + ".play" + n);
	}
	public void adjust(){
		System.out.println(this + ".adjust");
	}
}

class Stringed implements Playable ,Instrument{
	public void play(Note n){
		System.out.println(this + ".play" + n);
	}
	public void adjust(){
		System.out.println(this + ".adjust");
	}
}

class Brass extends Wind{
	public String toString(){
		return "Brass";
	}
}

class WoodWind extends Wind{
	public String toString(){
		return "WoodWind";
	}
}