/**
 * This is the root of Poker game
 * It validates input and saves input into data structure
 * It checks winner and print output
 */

import java.util.ArrayList;

public class Poker {
    public static void main(String[] args) {
        // If inputs are not available sets (set of 5), throw error
        if (args.length % 5 > 0 || args.length <= 0) {
            System.out.println("Error: wrong number of arguments; " +
                    "must be a multiple of 5");
            System.exit(1);
        }

        //players list for holding card sets (hands)
        ArrayList<Player> players = new ArrayList<Player>();

        //Assign cards to players
        ArrayList<Card> tempCard = new ArrayList<Card>();
        for (int i = 0; i < args.length; i++) {
            tempCard.add(new Card(args[i].toUpperCase()));
            if (tempCard.size() == 5) {
                //Create a new player and save to player list
                Hand tempHand = new Hand(tempCard);
                Player tempPlayer = new Player(i/5 + 1, tempHand);
                players.add(tempPlayer);

                //print out player information
                System.out.printf("Player %d: %s\n",
                        tempPlayer.getId(), tempPlayer.getHandDescription());

                //clear card list so it's ready for next set
                tempCard.clear();
            }
        }

        //find winner if have more than 1 players
        if(players.size() > 1) {
            ArrayList<Player> winners = getWinners(players);
            //print out result
            int size = winners.size();
            if (size > 1) {
                printDrawResult(size, winners);
            } else {
                System.out.printf("Player %d wins.\n", winners.get(0).getId());
            }
        }
    }

    /**
     * get list of winners
     * @param allPlayers
     * @return list of winners
     */
    private static ArrayList<Player> getWinners(ArrayList<Player> allPlayers){
        ArrayList<Player> winners = new ArrayList<Player>();
        for (int i = 0; i < allPlayers.size(); i++) {
            Player currentPlayer = allPlayers.get(i);

            //Set a default winner if no winner exists
            if (winners.size() == 0) {
                winners.add(currentPlayer);
            } else {
                Player winnerPlayer = winners.get(0);
                String result = currentPlayer.compete(winnerPlayer);
                //update winner based on compete result
                if (result == "Draw") {
                    winners.add(currentPlayer);
                } else {
                    if (result == "Win") {
                        winners.clear();
                        winners.add(currentPlayer);
                    }
                    //do nothing if challenge winner failed
                }
            }
        }
        return winners;
    }

    /**
     * print draw result to console
     * @param size
     * @param winners
     */
    private static void printDrawResult(int size, ArrayList<Player> winners){
        System.out.print("Players ");
        for (int i = 0; i < size - 2; i++) {
            System.out.printf("%d, ", winners.get(i).getId());
        }
        System.out.printf("%d and %d draw.\n",
                winners.get(size - 2).getId(),
                winners.get(size - 1).getId());
    }
}
