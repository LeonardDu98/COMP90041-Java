/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ethicalengine.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author leonard
 */
public class EthicalEngine {
    public enum Decision{PEDESTRIANS, PASSENGERS};//save
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Decision.values();
        
        /*
        Person person1 = new Person(23, Person.Profession.STUDENT, ethicalengine.Character.Gender.MALE,
                ethicalengine.Character.BodyType.AVERAGE, false);
        Person person2 = new Person(6, Person.Profession.NONE, ethicalengine.Character.Gender.FEMALE,
                ethicalengine.Character.BodyType.AVERAGE, false);
        Animal dog = new Animal("puppy");
        ethicalengine.Character cat = new Animal("kitty");
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(dog.toString());
        System.out.println(cat.toString());
        
        Person[] passengers = {person1};
        ethicalengine.Character[] pedestrians  = {person2, cat, dog};
        
        Audit au = new Audit();
        au.run(10);
        au.run(10);
        au.run(10);
        au.printStatistic();
        au.printToFile("out.txt");
        
        ScenarioGenerator sg = new ScenarioGenerator(4);
        Scenario sc = sg.generate();
        sc.toString();

        System.out.println(decide(sc));
        */
        
        boolean logFlag;
        try{
            FileInputStream inputstream = new FileInputStream("welcome.ascii");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream));
            String str;
            while((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
            inputstream.close();
            bufferedReader.close();
            
            System.out.println("Do you consent to have your decisions saved to a file? (yes/no)");
            while(true){
                String askLog = sc.nextLine();
                if(askLog.equals("yes")){
                    logFlag = true;
                    break;
                }else if(askLog.equals("no")){
                    logFlag= false;
                    break;
                }else{
                    System.out.println("Invalid response. Do you consent to have your decisions saved to a file? (yes/no)");
                }
            }
            
            
        }catch(FileNotFoundException e){
            System.out.println("ERROR: could not find config file.");
        }catch(IOException e){
            System.out.println("IO Error");
        }
        
        
        
        
        EthicalEngine ee = new EthicalEngine();
        
        
        
        while(true){
            System.out.println("");
            System.out.print("$ ");
            String commond = sc.nextLine();
            String[] subCommonds = commond.split(" ");
            if(subCommonds[0].equals("java") && subCommonds[1].equals("EthicalEngine")){
                if(subCommonds.length == 2){
                    
                }else if(subCommonds[2].equals("-i") || subCommonds[2].equals("--interactive")){
                    if(subCommonds.length == 3){
                        ee.interactive();
                    }else{
                        ee.interactive(subCommonds[4]);
                    }
                }else if(subCommonds[2].equals("--config") || subCommonds[2].equals("-c")){
                    if(subCommonds.length == 3){
                        ee.help();
                    }else{
                        ArrayList<Scenario> sc = ee.readData(subCommonds[3]);
                    }
                    //System.out.println(sc.get(0).toString());
                }else if(subCommonds[2].equals("--help") || subCommonds[2].equals("-h")){
                    ee.help();
                    //System.out.println(sc.get(0).toString());
                }
            }
        }


        
    }
    
    public ArrayList<Scenario> readData(String filePath){
        int lineCount = 0;
        int scenarioCount = 0;
        try{
            FileInputStream inputstream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream));
            String str;
            ArrayList<Scenario> readFile = new ArrayList<>();
            bufferedReader.readLine();
            while((str = bufferedReader.readLine()) != null){
                
                String[] data = str.split(",");
                for(int i = 0; i < data.length; i++){
                    System.out.println(data[i]);
                }
                System.out.println("=============");
                String[] scenarioStart = data[0].split(":");
                if(scenarioStart[0].equals("scenario")){
                    readFile.add(new Scenario());
                    scenarioCount++;
                    if(scenarioStart[1].equals("green")){
                        readFile.get(scenarioCount - 1).setIsLegalCrossing(true);
                    }
                    continue;
                }
                
                try{
                    if(data.length != 10){
                        throw new InvalidDataFormatException();
                    }
                }catch(InvalidDataFormatException e){
                    System.out.println("WARNING: invalid data format in config file in line " + lineCount);
                    continue;
                }
                
                
                try{
                    ethicalengine.Character.Gender gender = ethicalengine.Character.Gender.valueOf(data[1].toUpperCase());
                    int age = Integer.parseInt(data[2]);

                    if(data[0].equals("person")){
                        Person.BodyType bodyType = Person.BodyType.valueOf(data[3].toUpperCase());
                        Person.Profession profession = Person.Profession.NONE;
                        if(!data[4].equals("")){
                            profession = Person.Profession.valueOf(data[4].toUpperCase());
                        }
                        boolean isPregnant = data[5].toLowerCase().equals("true");
                        Person temp = new Person(age, profession, gender, bodyType, isPregnant);
                        if(data[6].toLowerCase().equals("true")){
                            temp.setAsYou(true);
                        }
                        if(data[9].equals("passenger")){
                            readFile.get(scenarioCount - 1).addPassengers(temp);
                        }else{
                            readFile.get(scenarioCount - 1).addPedestrian(temp);
                        }
                        continue;
                    }

                    if(data[0].equals("animal")){
                        String species = data[7];
                        Animal temp;
                        if(data[8].toLowerCase().equals("true")){
                            temp = new Animal(age, gender, species, true);
                        }else{
                            temp = new Animal(age, gender, species, false);
                        }

                        if(data[9].equals("passenger")){
                            readFile.get(scenarioCount - 1).addPassengers(temp);
                        }else{
                            readFile.get(scenarioCount - 1).addPedestrian(temp);
                        }
                    }
                }catch (NumberFormatException e) {
                    System.out.println("WARNING: invalid number format in config file in line " + lineCount);                    
                }
                lineCount++;
            }
            inputstream.close();
            bufferedReader.close();
            return readFile;
        }catch(FileNotFoundException e){
            System.out.println("ERROR: could not find config file.");
            System.exit(0);
        }catch(IOException e){
            System.out.println("IO Error");
        }
        return null;
    }
    
    public void help(){
        System.out.println("EthicalEngine - COMP90041 - Final Project\n" +
                            "\n" +
                            "Usage: java EthicalEngine [arguments]\n" +
                            "\n" +
                            "Arguments:\n" +
                            "-c or --config      Optional: path to config file\n" +
                            "-h or --help        Print Help (this message) and exit\n" +
                            "-r or --results     Optional: path to results log file\n" + 
                            "-i or --interactive Optional: launches interactive mode\n");
    }
    
    public void interactive(){
        boolean logFlag = welcome();
    }
    
    public void interactive(String filePath){
        boolean logFlag = welcome();
    }
    
    public boolean welcome(){
        boolean logFlag = false;
        try{
            FileInputStream inputstream = new FileInputStream("welcome.ascii");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream));
            String str;
            while((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
            inputstream.close();
            bufferedReader.close();
            
            System.out.println("Do you consent to have your decisions saved to a file? (yes/no)");
            while(true){
                String askLog = sc.nextLine();
                if(askLog.equals("yes")){
                    logFlag = true;
                    break;
                }else if(askLog.equals("no")){
                    logFlag= false;
                    break;
                }else{
                    System.out.println("Invalid response. Do you consent to have your decisions saved to a file? (yes/no)");
                }
            }  
        }catch(FileNotFoundException e){
            System.out.println("ERROR: could not find config file.");
        }catch(IOException e){
            System.out.println("IO Error");
        }
        return logFlag;
    }
    
    public static Decision decide(Scenario scenario){
        if(scenario.isLegalCrossing() == false){//illegal = die
            return Decision.PASSENGERS;
        }
        
        if(scenario.getPassengerCount() > scenario.getPedestrianCount()){
            return Decision.PASSENGERS;
        }
        
        if(scenario.getPassengerCount() == scenario.getPedestrianCount()){
            if(scenario.hasYouInCar()){
                return Decision.PASSENGERS;
            }
            if(scenario.hasYouInLane()){
                return Decision.PEDESTRIANS;
            }
        }
        return Decision.PEDESTRIANS;
    }
}


class InvalidDataFormatException extends Exception{
    public InvalidDataFormatException(){
        super();
    }
}