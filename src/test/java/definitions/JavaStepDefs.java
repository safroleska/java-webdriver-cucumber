package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.hu.Ha;

import java.sql.SQLOutput;
import java.util.*;

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
//        int[] nums= {7, 2, 5, 10, 1, 3};
//        for (int i:nums){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        String[] fruits={"kiwi", "apple", "orange"};
//        for (String fruit: fruits){
//            System.out.print(fruit + " ");
//        }
//        System.out.println();
//        System.out.println(fruits[0]);
//        List<Integer> listOfnums= Arrays.asList(7, 2, 5, 10, 1, 3);
//        List<Integer> listOfnums= new ArrayList<>();
//        listOfnums.add(10);
//        listOfnums.add(9);
//        listOfnums.add(8);
//        for (Integer i:listOfnums) {
//            System.out.print(i + " ");
//        }
//        List<String> listOfStrings= new ArrayList<>();
//        listOfStrings.add("kiwi");
//        listOfStrings.add("apple");
//        listOfStrings.add("orange");
//        for (String fruit: listOfStrings){
//            System.out.println(fruit);
//        }
        String[] shopList={"milk", "bread", "eggs", "tea", "chocolate"};
        System.out.println("My shopping list: ");
        for (String i:shopList){
            System.out.println(i+ " ");
        }
        System.out.println(shopList[0]);//print milk
        System.out.println(shopList[3]);//print tea
    }

    @And("I print {int} th day of week")
    public void iPrintThDayOfWeek(int i) {
        String[] days= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(days[i-1]);
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num>=0) {
            System.out.println(num + " is positive");
        } else {
            System.out.println(num+ " is negative");
        }

    }


    @Given("I work with integers")
    public void iWorkWithIntegers() {
        System.out.println(14/7);//result is int
        System.out.println(50.0/2);//result is float
        int num1=30;
        int num2=5;
        int sum=num1+num2;
        int difference=num1-num2;
        int quotient=num1/num2;
        int product=num1*num2;
        System.out.println("The sum is "+ sum);
        System.out.println("The difference is "+ difference);
        System.out.println("The quotient is "+ quotient);
        System.out.println("The product is "+ product);

    }

    @And("I work with boolean")
    public void iWorkWithBoolean() {
        String notFavouriteColor= "brown";
        System.out.println(notFavouriteColor.equals("blue"));//false
        System.out.println(notFavouriteColor.equals("brown"));//true
    }


    @And("I print url for {string} page")
    public void iPrintUrlForPage(String site) {
        if (site.equalsIgnoreCase("google")) {
            System.out.println("https://www.google.com/");
        } else if (site.equalsIgnoreCase("Sample")){
            System.out.println("www.sample.com");
        } else{
            System.out.println("I don't know this site");
        }
    }

    @And("I print {string} day of week")
    public void iPrintDayOfWeek(String day) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int index= Integer.valueOf(day)-1;
        System.out.println(daysOfWeek[index]);
    }

    @And("I print every {int} rd day of week")
    public void iPrintEveryRdDayOfWeek(int every) {
        String[] daysOfweek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int i=1;
        for (String day: daysOfweek){
            if (i% every ==0){
                System.out.println(day);
            }
            i++;
        }
        System.out.println("------");
        for (int j=1; j <= daysOfweek.length; j++){
            if (j % every ==0){
                System.out.println(daysOfweek[j-1]);
            }
        }
        System.out.println("------");
        for (int k=every; k <= daysOfweek.length; k=k+every) {
            System.out.println(daysOfweek[k - 1]);
        }
    }

    @And("I work with maps")
    public void iWorkWithMaps() {
//        Map<String, String> user = new HashMap<>();
//        user.put("username","jdoe");
//        user.put("email","john@doe.example.com");
//        user.put("password","welcome");
//        System.out.println(user);
//
//        Map<String, String> admin = new HashMap<>();
//        admin.put("username","admin");
//        admin.put("email","admin@admin.example.com");
//        admin.put("password","12345");
//        System.out.println(admin);
//
//        System.out.println("password");
//        System.out.println("email");

        Map<String,String> info = new LinkedHashMap<>();
        info.put("firstName", "George");
        info.put("middleName", "John");
        System.out.println(info);
        String add = info.get("firstName");
        info.put("firstName",info.get("middleName"));
        info.put("middleName",add);
        System.out.println(info);
    }

    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
        System.out.println("I solve coding challenges");
        //swap
        swap(5, 3);
        Map<String,String> info = new LinkedHashMap<>();
        info.put("firstName", "George");
        info.put("middleName", "John");
//        swapMap(Map<>info);
    }

    void swap(int a, int b){
        System.out.println("swap method>>>");
        System.out.println("a: "+a);
        System.out.println("b: "+b);


        int temp = a;
        a = b;
        b = temp;
    }
    void swapMap(Map<String, String> info) {
        System.out.println("swap method>>>>>");
        System.out.println("info: "+info);

        String add = info.get("firstName");
        info.put("firstName",info.get("middleName"));
        info.put("middleName",add);

        System.out.println("info: "+info);
    }


    @And("I swaps two array	elements – {int} rd	and	{int} th")
    public void iSwapsTwoArrayElementsRdAndTh(int x, int y) {
        int[] array = {5, 2, 9, 7, 3};
//        for (int i : array) {
//            System.out.print(i);
//        }
//        System.out.println();
        int temp = array[x - 1];
        array[x - 1] = array[y - 1];
        array[y - 1] = temp;
        for (int i : array) {
            System.out.print(i);
        }
    }

    @And("I return if {int} divisible by {int} or {int}")
    public void iReturnIfDivisibleByOr(int number, int num1, int num2) {
        if (number%num1==0 && number%num2==0) {
            System.out.println(number + " is divisible by " + num1 + " and " + num2);
        }else if (number%num1==0){
            System.out.println(number+" is divisible by "+num1);
        }else if (number%num2==0){
            System.out.println(number+ " is divisible by "+num2);
        } else {
            System.out.println(number +" is not divisible neither by "+num1+" nor "+num2);
        }
    }
}
