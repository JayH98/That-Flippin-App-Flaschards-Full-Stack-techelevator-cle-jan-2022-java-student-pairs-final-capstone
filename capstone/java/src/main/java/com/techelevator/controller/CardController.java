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
@CrossOrigin
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
    public Card findCardByDeck(@Valid @PathVariable String deck) {
        return cardDao.findCardByDeck(deck);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/flashcard/createCard", method = RequestMethod.POST)
    public String CreateCard(@Valid @RequestBody Card card) {
        return cardDao.createCard(card.getModule(),card.getCreator(),card.getTag(),
                card.getQuestion(),card.getAnswer(),card.getDeck());
    }

    @RequestMapping(path = "/flashcard", method = RequestMethod.PUT)
    public String editCard(@Valid @RequestBody Card card) {
        return cardDao.editCard(card);

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/user/{username}/flashcards", method = RequestMethod.GET)
    public List<Card> getAllCards(@PathVariable String username) {
        return cardDao.getAllCards(username);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/flashcard/{id}", method = RequestMethod.GET)
    public String getCard(@Valid @PathVariable Card card) {
        return cardDao.editCard(card);                      // Need to create a new getCard method in jdbcTemplate and implement that here

    }
}




//will need path

