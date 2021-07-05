/**
 * This is the Class for Player
 * It saves player id and its hand
 * Provides function for compare player's hand
 */

import java.util.ArrayList;

public class Player {
    private int id;
    private Hand hand;

    /**
     * initialize player
     * @param id  player id
     * @param hand  (card set)
     */
    public Player(int id, Hand hand) {
        //player id
        this.id = id;
        this.hand = hand;
    }

    /**
     * get player id, the order of card set
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * get hand description (explain hand and rank)
     * @return description
     */
    public String getHandDescription() {
        return this.hand.getDescription();
    }

    /**
     * decide winner(draw) between two cards
     * @param second
     * @return compare result
     */
    public String compete(Player second) {
        //firstly, decide winner by hand category
        if (this.hand.getCategory() < second.hand.getCategory()) {
            return "Win";
        } else if (this.hand.getCategory() > second.hand.getCategory()) {
            return "Lose";
        } else {
            //if they have same category, proceed to value compare
            ArrayList<Integer> list1 = this.hand.getRanksForCompare();
            ArrayList<Integer> list2 = second.hand.getRanksForCompare();

            //Compare each rank until get a winner
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) > list2.get(i)) {
                    return "Win";
                } else if (list1.get(i) < list2.get(i)) {
                    return "Lose";
                }
            }
            //if still no winner, then draw
            return "Draw";
        }
    }

}
