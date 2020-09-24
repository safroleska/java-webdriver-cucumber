package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.hu.Ha;
import page.*;

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
        System.out.println("str1:" + str1);
        System.out.println("str2:" + str2);

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
        System.out.println("My name is " + firstName + " " + lastName + ". My favourite color is " + color + "!");
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
        String[] shopList = {"milk", "bread", "eggs", "tea", "chocolate"};
        System.out.println("My shopping list: ");
        for (String i : shopList) {
            System.out.println(i + " ");
        }
        System.out.println(shopList[0]);//print milk
        System.out.println(shopList[3]);//print tea
    }

    @And("I print {int} th day of week")
    public void iPrintThDayOfWeek(int i) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(days[i - 1]);
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num >= 0) {
            System.out.println(num + " is positive");
        } else {
            System.out.println(num + " is negative");
        }

    }


    @Given("I work with integers")
    public void iWorkWithIntegers() {
        System.out.println(14 / 7);//result is int
        System.out.println(50.0 / 2);//result is float
        int num1 = 30;
        int num2 = 5;
        int sum = num1 + num2;
        int difference = num1 - num2;
        int quotient = num1 / num2;
        int product = num1 * num2;
        System.out.println("The sum is " + sum);
        System.out.println("The difference is " + difference);
        System.out.println("The quotient is " + quotient);
        System.out.println("The product is " + product);

    }

    @And("I work with boolean")
    public void iWorkWithBoolean() {
        String notFavouriteColor = "brown";
        System.out.println(notFavouriteColor.equals("blue"));//false
        System.out.println(notFavouriteColor.equals("brown"));//true
    }


    @And("I print url for {string} page")
    public void iPrintUrlForPage(String site) {
        if (site.equalsIgnoreCase("google")) {
            System.out.println("https://www.google.com/");
        } else if (site.equalsIgnoreCase("Sample")) {
            System.out.println("www.sample.com");
        } else {
            System.out.println("I don't know this site");
        }
    }

    @And("I print {string} day of week")
    public void iPrintDayOfWeek(String day) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int index = Integer.valueOf(day) - 1;
        System.out.println(daysOfWeek[index]);
    }

    @And("I print every {int} rd day of week")
    public void iPrintEveryRdDayOfWeek(int every) {
        String[] daysOfweek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int i = 1;
        for (String day : daysOfweek) {
            if (i % every == 0) {
                System.out.println(day);
            }
            i++;
        }
        System.out.println("------");
        for (int j = 1; j <= daysOfweek.length; j++) {
            if (j % every == 0) {
                System.out.println(daysOfweek[j - 1]);
            }
        }
        System.out.println("------");
        for (int k = every; k <= daysOfweek.length; k = k + every) {
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

        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "George");
        info.put("middleName", "John");
        System.out.println(info);
        String add = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", add);
        System.out.println(info);
    }

    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
//        System.out.println("I solve coding challenges");
//        //swap
//        swap(5, 3);
//        Map<String, String> info = new LinkedHashMap<>();
//        info.put("firstName", "George");
//        info.put("middleName", "John");
//        swapMap(Map<>info);

//        ReturnNumbers(20);

//        PrintReversed("Olesya");
//        String str = "Olesya";
//        System.out.println(getReversed(str));
//        System.out.println(getEveryThird("WebDriver"));
//        speakLikeYoda("I am Automation Engineer");
//        System.out.println(isPalindrome1("noon"));

//        int[] unsortedArr= {2, 5, 10, 4, 9};
//        int num=3;
//        System.out.println(findSum(unsortedArr,num));
//        System.out.println(factorial(5));
//        swapTwoNumInArr(1,3,new int[] {1,2,3,4,5});
        int[] arr={4,5,8,5,9,1};
//        sortArr(arr);
//        System.out.println(isPrime(2));
//        System.out.println(isPrime(1));
//        System.out.println(isPrime(0));
//        System.out.println(isPrime(-4341));
//        System.out.println(isPrime(8));
//        System.out.println(isPrime(9));
//        System.out.println(isPrime(97));
//        System.out.println(isPrime(Integer.MAX_VALUE));
//
//        for (int i = 1; i < 500; i++) {
//            if (isPrime(i)) {
//                System.out.print(i + " ");
//            }
//        }
//        System.out.println(ifArrayContainsDuplicates(arr));



    }




    //        int[] unsortedArr = {5, 8, 7, 5, 1};
