
import ethicalengine.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represent EthicalEngine.
 *
 */
public class EthicalEngine {

    public enum Decision {
        PEDESTRIANS, PASSENGERS
    };
    public static Scanner sc = new Scanner(System.in);
    private static Audit user;
    private static ArrayList<Scenario> scenarios = new ArrayList<>();
    private static String resultFile = "results.log";

    public static void main(String[] args) {
        EthicalEngine ethicalengine = new EthicalEngine();
        String fileName = "";
        int _i = -1;
        int _h = -1;
        int _c = -1;
        int _r = -1;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-i")) {
                _i = i;
            }
            if (args[i].equals("-h")) {
                _h = i;
            }
            if (args[i].equals("-c")) {
                _c = i;
            }
            if (args[i].equals("-r")) {
                _r = i;
            }
        }

        if (_c != -1) {
            if (args.length > _c + 1) {
                fileName = args[_c + 1];
                ethicalengine.readData(fileName);
            } else {
                _h = -2;
            }
        }

        if (_r != -1) {
            if (args.length > _r + 1) {
                resultFile = args[_r + 1];
            } else {
                _h = -2;
            }
        }

        if (_h != -1) {
            ethicalengine.help();
            return;
        }

        if (_i != -1) {
            ethicalengine.welcome();
            boolean recordFlag = false;

            while (true) {
                System.out.println("Do you consent to have your decisions saved to a file? (yes/no)");
                String askLog = sc.nextLine();
                if (askLog.equals("yes")) {
                    recordFlag = true;
                    break;
                } else if (askLog.equals("no")) {
                    recordFlag = false;
                    break;
                } else {
                    System.out.print("Invalid response. ");
                }
            }

            if (_c == -1) {
                ethicalengine.interactive();
            } else {
                ethicalengine.interactiveFile();
            }
            if (recordFlag == true) {
                user.printToFile(resultFile);
            }
        } else {
            if (_c == -1) {
                Audit audit = new Audit();
                audit.run(100);
                audit.printToFile(resultFile);
            } else {
                Audit audit = new Audit(scenarios.toArray(new Scenario[scenarios.size()]));
                audit.run();
                audit.printToFile(resultFile);
            }
        }
    }

    /**
     * use interactive file's data ask users' decision
     */
    public void interactiveFile() {
        user = new Audit(scenarios.toArray(new Scenario[scenarios.size()]));
        user.setAuditType("User");
        boolean stillPlay = true;
        while (stillPlay) {
            user.runInteract();
            user.printStatistic();
            if (!user.stillHave()) {
                break;
            }
            System.out.println("Would you like to continue? (yes/no)");
            stillPlay = sc.nextLine().equals("yes");
        }
        System.out.println("That's all. Press Enter to quit.");
    }

    /**
     * ask users' decision with randoms Scenarios
     */
    public void interactive() {
        user = new Audit();
        user.setAuditType("User");
        boolean stillPlay = true;
        while (stillPlay) {
            user.runInteract(3);
            user.printStatistic();
            System.out.println("Would you like to continue? (yes/no)");
            stillPlay = sc.nextLine().equals("yes");
        }
        System.out.println("That's all. Press Enter to quit.");
    }

    /**
     * output welcome page
     */
    public void welcome() {
        try {
            //open file
            File file = new File("welcome.ascii");
            //InputStreamReader<-FileInputStream<-file
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader is = new InputStreamReader(fis);
            //use method(readLine()) of BufferedReader(<-InputStreamReader) to read
            BufferedReader br = new BufferedReader(is);
            //output
            String txtLine = null;
            while ((txtLine = br.readLine()) != null) {
                System.out.println(txtLine);
            }
            br.close();
        } catch (IOException e) {
        }
    }

    /**
     * read data from files
     *
     * @param fileName
     */
    public void readData(String fileName) {
        int lineCount = 0;
        try {
            FileInputStream inputstream = new FileInputStream(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream));
            String str;
            bufferedReader.skip(1);                          // the head line

            boolean isLegalCrossing = false;

            ArrayList<Persona> passengers = new ArrayList<>();

            ArrayList<Persona> pedestrians = new ArrayList<>();

            while ((str = bufferedReader.readLine()) != null) {

                String[] data = str.split(",");

                String[] firstTexts = data[0].split(":");
                if (firstTexts[0].equals("scenario")) {
                    if (pedestrians.isEmpty()) {
                        isLegalCrossing = firstTexts[1].equals("green");
                        lineCount++;
                        continue;
                    }

                    Scenario temp = new Scenario(passengers, pedestrians);
                    temp.setLegalCrossing(isLegalCrossing);
                    isLegalCrossing = firstTexts[1].equals("green");
                    passengers = new ArrayList<>();
                    pedestrians = new ArrayList<>();
                    scenarios.add(temp);
                    lineCount++;
                    continue;
                }

                try {
                    if (data.length == 10) {

                    } else {
                        throw new InvalidDataFormatException(lineCount);
                    }
                } catch (InvalidDataFormatException e) {
                    System.out.println(e.getMessage());
                    lineCount++;
                    continue;
                }

                if (data[0].equals("human")) {
                    Human human = new Human();

                    data[1] = data[1].toUpperCase();
                    try {
                        boolean have = false;
                        for (Persona.Gender i : Persona.Gender.values()) {
                            if (i.toString().equals(data[1])) {
                                have = true;
                            }
                        }
                        if (have) {
                            human.setGender(Persona.Gender.valueOf(data[1]));
                        } else {
                            throw new InvalidCharacteristicException();
                        }
                    } catch (InvalidCharacteristicException e) {

                        human.setGender(Persona.Gender.UNKNOWN);

                        System.out.println("WARNING: invalid characteristic in"
                                + " config file in line < " + lineCount + " >");
                    }

                    try {
                        int age = Integer.parseInt(data[2]);
                        human.setAge(age);

                    } catch (NumberFormatException e) {
                        human.setAge(0);
                        System.out.println("WARNING: invalid number"
                                + " format in config file in line < " + lineCount + " >");
                    }

                    data[3] = data[3].toUpperCase();
                    try {
                        boolean have = false;

                        for (Persona.BodyType i : Persona.BodyType.values()) {
                            if (i.toString().equals(data[3])) {
                                have = true;
                            }
                        }
                        if (have) {
                            human.setBodyType(Persona.BodyType.valueOf(data[3]));
                        } else {
                            throw new InvalidCharacteristicException();
                        }
                    } catch (InvalidCharacteristicException e) {

                        human.setBodyType(Persona.BodyType.UNSPECIFIED);

                        System.out.println("WARNING: invalid characteristic in"
                                + " config file in line < " + lineCount + " >");
                    }

                    data[4] = data[4].toUpperCase();
                    try {
                        boolean have = false;
                        if (data[4].equals("")) {
                            data[4] = "NONE";
                        }

                        for (Human.Profession i : Human.Profession.values()) {
                            if (i.toString().equals(data[4])) {
                                have = true;
                            }
                        }
                        if (have) {
                            human.setProfession(Human.Profession.valueOf(data[4]));
                        } else {
                            throw new InvalidCharacteristicException();
                        }
                    } catch (InvalidCharacteristicException e) {

                        human.setProfession(Human.Profession.NONE);

                        System.out.println("WARNING: invalid characteristic in"
                                + " config file in line < " + lineCount + " >");
                    }

                    human.setPregnant(data[5].equalsIgnoreCase("TRUE"));
                    human.setAsYou(data[6].equalsIgnoreCase("TRUE"));

                    if (data[9].equals("passenger")) {
                        passengers.add(human);
                    } else {
                        pedestrians.add(human);
                    }
                }

                if (data[0].equals("animal")) {
                    Animal animal = new Animal();
                    animal.setSpecies(data[7]);
                    animal.setPet(data[8].equalsIgnoreCase("true"));
                    if (data[9].equals("passenger")) {
                        passengers.add(animal);
                    } else {
                        pedestrians.add(animal);
                    }
                }
                lineCount++;
            }

            Scenario temp = new Scenario(passengers, pedestrians);
            temp.setLegalCrossing(isLegalCrossing);
            scenarios.add(temp);
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR: could not find config file.");
            System.exit(0);
        } catch (IOException e) {
        }
    }

    /**
     * output help information
     */
    public void help() {
        System.out.println("EthicalEngine - COMP90041 - Final Project\n\n"
                + "Usage: java EthicalEngine [arguments]\n\n"
                + "Arguments:\n"
                + "   -c or --config      Optional: path to config file\n"
                + "   -h or --help        print Help (this message) and exit\n"
                + "   -r or --results     Optional: path to results log file\n"
                + "   -i or --interactive Optional: launches interactive mode");
    }

    /**
     * my own decision
     *
     * @param scenario
     * @return decision
     */
    public static Decision decide(Scenario scenario) {
        if (scenario.isLegalCrossing()) {
            return Decision.PEDESTRIANS;
        } else if (scenario.getPassengerCount() > scenario.getPedestrianCount()) {
            return Decision.PASSENGERS;
        } else if (scenario.getPassengerCount() < scenario.getPedestrianCount()) {
            return Decision.PEDESTRIANS;
        }

        Persona[] passengers = scenario.getPassengers();
        Persona[] pedsetrians = scenario.getPedestrians();

        int PassHuman = 0;
        int PedeHuman = 0;
        int countPass = 0;
        int countPede = 0;

        for (Persona i : passengers) {
            if (i instanceof Human) {
                PassHuman++;
                if (((Human) i).getAgeCategory() == Human.AgeCategory.BABY
                        || ((Human) i).getAgeCategory() == Human.AgeCategory.CHILD
                        || ((Human) i).isPregnant()) {
                    countPass++;
                }
            }
        }

        for (Persona i : pedsetrians) {
            if (i instanceof Human) {
                PedeHuman++;
                if (((Human) i).getAgeCategory() == Human.AgeCategory.BABY
                        || ((Human) i).getAgeCategory() == Human.AgeCategory.CHILD
                        || ((Human) i).isPregnant()) {
                    countPede++;
                }
            }
        }

        if (countPass > countPede) {
            return Decision.PASSENGERS;
        }
        if (countPede > countPass) {
            return Decision.PEDESTRIANS;
        }

        if (PassHuman > PedeHuman) {
            return Decision.PASSENGERS;
        } else {
            return Decision.PEDESTRIANS;
        }

    }
}

class InvalidDataFormatException extends Exception {

    private int lineCount;

    /**
     * exception of InvalidDataFormat
     *
     * @param lineCount
     */
    public InvalidDataFormatException(int lineCount) {
        super();
        this.lineCount = lineCount;
    }

    public String getMessage() {
        return "WARNING: invalid data format in config file in line < "
                + lineCount + " >";
    }
}

class InvalidCharacteristicException extends Exception {

    public InvalidCharacteristicException() {
        super();
    }
}

class InvalidInputException extends Exception {

    public InvalidInputException() {
        super("Invalid response. ");
    }
}
