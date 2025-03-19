package dev.labs.s3;

import java.util.*;

public class SortByRankThenSuit implements Comparator<CardInterface> {
    public int compare(CardInterface firstCard, CardInterface secondCard) {
        int compVal =
                firstCard.getRank().value() - secondCard.getRank().value();
        if (compVal != 0)
            return compVal;
        else
            return firstCard.getSuit().value() - secondCard.getSuit().value();
    }
}

