package com.techelevator.dao;

import com.techelevator.model.Deck;

import java.util.List;

public interface DeckDao {

    public Deck editDeck(String name, String creator);

    public List<Deck> findDeckByUsername(String username);

    public String createDeck(Deck deck);


}
