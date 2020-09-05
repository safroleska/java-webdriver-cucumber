package page;

public class Cat extends Animal{


    //constructor
    public Cat(String name){
        this.name= name;
    }


    public void speak(){
        System.out.println(classAndName()+" is meowing!");

    }

}
