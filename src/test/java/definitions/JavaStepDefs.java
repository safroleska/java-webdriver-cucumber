package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaStepDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println("Hello world");
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @And("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println( "str1:" + str1);
        System.out.println( "str2:" + str2);

        System.out.println(str1.toUpperCase());
        System.out.println(str1.length());
        System.out.println(str1.equals("var1"));
    }


    @Given("My name is {string}")
    public void myNameIs(String name) {
        String firstName = "John";
        String lastName = "Doe";
        String color = "blue";
        System.out.println("My name is " + name);
        System.out.println( "My name is " + firstName+ " "+lastName+ ". My favourite color is "+color+"!");
        System.out.println(firstName.toLowerCase());
        System.out.println(color.toUpperCase());
        System.out.println(lastName.length());
        System.out.println(color.equals("BLUE"));
        System.out.println(color.equalsIgnoreCase("BLUE"));
        System.out.println(name.contains(firstName));
    }

    @And("I work with arrays")
    public void iWorkWithArrays() {
        int[] nums= {7, 2, 5, 10, 1, 3};
        for (int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
        String[] fruits={"kiwi", "apple", "orange"};
        for (String fruit: fruits){
            System.out.print(fruit + " ");
        }
        System.out.println();
        System.out.println(fruits[0]);
//        List<Integer> listOfnums= Arrays.asList(7, 2, 5, 10, 1, 3);
        List<Integer> listOfnums= new ArrayList<>();
        listOfnums.add(10);
        listOfnums.add(9);
        listOfnums.add(8);
        for (Integer i:listOfnums) {
            System.out.print(i + " ");
        }
        List<String> listOfStrings= new ArrayList<>();
        listOfStrings.add("kiwi");
        listOfStrings.add("apple");
        listOfStrings.add("orange");
        for (String fruit: listOfStrings){
            System.out.println(fruit);
        }
    }
}
