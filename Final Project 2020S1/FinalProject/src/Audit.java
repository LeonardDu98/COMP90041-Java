/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import ethicalengine.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author leonard
 */
public class Audit {
    private String auditType;
    private ArrayList<ethicalengine.Character> allCharacters = null;
    private ArrayList<ethicalengine.Character> allSurvival = null;
    private ArrayList<Scenario> scenarios = null;
    private int runtimes;
    private ScenarioGenerator sg = new ScenarioGenerator(100);
    
    private int redCount;
    private int greenCount;
    
    
    public Audit(){
        auditType = "Unspecified";
        allCharacters = new ArrayList<ethicalengine.Character>();
        allSurvival = new ArrayList<ethicalengine.Character>();
        runtimes = 0;
    }
    
    public Audit(Scenario[] scenarios){
        this.scenarios = new ArrayList<>(Arrays.asList(scenarios));
        auditType = "Unspecified";
        runtimes = 0;
    }
    
    public void setAuditType(String name){
        this.auditType = name;
    }
    
    public String getAuditType(){
        return auditType;
    }
    
    public void run(){
        for(int i = 0; i < scenarios.size(); i++){
            Scenario test = scenarios.get(i);
            if(test.isLegalCrossing() == true){
                greenCount++;
            }else{
                redCount++;
            }
            for(int j = 0; j < test.getPassengerCount(); j++){
                allCharacters.add(test.getPassengers()[j]);
            }
            for(int j = 0; j < test.getPedestrianCount(); j++){
                allCharacters.add(test.getPedestrians()[j]);
            }
            if(EthicalEngine.decide(test) == EthicalEngine.Decision.PASSENGERS){
                for(int j = 0; j < test.getPassengerCount(); j++){
                    allSurvival.add(test.getPassengers()[j]);
                }
            }else{
                for(int j = 0; j < test.getPedestrianCount(); j++){
                    allSurvival.add(test.getPedestrians()[j]);
                }
            }
        }
        runtimes += scenarios.size();
    }
    
    public void run(int runs){
        for(int i = 0; i < runs; i++){
            Scenario test = sg.generate();
            if(test.isLegalCrossing() == true){
                greenCount++;
            }else{
                redCount++;
            }
            for(int j = 0; j < test.getPassengerCount(); j++){
                allCharacters.add(test.getPassengers()[j]);
            }
            for(int j = 0; j < test.getPedestrianCount(); j++){
                allCharacters.add(test.getPedestrians()[j]);
            }
            if(EthicalEngine.decide(test) == EthicalEngine.Decision.PASSENGERS){
                for(int j = 0; j < test.getPassengerCount(); j++){
                    allSurvival.add(test.getPassengers()[j]);
                }
            }else{
                for(int j = 0; j < test.getPedestrianCount(); j++){
                    allSurvival.add(test.getPedestrians()[j]);
                }
            }
        }
        runtimes += runs;
    }
    
    private void statisticSup(HashMap<String, Integer> map, String string){
        if(map.get(string) != null){
            int newValue = map.get(string) + 1;
            map.put(string, newValue);
        }else{
            map.put(string, 1);
        }
    }
    
    private void statisticSup(HashMap<String, Integer> map, String string, boolean bool){
        if(bool = true){
            statisticSup(map, string);
        }
    }
    
    private int statisticSup(ArrayList list, HashMap<String, Integer> survivalCount, int ageSum){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof Person){
                Person temp = new Person((Person)list.get(i));
                
                String ageCategory = temp.getAgeCategory().toString().toLowerCase();
                statisticSup(survivalCount, ageCategory);
                
                String gender = temp.getGender().toString().toLowerCase();
                statisticSup(survivalCount, gender);
                
                String bodyType = temp.getBodyType().toString().toLowerCase();
                statisticSup(survivalCount, bodyType);
                
                String profession = temp.getProfession().toString().toLowerCase();
                statisticSup(survivalCount, profession);
                
                String classType = "person";
                statisticSup(survivalCount, classType);
                
                statisticSup(survivalCount, "pregnant", temp.isPregnant());
               
                statisticSup(survivalCount, "you", temp.isYou());
                
                ageSum += temp.getAge();
            }else{
                Animal temp = new Animal((Animal)list.get(i));
                
                String species = temp.getSpecies().toLowerCase();
                statisticSup(survivalCount, species);
            }
        }
        return ageSum;
    }
    
    @Override
    public String toString(){
        if(runtimes == 0){
            return "no audit available";
        }
        
        int ageSum = 0;
        HashMap<String, Integer> characterCount = new HashMap();
        HashMap<String, Integer> survivalCount = new HashMap();
        HashMap<String, Double> statistic = new HashMap();
        String result = "======================================\n";
        result += "# " + auditType + " Audit\n";
        result += "======================================\n";
        result += "- % SAVED AFTER " + runtimes + " RUNS\n";
        
        ageSum = statisticSup(allSurvival, survivalCount, ageSum);
        statisticSup(allCharacters, characterCount, 0);
        
        for(String i : survivalCount.keySet()){
            int survival = survivalCount.get(i);
            int character = characterCount.get(i);
            double precentage = (double)survival / character;
            statistic.put(i, precentage);
        }
        
        List<HashMap.Entry<String,Double>> list = new ArrayList<>(statistic.entrySet());
        Collections.sort(list,new Comparator<HashMap.Entry<String, Double>>() {
            public int compare(Entry<String, Double> o1,
                    Entry<String, Double> o2) {
                return o2.getValue() - (o1.getValue()) > 0 ? 1 : -1;
            }
        });
        
        DecimalFormat df = new DecimalFormat("0.0#");
        
        for(HashMap.Entry<String,Double> mapping:list){ 
               result += mapping.getKey() + ": " +  df.format(mapping.getValue()) + "\n"; 
        }
        
        
        result += "--\n" + "average age: " + String.format("%.1f", (double)ageSum / survivalCount.get("person")) + "\n";
        /*
        for(HashMap.Entry<String,Double> mapping:list){ 
               result += mapping.getKey() + ": " +  String.format("%.2f", mapping.getValue()) + "\n"; 
        }
        */
        return result;
    }
    
    public void printStatistic(){
        System.out.print(toString());
    }
    
    public void printToFile(String filepath){
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter(filepath, true));
            out.write(toString());
            out.close();
        }catch (IOException e){
            System.out.println("ERROR: could not print results. Target directory does not exist.");
        }
    }
    
}
