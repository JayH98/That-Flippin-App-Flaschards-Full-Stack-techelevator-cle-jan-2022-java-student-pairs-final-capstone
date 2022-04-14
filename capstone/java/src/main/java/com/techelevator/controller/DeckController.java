package com.techelevator.controller;

import com.techelevator.dao.JdbcCardDao;
import com.techelevator.dao.JdbcDeckDao;
import com.techelevator.model.Card;
import com.techelevator.model.Deck;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public class DeckController {

    private JdbcDeckDao deckDao;

    public DeckController(JdbcDeckDao deck) {
        this.deckDao = deck;
    }

    @RequestMapping(path = "/deck/name/{name}", method = RequestMethod.GET)
    public Deck findDeckByUsername(@Valid @PathVariable String username) {
        return deckDao.findDeckByUsername(username);
    }


    @RequestMapping(path = "/deck/editDeck", method = RequestMethod.POST)
    public Deck editDeck(@Valid @RequestBody Deck deck) {
        return deckDao.editDeck(deck.getUsername(), deck.getDeck());

    }

}
