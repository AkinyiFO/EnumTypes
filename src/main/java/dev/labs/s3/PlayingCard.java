package dev.labs.s3;

// Source: https://docs.oracle.com/javase/tutorial/java/IandI/examples/defaultmethods/PlayingCard.java

public class PlayingCard implements CardInterface {

    private CardInterface.Rank rank;
    private CardInterface.Suit suit;

    public PlayingCard(CardInterface.Rank rank, CardInterface.Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public CardInterface.Suit getSuit() {
        return suit;
    }

    public CardInterface.Rank getRank() {
        return rank;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CardInterface) {
            if (((CardInterface)obj).getRank() == this.rank &&
                    ((CardInterface)obj).getSuit() == this.suit) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public int hashCode() {
        return ((suit.value()-1)*13)+rank.value();
    }

    public int compareTo(CardInterface o) {
        return this.hashCode() - o.hashCode();
    }

    public String toString() {
        return this.rank.text() + " of " + this.suit.text();
    }

    public static void main(String... args) {
        new PlayingCard(Rank.ACE, Suit.DIAMONDS);
        new PlayingCard(Rank.KING, Suit.SPADES);
    }
}
