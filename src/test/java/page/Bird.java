package page;

public class Bird extends Animal{

    public Bird(String name){
        this.name= name;
    }

    public void speak(){
        System.out.println(classAndName()+" is chirping!");
    }
    public void walk(){
        System.out.println(classAndName()+" is flying!");
    }
}
