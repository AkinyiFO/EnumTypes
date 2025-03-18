package dev.labs.s3;

import java.util.*;
import java.util.stream.*;
import java.lang.*;

public interface DeckInterface {
    List<CardInterface> getCards();
    DeckInterface deckFactory();
    int size();
    void addCard(CardInterface card);
    void addCards(List<CardInterface> cards);
    void addDeck(DeckInterface deck);
    void shuffle();
    void sort();
    void sort(Comparator<CardInterface> c);
    String deckToString();
    Map<Integer, DeckInterface> deal(int players, int numberOfCards) throws IllegalArgumentException;
}
