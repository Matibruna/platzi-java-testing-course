package javatest.util;

public class FizzBuzz {

    public static String fizzBuzz(int num){

        if(num % 5 == 0){
            if(num % 3 == 0){
                return "FizzBuzz";
            }else{
                return "Buzz";
            }
        } else if(num % 3 == 0) {
            return "Fizz";
        } else {
            return Integer.toString(num);
        }
    }
}
