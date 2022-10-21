package at.ac.fhcampuswien;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        //Aufgabe 1
        oneMonthCalendar(28,2);

        //Aufgabe 2
        long[] result = new long [10];
        result = lcg(5);
        for(int i = 0; i < 10;i++ ){
            System.out.println(result[i]);
        }

        //Aufgabe 3
        guessingGame(randomNumberBetweenOneAndHundred());

        //Aufgabe 4
        int x[] = {1,3,5};
        int y[] = {2,4,6};
        System.out.println(swapArrays(x,y));

        //Aufgabe 5
        System.out.println(camelCase("Das i!!St eIn Tes#t!"));

        //Aufgabe 6
        int code[] = {3,9,1,5,8};
        System.out.println(checkDigit(code));

    }

    public static void oneMonthCalendar (int anzahlTage, int wochentag){
        int tag = 1;
        anzahlTage += wochentag-1;

        for(int i=1; i <= anzahlTage; i++){
            if(i < wochentag){
                System.out.print("   ");
            } else {
                tag = i - (wochentag - 1);
                System.out.printf("%2d ", tag);
            }
            if(i%7 == 0){
                System.out.print(System.lineSeparator());
            }
        }

        if(anzahlTage%7 > 0){
            System.out.println();
        }

    }

    public static long[] lcg (long x){
        long a = 1103515245, c = 12345, m = (long)Math.pow(2, 31);
        long[] result = new long [10];

        for (int i = 0; i < 10; i++){
            result[i] = (long)(a * x + c)%m;
            x = result[i];
        }
        return result;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        for(int i=1; i<=10; i++){
            System.out.print("Guess number "+i+": ");
            input = scanner.nextInt();

            if(input == numberToGuess && i != 10){
                System.out.println("You won wisenheimer!");
                break;
            } else if(input < numberToGuess && i != 10) {
                System.out.println("The number AI picked is higher than your guess.");
            } else if(input > numberToGuess && i != 10){
                System.out.println("The number AI picked is lower than your guess.");
            } else {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
            }

        }

    }

    public static int randomNumberBetweenOneAndHundred(){
        // https://java2blog.com/generate-random-number-between-1-and-100-java/#:~:text=Generate%20a%20random%20number%20by,number%20returned%20by%20the%20method.
        Random randI = new Random();
        int myRandInt = randI.nextInt(100);
        return myRandInt+1;
    }

    public static boolean swapArrays(int[] array1, int[] array2){
        if(array1.length != array2.length){
            return false;
        }

        for(int i = 0; i < array1.length; i++){
            array1[i] = array1[i] - array2[i];
            array2[i] = array1[i] + array2[i];
            array1[i] = array2[i] - array1[i];
        }
        return true;

    }

    public static String camelCase(String satz){
        char[] fragmente = satz.toCharArray();
        String camelCase = "";
        boolean spaceFlag = false;

        for(int i = 0; i < fragmente.length; i++){

            if((int)fragmente[i] >= 65 && (int)fragmente[i] <= 90){
                fragmente[i] =(char)(fragmente[i]+32);
            }

            if(spaceFlag == true || i == 0){
                fragmente[i] =(char)(fragmente[i]-32);
            }

            if((int)fragmente[i] == 32){
                spaceFlag = true;
            } else {
                spaceFlag = false;
            }

            if(((int)fragmente[i] >= 97 && (int)fragmente[i] <= 122) || ((int)fragmente[i] >= 65 && (int)fragmente[i] <= 90)) {
                camelCase += (char)fragmente[i];
            }
        }

        return camelCase;
    }

    public static int checkDigit(int[] code){
        int pruefziffer = 0, gewichtung = 0, produkt = 0, summe = 0, mod = 0;

        for(int i = 0; i<code.length; i++){
            gewichtung = i +2;
            produkt = code[i] * gewichtung;
            summe += produkt;
        }

        mod = summe%11;
        pruefziffer = 11 - mod;

        if(pruefziffer == 11 ){
            return 5;
        }

        if(pruefziffer == 10){
            return 0;
        }

        return pruefziffer;
    }

}