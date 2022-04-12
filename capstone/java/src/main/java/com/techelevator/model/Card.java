package com.techelevator.model;

public class Card {
    private int id;
    private int module;
    private String creator;
    private String tag;
    private String question;
    private String answer;
    private String deck;

    public Card() {

    }


    public Card(int id, int module, String creator, String tag, String question, String answer, String deck) {
        this.id = id;
        this.module = module;
        this.creator = creator;
        this.tag = tag;
        this.question = question;
        this.answer = answer;
        this.deck = deck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }
}
