/*
 * 1. As a warmup, write a program that uses shuffleDeck and subdeck to generate 
and print four random poker hands with five cards each. Did you get anything good? 
Here are the possible poker hands, in increasing order of value:

pair: two cards with the same rank
two pair: two pairs of cards with the same rank
three of a kind: three cards with the same rank
straight: five cards with ranks in sequence
flush: five cards with the same suit
full house: three cards with one rank, two cards with another
four of a kind: four cards with the same rank
straight flush: five cards in sequence and with the same suit

2. Write a method called isFlush that takes a Deck as a parameter and returns a 
boolean indicating whether the hand contains a flush.

3. Write a method called isThreeKind that takes a hand and returns a boolean 
indicating whether the hand contains Three of a Kind.

4. Write a loop that generates a few thousand hands and checks whether they 
contain a flush or three of a kind. Estimate the probability of getting one of 
those hands.

5. Write methods that test for the other poker hands. Some are easier than others. 
You might find it useful to write some general-purpose helper methods that can 
be used for more than one test.
 */
package pokerhand;

/**
 *
 * @author Aviel Resnick
 */
public class PokerHand {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a deck of 52 Cards
        Deck newDeck = new Deck(52);
        
        // Shuffle the deck
        newDeck = shuffle(newDeck);
        
        // Generate a hand
        Hand hand = subdeck(newDeck, 0, 4);
        
        // Prints the current hand
        printHand(hand);
        
        // Checks for Pair
        System.out.println("Pair: " + isPair(hand));
        
        // Check for Two Pair
        System.out.println("Two Pair: " + isTwoPair(hand));
        
        // Checks for Three of a kind
        System.out.println("Three of a kind: " + isThreeOfAKind(hand));
        
        // Checks for Straight
        System.out.println("Straight: " + isStraight(hand));
        
        // Checks for Flush
        System.out.println("Flush: " + isFlush(hand));
        
        // Full House
        System.out.println("Full House: " + isFullHouse(hand));
        
        // Four of a Kind
        System.out.println("Four of a Kind: " + isFourOfAKind(hand));
        
