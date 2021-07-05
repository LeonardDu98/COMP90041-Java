package JavaS12021A1;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SimpleCompetitions {
    private String type;
    private Competition activeCompetition;
    private ArrayList<Competition> myCompetition = new ArrayList<>();

    public Competition addNewCompetition(Scanner keyboard) {
        Competition newCompetition = new Competition(keyboard);
        return newCompetition;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        SimpleCompetitions sc = new SimpleCompetitions();
        sc.welcome();
        sc.askType(keyboard);
        sc.selectOption(keyboard);

        //keyboard.close();
    }

    public void welcome(){
        System.out.println("----WELCOME TO SIMPLE COMPETITIONS APP----");
    }

    public void askType(Scanner keyboard){
        System.out.println("Which mode would you like to run? (Type" +
                " T for Testing, and N for Normal mode):");
        String typeInput = keyboard.nextLine().toUpperCase();
        if(typeInput.equals("T") || typeInput.equals("N")){
            this.type = typeInput;
        }else{
            System.out.println("Invalid mode! Please choose again.");
            askType(keyboard);
        }
    }

    private void showOptions(){
        System.out.println("Please select an option. Type 5 to exit.\n" +
                "1. Create a new competition\n" +
                "2. Add new entries\n" +
                "3. Draw winners\n" +
                "4. Get a summary report\n" +
                "5. Exit");
    }

    public void selectOption(Scanner keyboard){
        showOptions();
        String optionNumber = keyboard.nextLine();
        switch (optionNumber){
            case "1":
                if(checkActive()){
                    System.out.println("There is an active competition. SimpleCompetitions" +
                            "does not support concurrent competitions!");
                }else{
                    this.activeCompetition = addNewCompetition(keyboard);
                    myCompetition.add(activeCompetition);
                    System.out.println(activeCompetition.displayIDAndName());
                }
                break;
            case "2":
                if(checkActive()){
                    askBillInformation(keyboard);
                }else{
                    System.out.println("There is no active competition. Please create one!");
                }
                break;
            case "3":
                if(checkActive()){
                    showWinner();
                }else{
                    System.out.println("There is no active competition. Please create one!");
                }
                break;
            case "4":
                report();
                break;
            case "5":
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
        }
        selectOption(keyboard);
    }

    private boolean checkActive(){
        return this.activeCompetition != null && this.activeCompetition.isActive();
    }

    private void askBillInformation(Scanner keyboard){
        String memberID = askID(keyboard, "Member");
        String billID = askID(keyboard, "Bill");
        System.out.println("Total amount: ");
        double amount = Double.parseDouble(keyboard.nextLine());
        int entry = (int) (amount / 50);
        System.out.println("This bill is eligible for " + entry +
                " entries. How many manual entries did the customer fill up?: ");

        int manual = keyboard.nextInt();
        keyboard.nextLine();

        for(int i = 0; i < entry; i++){
            Entry myEntry = null;
            if(i < manual){
                myEntry = new Entry(keyboard, memberID);
            }else{
                myEntry = new AutoEntry(memberID, getType());
            }
            activeCompetition.addEntries(myEntry);
        }

        System.out.println("The following entries have been added:");
        activeCompetition.showNewEntries(entry);
        System.out.println("Add more entries (Y/N)?");
        if(keyboard.nextLine().equals("Y")){
            askBillInformation(keyboard);
        }

    }

    private String askID(Scanner keyboard, String myString){
        System.out.println(myString + " ID: ");
        String idInput = keyboard.nextLine();
        if(isValid(idInput)){
            return idInput;
        }else{
            System.out.println("Invalid " + myString.toLowerCase() +
                    " id! It must be a 6-digit number. Please try again.");
            return askID(keyboard, myString);
        }
    }

    private boolean isValid(String idInput){
        //String isDigit Character //google
        try{
            Integer.parseInt(idInput);//abc
        }catch (NumberFormatException e){
            return false;
        }

//        boolean isNumeric = idInput.chars().allMatch( Character::isDigit );
//        boolean isNumeric = idInput.matches("[0-9]");//正则


        return idInput.length() == 6;
    }

    private void showWinner(){
        if(activeCompetition.getEntriesNumber() == 0){
            System.out.println("The current competition has no entries yet!");
            return;
        }
        System.out.println("Lucky entry for " + activeCompetition.displayIDAndName());
        int[] luckyNumber;
        if(type.equals("T")){
            luckyNumber = AutoEntry.createNumbers(activeCompetition.getId());
        }else{
            luckyNumber = AutoEntry.createNumbers();
        }

        String luckyNumberString = "Numbers:";
        for(int i :luckyNumber){
            luckyNumberString += String.format("%3d", i);
        }
        luckyNumberString += " [Auto]";
        System.out.println(luckyNumberString);
        activeCompetition.drawWinners(luckyNumber);
    }

    public void report() {
        if(myCompetition.size() == 0){
            System.out.println("No competition has been created yet!");
            return;
        }
        System.out.println("----SUMMARY REPORT----");
        int completed = 0;
        int active = 0;
        if(myCompetition.get(myCompetition.size() - 1).isActive()){
            active = 1;
            completed = myCompetition.size() - 1;
        }else{
            completed = myCompetition.size();
            active = 0;
        }
        System.out.println("+Number of completed competitions: " + completed);
        System.out.println("+Number of active competitions: " + active);

        for(Competition i : myCompetition){
            i.report();
        }
    }

    public String getType(){
        return this.type;
    }
}