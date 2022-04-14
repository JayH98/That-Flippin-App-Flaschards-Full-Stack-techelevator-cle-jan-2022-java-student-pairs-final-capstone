package com.techelevator.dao;

import com.techelevator.model.Card;


public interface CardDao {
        public Card findCardByTag(String tag);
        public Card findCardByCreator(String creator);
        public Card findCardByModule(int module);
        public Card findCardByDeck(String deck);
        public Card editCard(String tag, String question, String answer);
        public String createCard(int module, String creator, String tag, String question, String answer, String deck);


}
