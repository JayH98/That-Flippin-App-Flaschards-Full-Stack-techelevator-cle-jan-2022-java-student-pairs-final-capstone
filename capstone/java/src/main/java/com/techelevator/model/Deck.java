package com.techelevator.model;

public class Deck {
    private int deckId;
    private String deck;
    private String username;

    public Deck() {
    }


    public Deck(int deckId, String deck, String username) {
        this.deckId = deckId;
        this.deck = deck;
        this.username = username;
    }

    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
