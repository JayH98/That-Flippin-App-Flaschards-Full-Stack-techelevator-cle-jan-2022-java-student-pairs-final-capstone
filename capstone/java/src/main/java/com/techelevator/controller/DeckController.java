package com.techelevator.controller;

import com.techelevator.dao.JdbcCardDao;
import com.techelevator.dao.JdbcDeckDao;
import com.techelevator.model.Card;
import com.techelevator.model.Deck;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class DeckController {

    private JdbcDeckDao deckDao;

    public DeckController(JdbcDeckDao deck) {
        this.deckDao = deck;
    }

    @RequestMapping(path = "/user/{username}/decks", method = RequestMethod.GET)
    public List<Deck> findDeckByUsername(@Valid @PathVariable String username) {
        return deckDao.findDeckByUsername(username);
    }

    @RequestMapping(path = "/decks/{id}", method = RequestMethod.GET)
    public Deck findDeckById(@Valid @PathVariable int id) {
        return deckDao.findDeckById(id);
    }


    @RequestMapping(path = "/deck/editDeck", method = RequestMethod.POST)
    public Deck editDeck(@Valid @RequestBody Deck deck) {
        return deckDao.editDeck(deck.getUsername(), deck.getDeck());
    }

}
