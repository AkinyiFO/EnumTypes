package dev.labs.s3;

import java.util.*;
import java.util.stream.*;
import java.lang.*;

public class StandardDeck  implements DeckInterface {

    private List<CardInterface> entireDeck;

    public StandardDeck(List<CardInterface> existingList) {
        this.entireDeck = existingList;
    }

    public StandardDeck() {
        this.entireDeck = new ArrayList<>();
        for (CardInterface.Suit s : CardInterface.Suit.values()) {
            for (CardInterface.Rank r : CardInterface.Rank.values()) {
                this.entireDeck.add(new PlayingCard(r, s));
            }
        }
    }

    public DeckInterface deckFactory() {
        return new StandardDeck(new ArrayList<CardInterface>());
    }

    public int size() {
        return entireDeck.size();
    }

    public List<CardInterface> getCards() {
        return entireDeck;
    }

    public void addCard(CardInterface card) {
        entireDeck.add(card);
    }

    public void addCards(List<CardInterface> cards) {
        entireDeck.addAll(cards);
    }


    public void addDeck(DeckInterface deck) {
        List<CardInterface> listToAdd = deck.getCards();
        entireDeck.addAll(listToAdd);
    }

    public void sort() {
        Collections.sort(entireDeck);
    }

    public void sort(Comparator<CardInterface> c) {
        Collections.sort(entireDeck, c);
    }

    public void shuffle() {
        Collections.shuffle(entireDeck);
    }

    public Map<Integer, DeckInterface> deal(int players, int numberOfCards)
            throws IllegalArgumentException
    {
        int cardsDealt = players * numberOfCards;
        int sizeOfDeck = entireDeck.size();
        if (cardsDealt > sizeOfDeck) {
            throw new IllegalArgumentException(
                    "Number of players (" + players +
                            ") times number of cards to be dealt (" + numberOfCards +
                            ") is greater than the number of cards in the deck (" +
                            sizeOfDeck + ").");
        }

        Map<Integer, List<CardInterface>> dealtDeck = entireDeck
                .stream()
                .collect(
                        Collectors.groupingBy(
                                card -> {
                                    int cardIndex = entireDeck.indexOf(card);
                                    if (cardIndex >= cardsDealt) return (players + 1);
                                    else return (cardIndex % players) + 1;
                                }));

        // Convert Map<Integer, List<Card>> to Map<Integer, Deck>
        Map<Integer, DeckInterface> mapToReturn = new HashMap<>();

        for (int i = 1; i <= (players + 1); i++) {
            DeckInterface currentDeck = deckFactory();
            currentDeck.addCards(dealtDeck.get(i));
            mapToReturn.put(i, currentDeck);
        }
        return mapToReturn;
    }

    public String deckToString() {
        return this.entireDeck
                .stream()
                .map(CardInterface::toString)
                .collect(Collectors.joining("\n"));
    }

    public static void main(String... args) {
        StandardDeck myDeck = new StandardDeck();
        System.out.println("Creating deck:");
        myDeck.sort();
        System.out.println("Sorted deck");
        System.out.println(myDeck.deckToString());
        myDeck.shuffle();
        myDeck.sort(new SortByRankThenSuit());
        System.out.println("Sorted by rank, then by suit");
        System.out.println(myDeck.deckToString());
        myDeck.shuffle();
        myDeck.sort(
                Comparator.comparing(CardInterface::getRank)
                        .thenComparing(Comparator.comparing(CardInterface::getSuit)));
        System.out.println("Sorted by rank, then by suit " +
                "with static and default methods");
        System.out.println(myDeck.deckToString());
        myDeck.sort(
                Comparator.comparing(CardInterface::getRank)
                        .reversed()
                        .thenComparing(Comparator.comparing(CardInterface::getSuit)));
        System.out.println("Sorted by rank reversed, then by suit " +
                "with static and default methods");
        System.out.println(myDeck.deckToString());
    }
}