        // Straight Flush
        System.out.println("Straight Flush: " + isStraightFlush(hand));
    }

    // Shuffles a deck
    public static Deck shuffle(Deck deck) {
        for (int i = 0; i < deck.cards.length; i++) {
            int x = i + (int)(Math.random() * ((deck.cards.length - i)));
            Card b = deck.cards[i];
            deck.cards[i] = deck.cards[x];
            deck.cards[x] = b;
        }
        return deck;
    }
    
    // Generates a subdeck
    public static Hand subdeck(Deck deck, int low, int high) {
        Hand sub = new Hand(5);
        
        return sub;
    }    
    
    public static boolean isPair (Hand hand) {
        boolean flag = false;
        for (int x = 0; x < hand.cards.length; x++) {
            for (int y = x + 1; y < hand.cards.length; y++) {
                if (hand.cards[x].rank == hand.cards[y].rank) {
                    flag = true;
                }
            }
        }
        return flag;
    }
    
    public static boolean isThreeOfAKind (Hand hand) {
        boolean flag = false;
        
        // Sort
        for (int x = 0; x < hand.cards.length; x++) {
            int smallest = hand.cards[x].rank;
            for (int y = x; y < hand.cards.length; y++) {
                if (hand.cards[y].rank < smallest) {
                    int a = hand.cards[x].rank;
                    hand.cards[x].rank = hand.cards[y].rank;
                    hand.cards[y].rank = a;
                }
            }
        }
        
    	for (int i = 0; i <= hand.cards.length - 3; i++) {
            if (hand.cards[i].rank == hand.cards[i+2].rank) {
                flag = true;
            }
    	}
    	return flag;
    }
    
    // Checks for four of a kind
    public static boolean isFourOfAKind(Hand hand) {
        boolean flag = false;
        // iterate through all possible beginnings of the four of a kind
    	for (int i = 0; i <= hand.cards.length - 4; i++) {
    		
    		// cards are sorted, so if below condition is true, 
    		// then faces of all cards from i to i+3 are the same
    		if (hand.cards[i].rank == hand.cards[i+3].rank)
    			flag = true;
    	}
    	return flag;
    }
    
    // Checks for Two pair
    public static boolean isTwoPair (Hand hand) {
        boolean flag = false;
        // Sort
        for (int x = 0; x < hand.cards.length; x++) {
            int smallest = hand.cards[x].rank;
            for (int y = x; y < hand.cards.length; y++) {
                if (hand.cards[y].rank < smallest) {
                    int a = hand.cards[x].rank;
                    hand.cards[x].rank = hand.cards[y].rank;
                    hand.cards[y].rank = a;
                }
            }
        }
        
        // Case, when card without pair is the last one
    	if (hand.cards[0].rank == hand.cards[1].rank && hand.cards[2].rank == hand.cards[3].rank) {
    		flag = true;
    	}
    	
    	// Case, when card without pair is in the middle
    	if (hand.cards[0].rank == hand.cards[1].rank && hand.cards[3].rank == hand.cards[4].rank) {
    		flag = true;
    	}

    	// Case, when card without pair is the first one
    	if (hand.cards[1].rank == hand.cards[2].rank && hand.cards[3].rank == hand.cards[4].rank) {
    		flag = true;
    	}

    	return flag;
    }
    
    // Check for straight
    public static boolean isStraight (Hand hand) {
        int x = 1;
    	boolean flag = false;
        
    	// Check all cards in the hand, comparing their faces
    	// and counting how many have consecutive values
    	for (int i = 0; i < hand.cards.length - 1; i++) {
    		if (hand.cards[i].rank + 1 == hand.cards[i+1].rank) {
    			x++;
    		}
    	}
    	
    	// if there are 5 cards with consecutive value of faces - return true
    	if (x == 5) {
    		flag = true;
    	}
    	
        return flag;
    }
    
    // Full house
    public static boolean isFullHouse (Hand hand) {
        boolean flag = false;
        // Sort
        for (int x = 0; x < hand.cards.length; x++) {
            int smallest = hand.cards[x].rank;
            for (int y = x; y < hand.cards.length; y++) {
                if (hand.cards[y].rank < smallest) {
                    int a = hand.cards[x].rank;
                    hand.cards[x].rank = hand.cards[y].rank;
                    hand.cards[y].rank = a;
                }
            }
        }
        
        // Case, when three of a kind are first in the hand (lower value)
    	if (hand.cards[0].rank == hand.cards[2].rank && hand.cards[3].rank == hand.cards[4].rank) {
    		flag = true;
    	}
    	
    	// Case, when three of a kind are not first in the hand (higher value)
    	if (hand.cards[0].rank == hand.cards[1].rank && hand.cards[2].rank == hand.cards[4].rank) {
    		flag = true;
    	}

    	return flag;
    }
    
    // Check for Flush
    public static boolean isFlush (Hand hand) {
        boolean flag = true;
        // Suit to compare others to
        int suit = hand.cards[0].suit;
        
        for (int i = 1; i < hand.cards.length; i++) {
            if (hand.cards[i].suit != suit) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    // Check for Straight and Flush
    public static boolean isStraightFlush (Hand hand) {
        if (isStraight(hand) == true && isFlush(hand) == true) {
            return true;
        }
        else {
            return false;
        }
    }
    
    // Traverse and print a deck
    public static void printDeck(Deck deck) {
        for (int i = 0; i < deck.cards.length; i++) {
            System.out.println(deck.cards[i].suit + " - " + deck.cards[i].rank);
        }
    }
    
    // Traverse and print a hand
    public static void printHand(Hand hand) {
        for (int i = 0; i < hand.cards.length; i++) {
            System.out.println(hand.cards[i].suit + " - " + hand.cards[i].rank);
        }
    }
}

// Generates a deck class
class Deck {
    Card[] cards;
    
    public Deck(int n) {
        this.cards = new Card[n];
        int index = 0;
        
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(suit, rank);
                index++;
            }
        }
    }
}


// Hand Class
class Hand {
    Card[] cards;
    
    public Hand(int n) {
        this.cards = new Card[n];
        
        for (int index = 0; index < n; index++) {
            cards[index] = new Card(0 + (int)(Math.random() * ((3 - 0) + 1)), 1 + (int)(Math.random() * ((13 - 1) + 1)));
        }
    }
}

// Card Class
class Card {
    int suit, rank;
    
    public Card() {
        this.suit = 0; this.rank = 0;
    }
    
    public Card(int suit, int rank) {
        this.suit = suit; this.rank = rank;
    }
}