/**
 * This is the Class for Hand (set of 5 cards)
 * It saves cards and hand information
 * Including hand category and description
 * Also detailed attribute like sequence, same suits and pairs etc
 */

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    //it's id represents a hand category
    private int category;
    //the description of hand category, includes rank
    private String description;
    //cards of this set
    private ArrayList<Card> cards;

    //detailed attribute
    //is all 5 cards a sequence
    private boolean sequence = true;
    //is all 5 cards have same suit
    private boolean oneSuit = true;
    //one card from a four of a kind set
    private Card quadruple = null;
    //one card from a three of a kind set
    private Card triple = null;
    //a list of pair, each represented by one card from the pair
    private ArrayList<Card> pairs = new ArrayList<Card>();

    //hand category dictionary (the smaller, the winner)
    private final String straightFlush = "0";
    private final String fourOfAKind = "1";
    private final String fullHouse = "2";
    private final String flush = "3";
    private final String straight = "4";
    private final String threeOfAKind = "5";
    private final String twoPair = "6";
    private final String onePair = "7";
    private final String highCard = "8";

    /**
     * Initial Hand
     * @param cards
     */
    public Hand(ArrayList<Card> cards) {
        //sort the card by rank in descending order
        Collections.sort(cards, Collections.reverseOrder());
        this.cards = new ArrayList<Card>(cards);
        organizeCards();

        //get hand type id and description
        String[] handDetails = calcHandDetails();
        this.category = Integer.parseInt(handDetails[0]);
        this.description = handDetails[1];
    }

    /**
     * get category id
     * @return category id
     */
    public int getCategory() {
        return this.category;
    }

    /**
     * get hand description, in a sentence
     * @return hand description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * get the ranks for compare based on hand category
     * @return list of rank values
     */
    public ArrayList<Integer> getRanksForCompare() {
        //for each case
        //get required check value first, then rest of values
        //result is in the order to compare
        ArrayList<Integer> compareList = new ArrayList<Integer>();
        switch (this.category) {
            case 0: //straightFlush
            case 4: //straight
                compareList.add(this.cards.get(0).getValue());
                break;
            case 1: //fourOfAKind
                compareList.add(this.quadruple.getValue());
                compareList.addAll(this.getDifferentValues(
                        this.quadruple.getValue(), -1));
                break;
            case 2: //fullHouse
                compareList.add(this.triple.getValue());
                compareList.add(this.pairs.get(0).getValue());
                break;
            case 3: //flush
            case 8: //highCard
                compareList.addAll(this.getDifferentValues(-1, -1));
                break;
            case 5: //threeOfAKind
                compareList.add(this.triple.getValue());
                compareList.addAll(this.getDifferentValues(
                        this.triple.getValue(), -1));
                break;
            case 6: //twoPair
                compareList.add(this.pairs.get(0).getValue());
                compareList.add(this.pairs.get(1).getValue());
                compareList.addAll(this.getDifferentValues(
                        this.pairs.get(0).getValue(),
                        this.pairs.get(1).getValue()));
                break;
            case 7: //onePair
                compareList.add(this.pairs.get(0).getValue());
                compareList.addAll(this.getDifferentValues(
                        this.pairs.get(0).getValue(), -1));
                break;
            default:
                break;
        }
        return compareList;
    }

    /**
     * get hand's detail information
     * including is sequence, is same suit, full/three/two same ranks
     */
    private void organizeCards() {
        //compare card with it's next card
        for (int i = 0; i < this.cards.size() - 1; i++) {
            Card temp1 = this.cards.get(i);
            Card temp2 = this.cards.get(i + 1);

            if (!temp1.isAdjacent(temp2)) {
                this.sequence = false;
            }

            if (!temp1.isSameSuit(temp2)) {
                this.oneSuit = false;
            }

            if (temp1.isSameRank(temp2)) {
                storeSameRankCards(temp1);
            }
        }
    }

    /**
     * save card to pair/triple/quadruple based on time of appearance
     * @param second
     */
    private void storeSameRankCards(Card second) {
        int existedPairIndex = -1;
        int newValue = second.getValue();

        //get pair index that have same rank
        for (int i = 0; i < this.pairs.size(); i++) {
            if (this.pairs.get(i).getValue() == newValue) {
                existedPairIndex = i;
            }
        }
        //if a pair with same rank existed, then save it as triple
        if (existedPairIndex != -1) {
            this.pairs.remove(existedPairIndex);
            this.triple = second;
        } else {
            //if a triple with same rank existed, then save it as quadruple
            if (this.triple != null && this.triple.getValue() == newValue) {
                this.quadruple = second;
                this.triple = null;
            } else {
                //if not a pair yet, save as pair
                this.pairs.add(second);
            }
        }
    }

    /**
     * decide hand category and description based on hand properties
     * @return [hand category id, hand description]
     */
    private String[] calcHandDetails() {
        //cards.get(0) will get largest rank, because it's sorted
        //all card same suit
        if (this.oneSuit) {
            //if 5 cards are in sequence
            if (this.sequence) {
                return new String[]{this.straightFlush,
                        this.cards.get(0).getRank() + "-high straight flush"};
            } else {
                return new String[]{this.flush,
                        this.cards.get(0).getRank() + "-high flush"};
            }
        }

        //sequence but not same suit
        if (this.sequence) {
            return new String[]{this.straight,
                    this.cards.get(0).getRank() + "-high straight"};
        }

        //if four same rank
        if (this.quadruple != null) {
            return new String[]{this.fourOfAKind,
                    "Four " + this.quadruple.getRank() + "s"};
        }

        //if three same rank
        if (this.triple != null) {
            //if there is a pair
            if (this.pairs.size() > 0) {
                return new String[]{this.fullHouse,
                        this.triple.getRank() + "s full of " +
                                this.pairs.get(0).getRank() + "s"};
            } else {
                return new String[]{this.threeOfAKind,
                        "Three " + this.triple.getRank() + "s"};
            }
        }

        //if there are pairs
        if (this.pairs.size() > 0) {
            if (this.pairs.size() > 1) {
                return new String[]{this.twoPair,
                        this.pairs.get(0).getRank() + "s over " +
                                this.pairs.get(1).getRank() + "s"};
            } else {
                return new String[]{this.onePair,
                        "Pair of " + this.pairs.get(0).getRank() + "s"};
            }
        }

        return new String[]{this.highCard,
                this.cards.get(0).getRank() + "-high"};
    }

    /**
     * get values that different to provided value
     * @param val1
     * @param val2
     * @return [up to 5 rank values]
     */
    private ArrayList<Integer> getDifferentValues(int val1, int val2) {
        ArrayList compareList = new ArrayList();
        this.cards.forEach(result -> {
            if (result.getValue() != val1 && result.getValue() != val2) {
                compareList.add(result.getValue());
            }
        });
        return compareList;
    }
}
