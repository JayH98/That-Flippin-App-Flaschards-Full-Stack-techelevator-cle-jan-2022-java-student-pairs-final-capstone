package com.techelevator.controller;

import com.techelevator.dao.CardDao;
import com.techelevator.dao.JdbcCardDao;
import com.techelevator.model.Card;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

public class CardController {
    private JdbcCardDao cardDao;

    public CardController(JdbcCardDao card) {
        this.cardDao = card;
    }

    @RequestMapping(path = "/flashcard/{tag}", method = RequestMethod.GET)
    public Card findCardByTag(@Valid @PathVariable String tag) {
            return cardDao.findCardByTag(tag);
        }


    @RequestMapping(path = "/flashcard/{module}", method = RequestMethod.GET)
    public Card findCardByModule(@Valid @PathVariable int module) {
        return cardDao.findCardByModule(module);
    }

    @RequestMapping(path = "/flashcard/{creator}", method = RequestMethod.GET)
    public Card findCardByCreator(@Valid @PathVariable String creator) {
        return cardDao.findCardByCreator(creator);
    }

    @RequestMapping(path = "/flashcard/{deck}", method = RequestMethod.GET)
    public Card findCardByDeck(@Valid @PathVariable String deck) {
        return cardDao.findCardByDeck(deck);

    }

    @RequestMapping(path = "/flashcard/createCard", method = RequestMethod.POST)
    public String CreateCard(@PathVariable @Valid int module, String creator, String tag,
                             String question, String answer, String deck ) {
        return "Card Was Created";
    }

    @RequestMapping(path = "/flashcard", method = RequestMethod.POST)
    public Card editCard(@Valid @PathVariable String tag, String question, String answer) {
        return cardDao.editCard(tag, question, answer);

    }
}




//will need path

