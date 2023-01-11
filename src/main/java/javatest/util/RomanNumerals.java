package javatest.util;

public class RomanNumerals {

    public static String arabicToRoman(int n) {
        StringBuilder result = new StringBuilder();
        int count = n;

        while(count != 0){

            if(count >= 1000){
                result.append("M");
                count -= 1000;
                continue;
            } else if(count >= 800) {
                result.append("D");
                count -= 500;

                for (int i = 0; i < count-500/100; i++) {
                    result.append("C");
                    count -= 100;
                }
            }
            if(count >= 500){
                result.append("D");
                count -= 500;
            } else if(count >= 300) {
                int times = (count / 100) - 1;

                for (int i = 0; i < times; i++) {
                    result.append("C");
                }
                count -= (500-(times*100));
                result.append("D");
            }
            if(count >= 100){
                result.append("C");
                count -= 100;
            } else if(count >= 80) {
                int times = 10 - (count / 10);

                for (int i = 0; i < times; i++) {
                    result.append("X");
                }
                count -= (500-(times*100));
                result.append("C");
            }
            if(count >= 50){
                result.append("L");
                count -= 50;
            } else if (count >= 40) {
                count -= 40;
                result.append("XL");
            }
            if(count >= 10){
                result.append("X");
                count -= 10;
                continue;
            } else if (count >= 8) {

                int times = 10-count;

                for (int i = 1; i <= times; i++) {
                    result.append("I");
                    count -= 1;
                }

                result.append("X");
                break;
            }
            if(count >= 5){
                result.append("V");
                count -= 5;
            } else if (count == 4) {
                result.append("IV");
                count -= 4;
            } else {
                for (int i = 0; i < count; i++) {
                    result.append("I");
                }
                count -= count;
            }
        }

        return result.toString();
    }
}
