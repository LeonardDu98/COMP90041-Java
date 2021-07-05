package JavaS12021A1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Entry {
    private int entryId;
    private int[] numbers;

    private static int totalEntry = 0;
    private String memberID = "";
    private int price = 0;

    public Entry(){}

    public Entry(String memberID){
        totalEntry++;
        this.entryId = totalEntry;
        this.memberID = memberID;
    }

    public Entry(Scanner keyboard, String memberID){
        this.numbers = createNumber(keyboard);
        totalEntry++;
        this.entryId = totalEntry;
        this.memberID = memberID;
    }

    public int[] createNumber(Scanner keyboard){
        System.out.println("Please enter 7 different numbers (from the range " +
                "1 to 35) separated by whitespace.");
        String entry = keyboard.nextLine();
        //"1 2 3 4 5 6 7"
        String[] numbers = entry.split(" ");
        //[1 ,2, 3, 4, 5, 6, 7]String
        // < 7 > 7 same values
        if(numbers.length < 7) {
            System.out.println("Invalid input! Fewer than 7 numbers" +
                    " are provided. Please try again!");
            return createNumber(keyboard);
        }
        if(numbers.length > 7){
            System.out.println("Invalid input! More than 7 numbers" +
                    " are provided. Please try again!");
            return createNumber(keyboard);
        }

        /**
         * array Arrays.sort();
         * 1 2 3 3 4 5 6
         * for loop
         * number[i].equals(number[i - 1])
         */

        /**
         * int[] length = 7;
         * sorts int array
         * for loop
         * number[i] == number[i - 1]
         */

        Set<Integer> mySet = new HashSet<>();
        int[] result = new int[7];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = Integer.parseInt(numbers[i]);
            mySet.add(result[i]);
        }

        if(mySet.size() == 7){
            Arrays.sort(result); //???
            return result;
        }else{
            System.out.println("Invalid input! All numbers must be different!");
            return createNumber(keyboard);
        }

    }

    public String showIDAndNumber(){
        String result = "Entry ID: ";
        result += String.format("%-7d", entryId);
        result += "Numbers:";
        for(int i : numbers){
            result += String.format("%3d", i);
        }
        return result;
    }

    public String showAllInformation(){
        String result = "Member ID: ";
        result += memberID;
        result += ", Entry ID: ";
        result += String.format("%-2d", entryId);
        result += "    , Prize: ";
        result += String.format("%-5d", price);
        result += ", Numbers:";
        for(int i : numbers){
            result += String.format("%3d", i);
        }
        return result;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getEntryId() {
        return entryId;
    }

    public String getMemberID(){
        return this.memberID;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public int[] getNumbers(){
        return numbers;
    }
}
