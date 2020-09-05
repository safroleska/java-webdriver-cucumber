package page;

public class Animal {

    protected String name;

    //constructor
    public Animal(){
        this.name= "nameless one";
    }

    public String getName() {
        return "<"+name+"> ";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void walk(){
        System.out.println(classAndName()+" is walking!");
    }
    public void sleep(){
        System.out.println(classAndName()+" is sleeping!");
    }
    public void eat(String what){
        System.out.println(classAndName()+" is eating!"+ what);
    }
    public void speak(){
        System.out.println(classAndName()+" is speaking!");

    }
    protected String classAndName(){
        String[] arr=getClass().toString().split("\\.");
        return arr[arr.length-1]+" "+name;
        //return getName()+" "+name;
    }

}
