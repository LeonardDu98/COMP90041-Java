package JavaS12021A1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Competition {
    private String name; //competition name
    private int id; //competition identifier

    private static int nextCompetition = 1;
    private ArrayList<Entry> entries = new ArrayList<>();
    private ArrayList<Entry> winEntries = new ArrayList<>();

    private String active = "yes";
    private int sumPrice = 0;

    public Competition(){

    }

    public Competition(Scanner keyboard){
        System.out.println("Competition name: ");
        this.name = keyboard.nextLine();
        System.out.println("A new competition has been created!");
        this.id = nextCompetition;
        nextCompetition++;
    }

    public String displayIDAndName(){
        return "Competition ID: " + this.id + ", Competition Name: " + this.name;
    }

    public void addEntries(Entry oneEntry) {
        entries.add(oneEntry);
    }

    public void showNewEntries(int newEntries){
        for(int i = entries.size() - newEntries; i < entries.size(); i++){
            System.out.println(entries.get(i).showIDAndNumber());
        }
    }

    public void drawWinners(int[] luckyNumber) {
        int maxPrice = 0;
        Entry maxPriceEntry = null;
        String currentID = "";

        for(int i = 0; i < entries.size(); i++){
            if(currentID.equals(entries.get(i).getMemberID())){
                //same member
                entries.get(i).setPrice(decideWinPrice(luckyNumber, entries.get(i).getNumbers()));
                if(entries.get(i).getPrice() > maxPrice){
                    maxPrice = entries.get(i).getPrice();
                    maxPriceEntry = entries.get(i);
                }
            }else{
                if(i != 0 && maxPriceEntry != null){
                    winEntries.add(maxPriceEntry);
                }
                currentID = entries.get(i).getMemberID();
                entries.get(i).setPrice(decideWinPrice(luckyNumber, entries.get(i).getNumbers()));
                maxPrice = entries.get(i).getPrice();
                if(maxPrice > 0){
                    maxPriceEntry = entries.get(i);
                }else{
                    maxPriceEntry = null;
                }
            }

            if(i == entries.size() - 1){
                if(maxPriceEntry != null){
                    winEntries.add(maxPriceEntry);
                }
            }
        }

        System.out.println("Winning entries:");
        for(Entry i : winEntries){
            System.out.println(i.showAllInformation());
            sumPrice += i.getPrice();
        }

        this.active = "no";
    }

    public void report() {
        String result = "\nCompetition ID: ";
        result += this.id;
        result += ", name: ";
        result += this.name;
        result += ", active: ";
        result += this.active + "\n";
        result += "Number of entries: ";
        result += this.entries.size() + "\n";
        if(this.active.equals("no")){
            result += "Number of winning entries: ";
            result += this.winEntries.size() + "\n";
            result += "Total awarded prizes: " + sumPrice + "\n";
        }
        System.out.print(result);
    }

    public int getEntriesNumber(){
        return entries.size();
    }

    public int getId(){
        return this.id;
    }

    public int decideWinPrice(int[] luckyNumber, int[] entryNumber){
        int sameNumber = 0;
        for(int i: entryNumber){
            for(int j: luckyNumber){
                if(i == j){
                    sameNumber++;
                }
            }
        }
        switch (sameNumber){
            case 2:
                return 50;
            case 3:
                return 100;
            case 4:
                return 500;
            case 5:
                return 1000;
            case 6:
                return 5000;
            case 7:
                return 50000;
            default:
                return 0;
        }
    }

    public boolean isActive(){
        return this.active.equals("yes");
    }
}
