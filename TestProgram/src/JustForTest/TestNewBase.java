package JustForTest;

public class TestNewBase extends New {

    private String name = "TestNewBase";

    public TestNewBase() {
        tellName();
        printName();
    }
    
    public void tellName() {
        System.out.println("TestNewBase tell name: " + name);
    }
    
    public void printName() {
        System.out.println("TestNewBase print name: " + name);
    }

    public static void main(String[] args){
        
        new TestNewBase();    
    }
}

class New {
    
    private String name = "New";

    public New() {
        tellName();
        printName();
    }
    
    public void tellName() {
        System.out.println("New tell name: " + name);
    }
    
    public void printName() {
        System.out.println("New print name: " + name);
    }
}