// Source: https://docs.oracle.com/javase/tutorial/java/javaOO/examples/Deck3.java

package dev.labs.s3;

import java.util.Arrays;

public class DeckWithEnum {
    private static CardWithEnum[] cards = new CardWithEnum[52];
    public DeckWithEnum() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[i++] = new CardWithEnum(rank, suit);
                System.out.println(cards);
            }
        }
    }
}
