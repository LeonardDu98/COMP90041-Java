
import ethicalengine.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leonard
 */
public class Audit {
    private String name;
    private ArrayList<ethicalengine.Character> allCharacters;
    private ArrayList<ethicalengine.Character> allSurvival;
    private int runtimes;
    
    
    public Audit(){
        name = "Unspecified";
        allCharacters = new ArrayList<ethicalengine.Character>();
        allSurvival = new ArrayList<ethicalengine.Character>();
        runtimes = 0;
    }
    
    public void run(int runs){
        ScenarioGenerator sg = new ScenarioGenerator(100);//seed = 100
        for(int i = 0; i < runs; i++){
            Scenario s = sg.generate();
            
            for(int j = 0; j < s.getPassengerCount(); j++){
                allCharacters.add(s.getPassengers()[j]);
            }
            for(int j = 0; j < s.getPedestrianCount(); j++){
                allCharacters.add(s.getPedestrians()[j]);
            }
            
            if(EthicalEngine.decide(s) == EthicalEngine.Decision.PASSENGERS){
                for(int j = 0; j < s.getPassengerCount(); j++){
                    allSurvival.add(s.getPassengers()[j]);
                }
            }else{
                for(int j = 0; j < s.getPedestrianCount(); j++){
                    allSurvival.add(s.getPedestrians()[j]);
                }
            }
        }
        runtimes += runs;
    }
    
    public void setAuditType(String name){
        this.name = name;
    }
    
    public String getAuditType(){
        return this.name;
    }
    
    public String toString(){
        if(runtimes == 0){
            return "no audit available";
        }
        
        HashMap<String, Integer> characterCount = new HashMap();
        statisticSup(characterCount, allCharacters);
        
        HashMap<String, Integer> survivalCount = new HashMap();
        int survivalAgeSum = statisticSup(survivalCount, allSurvival);
        
        HashMap<String, Double> statistic = new HashMap();
        for(String i : survivalCount.keySet()){
            int survival = survivalCount.get(i);
            int character = characterCount.get(i);
            double precentage = (double)survival / character;
            statistic.put(i, precentage);
        }
        
        ArrayList<HashMap.Entry<String,Double>> list = new ArrayList<>(statistic.entrySet());
        
        Collections.sort(list,new Comparator<HashMap.Entry<String, Double>>() {
            public int compare(Entry<String, Double> o1,
                    Entry<String, Double> o2) {
                return o2.getValue() - (o1.getValue()) > 0 ? 1 : -1;
            }
        });
        
        String result = "======================================\n";
        result += "# " + name + " Audit\n";
        result += "======================================\n";
        result += "- % SAVED AFTER " + runtimes + " RUNS\n";
        
        DecimalFormat df = new DecimalFormat("0.0#");
        for(HashMap.Entry<String,Double> mapping: list){ 
               result += mapping.getKey() + ": " +  df.format(mapping.getValue()) + "\n"; 
        }
        result += "--\n" + "average age: " + String.format("%.1f", (double)survivalAgeSum / survivalCount.get("person"));
        
        return result;
    }
    
    private int statisticSup(HashMap<String, Integer> map, ArrayList<ethicalengine.Character> list){
        int ageSum = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof Person){
                Person temp = new Person((Person)list.get(i));
                
                String ageCategory = temp.getAgeCategory().toString().toLowerCase();
                statisticSup(ageCategory, map);
                
                String gender = temp.getGender().toString().toLowerCase();
                statisticSup(gender, map);
                
                String bodyType = temp.getBodyType().toString().toLowerCase();
                statisticSup(bodyType, map);
                
                String profession = temp.getProfession().toString().toLowerCase();
                statisticSup(profession, map);
                
                statisticSup("person", map);
                statisticSup("pregnant", map, temp.isPregnant());
                statisticSup("you", map, temp.isYou());
                
                ageSum += temp.getAge();
            }else{
                Animal temp = new Animal((Animal)list.get(i));
                
                String species = temp.getSpecies().toLowerCase();
                statisticSup(species, map);
            }
        }
        return ageSum;
    }
    
    //1. newValue == 1 2.newValue == oldValue + 1;
    private void statisticSup(String string, HashMap<String, Integer> map){
        if(map.get(string) != null){
            int newValue = map.get(string) + 1;
            map.put(string, newValue);
        }else{
            map.put(string, 1);
        }
    }
    
    private void statisticSup(String string, HashMap<String, Integer> map, boolean bool){//isYou//isPergnant
        if(bool){
            statisticSup(string, map);
        }
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