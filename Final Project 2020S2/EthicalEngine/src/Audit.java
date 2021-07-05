import ethicalengine.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represent Audit.
 */
public class Audit {

    private String auditType;
    private ArrayList<Data> allDatas;
    private int runNum;
    private ScenarioGenerator sg = new ScenarioGenerator(100);//seed = 100
    private Scenario[] scenarios;

    private int ageforSur = 0;

    /**
     * default constructor
     */
    public Audit() {
        allDatas = new ArrayList<>();
        runNum = 0;
        auditType = "Unspecified";
    }

    /**
     * constructor
     * @param scenarios
     */
    public Audit(Scenario[] scenarios) {
        this.scenarios = scenarios;
        allDatas = new ArrayList<>();
        runNum = 0;
        auditType = "Unspecified";
    }

    /**
     * decide save passenger or pedestrians
     * @param i one scenario
     * @param isInteract decide whether interact with user or not
     * @return decide whether save passenger or pedestrians
     */
    private EthicalEngine.Decision getDecide(Scenario i, boolean isInteract) {
        if (isInteract) {
            System.out.println(i.toString());
            System.out.println("Who should be saved? (passenger(s) [1] or pedestrian(s) [2])");
            String decide = EthicalEngine.sc.nextLine();
            if (decide.equals("passenger") || decide.equals("passengers") || decide.equals("1")) {
                return EthicalEngine.Decision.PASSENGERS;
            } else {
                return EthicalEngine.Decision.PEDESTRIANS;
            }
        } else {
            return EthicalEngine.decide(i);
        }
    }

    /**
     * count Human information
     * @param human human's information
     * @param isSur whether live or not
     */
    private void countHuman(Human human, boolean isSur) {
        countData("human", isSur);
        countData(human.getAgeCategory().toString(), isSur);
        countData(human.getProfession().toString(), isSur);
        countData(human.getBodyType().toString(), isSur);
        countData(human.getGender().toString(), isSur);

        if (isSur) {
            ageforSur += human.getAge();
        }

        if (human.isPregnant()) {
            countData("pregnant", isSur);
        }

        if (human.isYou()) {
            countData("you", isSur);
        }
    }

    /**
     * count Animal information
     * @param animal Animal information
     * @param isSur whether live or not
     */
    private void countAnimal(Animal animal, boolean isSur) {
        countData("animal", isSur);
        countData(animal.getSpecies(), isSur);
        if (animal.isPet()) {
            countData("pet", isSur);
        }
    }

    /**
     * put data in arraylist
     * @param string
     * @param isSur whether live or not
     */
    private void countData(String string, boolean isSur) {
        string = string.toLowerCase();
        boolean inArray = false;
        for (int i = 0; i < allDatas.size(); i++) {
            if (allDatas.get(i).getString().equals(string)) {
                inArray = true;
                int oldNum = allDatas.get(i).getCountAll();
                allDatas.get(i).setCountAll(oldNum + 1);
                if (isSur) {
                    int oldSur = allDatas.get(i).getCountSur();
                    allDatas.get(i).setCountSur(oldSur + 1);
                }
            }
        }
        if (!inArray) {
            if (isSur) {
                allDatas.add(new Data(string, 1, 1));
            } else {
                allDatas.add(new Data(string, 1));
            }
        }
    }

    /**
     * count Scenario information
     * @param scenario Scenarios
     * @param decision decide tp save passengers or pedestrians
     */
    private void countScenario(Scenario scenario, EthicalEngine.Decision decision) {
        String signalColor;

        if (scenario.isLegalCrossing()) {
            signalColor = "green";
        } else {
            signalColor = "red";
        }

        boolean savePassenger;
        savePassenger = decision == EthicalEngine.Decision.PASSENGERS;

        for (Persona j : scenario.getPassengers()) {
            countData(signalColor, savePassenger);
            countData("passengers", savePassenger);
            if (j instanceof Human) {
                countHuman((Human) j, savePassenger);
            } else {
                countAnimal((Animal) j, savePassenger);
            }
        }

        for (Persona j : scenario.getPedestrians()) {
            countData(signalColor, !savePassenger);
            countData("pedestrians", !savePassenger);
            if (j instanceof Human) {
                countHuman((Human) j, !savePassenger);
            } else {
                countAnimal((Animal) j, !savePassenger);
            }
        }
    }

    /**
     * run Scenarios
     */
    public void run() {
        for (int i = 0; i < scenarios.length; i++) {
            EthicalEngine.Decision decision = getDecide(scenarios[i], false);
            countScenario(scenarios[i], decision);
            runNum++;
        }
    }

    /**
     * run three Scenarios to users
     */
    public void runInteract() {
        int start = runNum;
        int i;
        for (i = start; i < Math.min(start + 3, scenarios.length); i++) {
            EthicalEngine.Decision decision = getDecide(scenarios[i], true);
            countScenario(scenarios[i], decision);
            runNum++;
        }
    }

    /**
     * judge whether the last Scenarios
     * @return
     */
    public boolean stillHave(){
        return runNum < scenarios.length;
    }

    /**
     * run random Scenario
     * @param runs
     */
    public void run(int runs) {
        for (int i = 0; i < runs; i++) {
            Scenario randomScenario = sg.generate();
            EthicalEngine.Decision decision = getDecide(randomScenario, false);
            countScenario(randomScenario, decision);
            runNum++;
        }
    }

    /**
     * run the random Scenario to user
     * @param runs
     */
    public void runInteract(int runs) {
        for (int i = 0; i < runs; i++) {
            Scenario randomScenario = sg.generate();
            EthicalEngine.Decision decision = getDecide(randomScenario, true);
            countScenario(randomScenario, decision);
            runNum++;
        }
    }

    /**
     * set the name of the audit type.
     * @param auditType
     */
    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    /**
     * returns the name of the audit
     * @return Audit type
     */
    public String getAuditType() {
        return auditType;
    }

    @Override
    /**
     * returns a summary of the simulation in the format depicted below(statistic result)
     */
    public String toString() {
        if (runNum == 0) {                //If no simulation has been run
            return "no audit available";
        }

        for (int i = 0; i < allDatas.size() - 1; i++) {
            for (int j = i + 1; j < allDatas.size(); j++) {
                if (allDatas.get(j).Compare(allDatas.get(i))) {
                    Data temp = new Data(allDatas.get(j));
                    allDatas.set(j, allDatas.get(i));
                    allDatas.set(i, temp);
                }
            }
        }

        String result = "======================================\n";
        result = result + "# " + auditType + " Audit\n";
        result = result + "======================================\n";
        result = result + "- % SAVED AFTER " + runNum + " RUNS\n";

        for (Data i : allDatas) {
            if (i.getString().equals("none")
                    || i.getString().equals("unspecified")
                    || i.getString().equals("unknown")) {

                continue;
            }
            result += i.toString();
        }

        int allSurNum = 0;
        for (Data i : allDatas) {
            if (i.getString().equals("human")) {
                allSurNum = i.getCountSur();
            }
        }

        double average = (double) ageforSur / allSurNum;
        average = Math.ceil(average * 100) / 100;
        result += "--\n" + "average age: " + String.format("%.2f", average);

        return result;
    }

    /**
     * prints the summary returned by the toString() method to the command-line.
     */
    public void printStatistic() {
        System.out.println(toString());
    }

    /**
     * To save the results of your audit to a file
     * @param filepath
     */
    public void printToFile(String filepath) {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(filepath, true));
            output.write(toString());
            output.close();
        } catch (IOException e) {
            System.out.println("ERROR: could not print results. Target directory does not exist.");
        }
    }
}
