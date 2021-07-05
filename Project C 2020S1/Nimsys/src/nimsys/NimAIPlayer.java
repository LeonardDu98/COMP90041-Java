package nimsys;

/*
	NimAIPlayer.java
	
	This class is provided as a skeleton code for the tasks of 
	Sections 2.4, 2.5 and 2.6 in Project C. Add code (do NOT delete any) to it
	to finish the tasks. 
*/

public class NimAIPlayer extends NimPlayer implements Testable {

	public NimAIPlayer() {
            super();
	}
        
        public NimAIPlayer(String theUserName, String theFamilyName, String theGivenName, int theGameNumber, 
            int theWonNumber, boolean theCheckAI) {
            super(theUserName, theFamilyName, theGivenName, theGameNumber, theWonNumber, theCheckAI);
        }
	
        public int removeStone(int leftStone, int upperBound){
            if(leftStone % (upperBound + 1) == 0){
                return upperBound;
            }
            if(leftStone % (upperBound + 1) != 1){
                return leftStone % (upperBound + 1) - 1;
            }
            return 1;
        }
        
	public String advancedMove(boolean[] available, String lastMove) {
		
		String move = "";
		
		return move;
	}
}
