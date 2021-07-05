/**
 * This is the Class for Cards
 * It interprets card input to suit and rank (and its value)
 * It provide function for compare cards
 */

/**
 * names of suits
 */
enum Suits {
    Clubs,
    Diamonds,
    Hearts,
    Spades,
}

//implement comparable for sortable ArrayList
public class Card implements Comparable<Card> {
    private Suits suit;
    private String rank;
    // rank value (integer version of rank)
    private int value;

    /**
     * initialize Card info
     * @param input
     */
    public Card(String input) {
        //initial object with input
        this.initialSuit(input.substring(1, 2));
        this.initialRank(input.substring(0, 1));

        //if failed to get suit or rank, throw error
        if (this.suit == null || this.rank == null) {
            System.out.printf("Error: invalid card name '%s'\n", input);
            System.exit(1);
        }
    }

    /**
     * get value of rank
     * @return rank value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * get name of rank
     * @return rank
     */
    public String getRank() {
        return this.rank;
    }

    /**
     * get name of suit
     * @return suit
     */
    public Suits getSuit() {
        return this.suit;
    }

    /**
     * override compareTo for using Collection ArrayList sort
     * @param second, the other card for compare
     * @return difference
     */
    @Override
    public int compareTo(Card second) {
        return this.value - second.getValue();
    }

    /**
     * check if two cards have same suit
     * @param second, the other card for compare
     * @return compare result
     */
    public boolean isSameSuit(Card second) {
        return this.suit == second.getSuit();
    }

    /**
     * check if two cards have same rank
     * @param second, the other card for compare
     * @return compare result
     */
    public boolean isSameRank(Card second) {
        return this.value == second.getValue();
    }

    /**
     * check if two cards is adjacent
     * @param second, the other card for compare
     * @return compare result
     */
    public boolean isAdjacent(Card second) {
        return Math.abs(this.value - second.getValue()) == 1;
    }

    /**
     * interpret suit name with input, return null if no match
     * @param info
     */
    private void initialSuit(String info) {
        this.suit = null;
        switch (info) {
            case "C":
                this.suit = Suits.Clubs;
                break;
            case "D":
                suit = Suits.Diamonds;
                break;
            case "H":
                suit = Suits.Hearts;
                break;
            case "S":
                suit = Suits.Spades;
                break;
            default:
                this.suit = null;
                break;
        }
    }

    /**
     * interpret input to rank name and value, return null if no match
     * @param info
     */
    private void initialRank(String info) {
        switch (info) {
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                this.rank = info;
                this.value = Integer.parseInt(info);
                break;
            case "T":
                this.rank = "10";
                this.value = 10;
                break;
            case "J":
                this.rank = "Jack";
                this.value = 11;
                break;
            case "Q":
                this.rank = "Queen";
                this.value = 12;
                break;
            case "K":
                this.rank = "King";
                this.value = 13;
                break;
            case "A":
                this.rank = "Ace";
                this.value = 14;
                break;
            default:
                this.rank = null;
                break;
        }
    }
}