//        System.out.println(findSum(unsortedArr, 6));
//        System.out.println(findSum(unsortedArr, 8));
//        System.out.println(findSum(unsortedArr, 5));
//        System.out.println(factorial(0));
//        System.out.println(factorial(5));
//        int[] arr1 = {6, 2, 3, 5, 9};
//        int[] arr2 = {6, 2, 9, 5, 7};
//        find2MaxNumbers(arr2);
//        for (int i = 1; i <= 11; i++) {
//            System.out.print(fib(i) + " ");
//        }
//    void countCharacters(String str){
//
//        for(int i=0;i<str.length();i++){
//            int count=1;
//            for(int j=i+1; j<str.length(); j++){
//                if(str.charAt(i)==str.charAt(j)){
//                    count++;
//                }
//
//            }
//            System.out.print(str.charAt(i)+" "+count+"; ");
//
//        }
//
//    }

    boolean isPrime(int num) {
        System.out.println("Checking if " + num + " is prime...");
        if (num < 2) {
            return false;
        }

        if (num % 2 == 0 && num != 2) {
            return false;
        }

        double sqrt = Math.sqrt(num);
        for (int i = 3; i <= sqrt; i+=2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    long fib(long num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fib(num - 1) + fib(num - 2);
    }


    // 1 1 2 3 5 8 13 21 35 55 89
    long fibFor(int seq) {
        long prevFib = 0;
        long nextFib = 1;
        for (int i = 1; i < seq; i++) {
            long temp = nextFib;
            nextFib = prevFib + nextFib;
            prevFib = temp;
        }
        return nextFib;
    }

    // O (n2)
    void find2MaxNumbers(int[] arr) {
        System.out.println("Two max num");
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max1 < arr[i]) {
                max2 = max1;
                max1 = arr[i];
            } else if (max2 < arr[i]) {
                max2 = arr[i];
            }
        }
        System.out.println("First max: " + max1 + " Second max: " + max2);
    }



    // O(n)
    int maxNum(int[] arr) {
        System.out.println("Max num");
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }


    void sortArr(int[] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j< arr.length-1;j++){
                if (arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    void swapTwoNumInArr(int a, int b, int[] arr){
        int temp = arr[a - 1];
        arr[a - 1] = arr[b - 1];
        arr[b - 1] = temp;
        for (int i:arr) {
            System.out.print(i);
        }
    }

    long factorial(long num){
        if (num==0){
            return 1;
        }
        return num*factorial(num-1);
    }

    boolean findSum(int[] arr, int num){
        for (int i=0; i<arr.length;i++){
            for(int j=i+1; j<arr.length;j++){
                if( arr[i]+arr[j]==num){
                    return true;
                }
            }
        }
        return false;

    }
//    Write a function that find 2 max numbers in an array
//    Write a function that counts number of each character in a string
//    Write a	function to	find the largest element in an array and test it
//    Write a	function that reverses	string	without	extra string variable
//    Write a	function that performs a binary	search
//    void twoMaxNumbers(int[] array){
//
//        for (int i=0; i<array.length; i++){
//            int max1=array[0];
//            if (array[i]>max1){
//                max1=array[i];
//            }
//            for(int j=0; j<array.length;j++){
//                int max2=array[0];
//                if (array[j]>max2 && array[j]!=max1){
//                    max2=array[j];
//                }
//            }
//            System.out.print(max1);
//        }
//
//    }

    boolean ifArrayContainsDuplicates(int[] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
                if (arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    boolean isPalindrome1(String word){
        int j=0;
        for (int i=word.length()-1;i>=word.length()/2; i--){

            if (word.charAt(i)!=word.charAt(j)){
                return false;
            }
            j++;
        }
        return true;
    }

    boolean isPalindrome(String word){
        String str="";
        for (int i=word.length()-1;i>=0;i--){

            str+=word.charAt(i);
        }
        return str.equals(word);

    }
    int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    //generic function that i can use when we don't know the type of array
    boolean ifContainsElement(Object[] arr,Object num){
        System.out.println("ifContaining() method: ");
        for (int i=0; i<arr.length;i++){
            if (arr[i].equals(num)){
                return true;
            }
        }
        return false;
    }

    boolean ifContainsElement(int[] arr,int num){
        System.out.println("ifContaining() method: ");
        for (int i=0; i<arr.length;i++){
            if (arr[i]==num){
                return true;
            }
        }
        return false;
    }

    void speakLikeYoda(String text){
        String[] arrayText= text.split(" ");
        for (int i=arrayText.length-1;i>=0;i--){
            System.out.print(arrayText[i]+" ");
            }
        }

    String getEveryThird(String str){
        System.out.println("Reverse every third character: "+str);
        String everyThird= "";
        for (int i=str.length()-1; i>=0;i--){
            if (i%3==0){
               everyThird+=str.charAt(i);
            }
        }
        return everyThird;
    }

    //return reversed
    String getReversed(String str){
        System.out.println("Return reversed "+ str);
        String reversed="";
        for (int i= str.length()-1;i>=0;i--){
            reversed+= str.charAt(i);
        }
        return reversed;
    }
    //print reversed

    void PrintReversed(String str){
        System.out.println("Print Reverse "+ str);
        for (int i=str.length()-1;i>=0;i--){
            System.out.print(str.charAt(i));
        }
    }


    void ReturnNumbers (int num){
        for (int i=0; i<= num; i++){
            System.out.print(i+ " ");
        }

    }

    void swap(int a, int b) {
        System.out.println("swap method>>>");
        System.out.println("a: " + a);
        System.out.println("b: " + b);


        int temp = a;
        a = b;
        b = temp;
    }

    void swapMap(Map<String, String> info) {
        System.out.println("swap method>>>>>");
        System.out.println("info: " + info);

        String add = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", add);

        System.out.println("info: " + info);
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
        if (number % num1 == 0 && number % num2 == 0) {
            System.out.println(number + " is divisible by " + num1 + " and " + num2);
        } else if (number % num1 == 0) {
            System.out.println(number + " is divisible by " + num1);
        } else if (number % num2 == 0) {
            System.out.println(number + " is divisible by " + num2);
        } else {
            System.out.println(number + " is not divisible neither by " + num1 + " nor " + num2);
        }
    }

    @And("I print all numbers from {int} up to n")
    public void iPrintAllNumbersFromUpToN(int arg0) {
        int n = 10;
        int[] array = {1, 5, 3, 10, 25, -2, 0, 8};
        for (int i = 0; i < array.length; i++) {
            if (0 <= array[i] && array[i] <= n) {
                System.out.print(array[i] + ", ");
            }

        }

    }

    @And("I print all integer array")
    public void iPrintAllIntegerArray() {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    @And("I print all even numbers from integer array")
    public void iPrintAllEvenNumbersFromIntegerArray() {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + ", ");
            }
        }
    }

    @And("I check if array contains another element")
    public void iCheckIfArrayContainsAnotherElement() {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int num = 8;
        for (int i : array) {
            if (i == num) {
                System.out.println("array contains " + num);
            }
        }

    }



    @And("I check if array is empty")
    public void iCheckIfArrayIsEmpty() {
        int[] array={2};
        if (array.length==0){
            System.out.println("array is empty");
        }
    }

    @And("I print also negative numbers")
    public void iPrintAlsoNegativeNumbers() {
        int[] array={1, 5, 3, 10, 25, -2, 0, 8};
        for(int i:array){
            System.out.print(i+", ");
        }
    }

    @And("I write lambda")
    public void iWriteLambda() {
        List<Integer> intList= Arrays.asList(3,8,11,2,1);
        System.out.println(intList);
    }

    @And("I print all the numbers up to the argument")
    public void iPrintAllTheNumbersUpToTheArgument() {
        int[] arr={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,};
        for (int i=0; i<arr.length;i++){
            if (arr[i]%3==0 && arr[i]%5==0){
                System.out.print("FizzBuzz, ");
            }else if (arr[i]%3==0){
                System.out.print("Fizz, ");
            }else if (arr[i]%5==0){
                System.out.print("Buzz, ");
            }else{
                System.out.print(arr[i]+", ");
            }
        }
    }

    @And("I print numbers")
    public void iPrintNumbers() {
    }

    @Given("I work with classes")
    public void iWorkWithClasses() {
        //cat
        //dog
        Cat cat= new Cat("Tom");
        System.out.println(cat.getName());
        cat.eat("fish");
        cat.sleep();
        cat.walk();
        cat.speak();

        Dog dog= new Dog();
        System.out.println(dog.getName());
        dog.eat("fish");
        dog.sleep();
        dog.walk();
        dog.speak();

        Fish fish = new Fish();
        System.out.println(fish.getName());
        fish.sleep();
        fish.walk();
        fish.speak();

        Bird bird = new Bird("Jack");
        System.out.println(bird.getName());
        bird.eat("Bugs");
        bird.speak();
        bird.walk();
        bird.sleep();


        List<Animal> list = new ArrayList<>();
        list.add(cat);
        list.add(dog);
        list.add(fish);
        list.add(bird);
        printAnimalNames(list);
    }

    public void printAnimalNames(List<Animal> animals) {
        System.out.println("print names method");
        for (Animal animal : animals) {
            animal.speak();
            animal.walk();
            System.out.println(animal.getName());
        }
    }
}
