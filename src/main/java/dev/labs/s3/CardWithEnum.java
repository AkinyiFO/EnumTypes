//Source: https://docs.oracle.com/javase/tutorial/java/javaOO/examples/Card3.java

package dev.labs.s3;

enum Suit {
    DIAMONDS,
    CLUBS,
    HEARTS,
    SPADES
}

enum Rank {
    DEUCE, THREE, FOUR, FIVE, SIX, SEVEN,
    EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

public class CardWithEnum {
    private final Rank rank;
    private final Suit suit;

    public CardWithEnum(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}




