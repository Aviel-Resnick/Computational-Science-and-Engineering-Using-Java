/*
 * Exercises 13.1 - 13.4
 * Performs multiple card-based tasks, e.g sort, compare value, identify poker hands.
 */
package cardoperations;

/**
 *
 * @author Aviel Resnick
 */
public class CardOperations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test makeDeck and suitHist
        System.out.println(suitHist(makeDeck())[0]);
    }
    
    // Compares the suit and rank of two cards
    public static int compareCards (Card a, Card b) {
        // Compare Suit Values
        if (a.suit > b.suit) return 1;
        if (a.suit < b.suit) return -1;
        
        // If suits are the same, compare ranks
        if (a.rank > b.rank) return 1;
        if (b.rank < b.rank) return -1;   
        
        return 0;
    }
    
    // Generates a deck of 52 Cards
    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        
        int index = 0;
        // For each suit
        for(int suit = 0; suit <= 3; suit++) {
            // Add each rank
            for(int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(suit, rank);
                index++;
            }
        }
        // Return the deck
        return cards;    
    }
    
    // Calculates the value of the hand
    public static int handScore(Card[] cards) {
        int score = 0;
        
        // Checks for face cards, else adds rank
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].rank > 10) {
                score = score + 10;
            }
            else {
                score = score + cards[i].rank;
            }
        }
        // Returns score
        return score;
    }
    
    // Generates a histogram of the suits (Uses Chapter 12 code)
    public static int[] suitHist(Card[] cards){
        // Creates a new Hist
        int[] hist = new int[cards.length];
        // Checks for, and adds for, each suit (of each card).
        for (int i = 0; i < cards.length; i++) {
            int index = cards[i].suit;
            hist[index]++;
        }
        // Returns Hist[]
        return hist;
    }
    
    // Checks for a flush
    public static boolean hasFlush(Card[] cards) {
        // Uses suitHist
        int[] hist = suitHist(cards);
        boolean flag = false;
        
        // Checks each suit for flush
        for(int i = 0; i < 4; i++) {
            if(hist[i] >= 5) {
                flag = true;
            }
        }
        //Returns bool, for flush / no flush
        return flag;
    }
}

// Generates a card class
class Card
{
    int suit, rank;
    
    public Card() {
        this.suit = 0; this.rank = 0;
    }
    
    public Card(int suit, int rank) {
        this.suit = suit; this.rank = rank;
    }
}