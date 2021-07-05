package JavaS12021A1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class AutoEntry extends Entry {


    public AutoEntry(String memberID, String type) {
        super(memberID);
        if (type.equals("T")) {
            super.setNumbers(createNumbers(super.getEntryId() - 1));
        } else {
            super.setNumbers(createNumbers());
        }
    }

    public static int[] createNumbers() {
        ArrayList<Integer> validList = new ArrayList<Integer>();
        int[] tempNumbers = new int[7];
        for (int i = 1; i <= 35; i++) {
            validList.add(i);
        }
        Collections.shuffle(validList, new Random());
        for (int i = 0; i < 7; i++) {
            tempNumbers[i] = validList.get(i);
        }
        Arrays.sort(tempNumbers);
        return tempNumbers;
    }

    public static int[] createNumbers (int seed) {
        ArrayList<Integer> validList = new ArrayList<Integer>();
	    int[] tempNumbers = new int[7];
        for (int i = 1; i <= 35; i++) {
    	    validList.add(i);
        }
        Collections.shuffle(validList, new Random(seed));
        for (int i = 0; i < 7; i++) {
    	    tempNumbers[i] = validList.get(i);
        }
        Arrays.sort(tempNumbers);
        return tempNumbers;
    }

    public String showIDAndNumber(){
        return super.showIDAndNumber() + " [Auto]";
    }

    public String showAllInformation(){
        return super.showAllInformation() + " [Auto]";
    }
}
