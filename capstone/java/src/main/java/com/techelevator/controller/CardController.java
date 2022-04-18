package com.techelevator.controller;

import com.techelevator.dao.CardDao;
import com.techelevator.dao.JdbcCardDao;
import com.techelevator.model.Card;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class CardController {
    private JdbcCardDao cardDao;

    public CardController(JdbcCardDao card) {
        this.cardDao = card;
    }

    @RequestMapping(path = "/flashcard/tag/{tag}", method = RequestMethod.GET)
    public List<Card> findCardByTag(@Valid @PathVariable String tag) {
        return cardDao.findCardByTag(tag);
    }

    @RequestMapping(path = "/flashcard/module/{module}", method = RequestMethod.GET)
    public List<Card> findCardByModule(@Valid @PathVariable int module) {
        return cardDao.findCardByModule(module);
    }

    @RequestMapping(path = "/flashcard/creator/{creator}", method = RequestMethod.GET)
    public List<Card> findCardByCreator(@Valid @PathVariable String creator) {
        return cardDao.findCardByCreator(creator);
    }

    @RequestMapping(path = "/flashcard/deck/{deck}", method = RequestMethod.GET)
    public List<Card> findCardByDeck(@Valid @PathVariable String deck) {
        return cardDao.findCardByDeck(deck);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/flashcard/createCard", method = RequestMethod.POST)
    public String createCard(@Valid @RequestBody Card card) {
        return cardDao.createCard(card.getModule(), card.getCreator(), card.getTag(),
                card.getQuestion(), card.getAnswer(), card.getDeck());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/flashcard/{id}", method = RequestMethod.PUT)
    public String editCard(@Valid @PathVariable int id, @RequestBody Card card) {
        return cardDao.editCard(card);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/user/{username}/flashcards", method = RequestMethod.GET)
    public List<Card> getAllCards(@PathVariable String username) {
        return cardDao.getAllCards(username);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/flashcards/{id}", method = RequestMethod.GET)
    public Card getCard(@PathVariable int id) {
        return cardDao.getCardById(id);                      // Need to create a new getCard method in jdbcTemplate and implement that here

    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/flashcard/{id}/deck", method = RequestMethod.PUT)
    public void removeCardFromDeck(@PathVariable int id) {
        cardDao.removeCardFromDeck(id);
    }

}


//will need path

