/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimsys;

/**
 *
 * @author leonard
 */
public class NimHumanPlayer extends NimPlayer{
    public NimHumanPlayer() {
        super();
    }

    public NimHumanPlayer(String theUserName, String theFamilyName, String theGivenName, int theGameNumber, 
            int theWonNumber, boolean theCheckAI) {
	super(theUserName, theFamilyName, theGivenName, theGameNumber, theWonNumber, theCheckAI);
    }
}
