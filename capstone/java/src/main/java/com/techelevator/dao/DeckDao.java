package com.techelevator.dao;

import com.techelevator.model.Deck;

public interface DeckDao {

   public Deck editDeck(String name, String creator);

    public Deck findDeckByUsername(String username);

}
