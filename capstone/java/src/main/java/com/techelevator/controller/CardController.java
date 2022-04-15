package com.techelevator.controller;

import com.techelevator.dao.CardDao;
import com.techelevator.dao.JdbcCardDao;
import com.techelevator.model.Card;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class CardController {
    private JdbcCardDao cardDao;

    public CardController(JdbcCardDao card) {
        this.cardDao = card;
    }

    @RequestMapping(path = "/flashcard/tag/{tag}", method = RequestMethod.GET)
    public Card findCardByTag(@Valid @PathVariable String tag) {
            return cardDao.findCardByTag(tag);
        }


    @RequestMapping(path = "/flashcard/module/{module}", method = RequestMethod.GET)
    public Card findCardByModule(@Valid @PathVariable int module) {
        return cardDao.findCardByModule(module);
    }

    @RequestMapping(path = "/flashcard/creator/{creator}", method = RequestMethod.GET)
    public Card findCardByCreator(@Valid @PathVariable String creator) {
        return cardDao.findCardByCreator(creator);
    }

    @RequestMapping(path = "/flashcard/deck/{deck}", method = RequestMethod.GET)
    public Card findCardByDeck(@Valid @PathVariable String deck) {
        return cardDao.findCardByDeck(deck);

    }

    @RequestMapping(path = "/flashcard/createCard", method = RequestMethod.POST)
    public String CreateCard(@Valid @RequestBody Card card) {
        return cardDao.createCard(card.getModule(),card.getCreator(),card.getTag(),
                card.getQuestion(),card.getAnswer(),card.getDeck());
    }

    @RequestMapping(path = "/flashcard", method = RequestMethod.POST)
    public Card editCard(@Valid @RequestBody Card card) {
        return cardDao.editCard(card.getTag(), card.getQuestion(), card.getAnswer());

    }
}




//will need path

