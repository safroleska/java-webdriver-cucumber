package page;

public class Fish extends Animal{

    public void walk() {
        System.out.println(classAndName()+ " is swimming!");
    }

    public void speak(){
        System.out.println(classAndName()+ " is not speaking!");
    }
}
