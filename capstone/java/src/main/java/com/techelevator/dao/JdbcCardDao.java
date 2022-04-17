package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Component
public class JdbcCardDao implements CardDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcCardDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    public String createCard(int module, String creator, String tag, String question, String answer, String deck) {

        String sql =
                "INSERT INTO card_table " +
                        "(module, creator, tag, question, answer, deck) " +
                        "VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, module, creator, tag, question, answer, deck);
        return "Card was created";

    }


    public List<Card> findCardByTag(String tag) {
        List<Card> flashcards = new ArrayList<>();
        String sql = "SELECT id, module, creator, tag, question, answer, deck " +
                "FROM card_table " +
                "WHERE tag = ?; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, tag);
        while (rowSet.next()) {
            flashcards.add(mapRowToCard(rowSet));
        }
        return flashcards;
    }


    public List<Card> findCardByModule(int module) {
        List<Card> flashcards = new ArrayList<>();
        String moduleSql = "SELECT id, module, creator, tag, question, answer, deck " +
                "FROM card_table " +
                "WHERE module =?; ";
        SqlRowSet moduleRowSet = jdbcTemplate.queryForRowSet(moduleSql, module);
        while (moduleRowSet.next()) {
            flashcards.add(mapRowToCard(moduleRowSet));
        }
        return flashcards;
    }



    @Override
    public List<Card> getAllCards(String username) {
        List<Card> flashcards = new ArrayList<>();

        String getAllCardsSql = "SELECT id, module, creator, tag, question, answer, deck " +
                "FROM card_table " +
                "WHERE creator = ? OR creator = 'admin'";

        SqlRowSet results = jdbcTemplate.queryForRowSet(getAllCardsSql, username);

        while (results.next()) {
            flashcards.add(mapRowToCard(results));
        }

        return flashcards;
    }

    @Override
    public Card getCardById(int id) {
       Card card = new Card();
       String findCardByIdSql = "SELECT id, module, creator, tag, question, answer, deck " +
               "FROM card_table " +
               "WHERE id = ?;";

       SqlRowSet rowset = jdbcTemplate.queryForRowSet(findCardByIdSql, id);

       if (rowset.next()) {
           card = mapRowToCard(rowset);
       } return card;
    }


    public List<Card> findCardByCreator(String creator) {
        List<Card> flashcards = new ArrayList<>();
        String creatorSql = "SELECT id, module, creator, tag, question, answer, deck " +
                "FROM card_table " +
                "WHERE creator = ?; ";
        SqlRowSet creatorRowSet = jdbcTemplate.queryForRowSet(creatorSql, creator);
        while (creatorRowSet.next()) {
            flashcards.add(mapRowToCard(creatorRowSet));
        }
        return flashcards;
    }


    public List<Card> findCardByDeck(String deck) {
        List<Card> flashcards = new ArrayList<>();
        String deckSql = "SELECT id, module, creator, tag, question, answer, deck " +
                "FROM card_table " +
                "WHERE deck = ?; ";
        SqlRowSet deckRowSet = jdbcTemplate.queryForRowSet(deckSql, deck);
        while (deckRowSet.next()) {
             flashcards.add(mapRowToCard(deckRowSet));
        }
        return flashcards;
    }

    public String editCard(Card card) {
        String cardSearchSql = "UPDATE card_table " +
                "SET module = ?, creator = ?, tag = ?, question = ?,answer = ?, deck = ? " +
                "WHERE id = ?";
        // WHERE will be on card during edit selection (BY ID)

        jdbcTemplate.update(cardSearchSql, card.getModule(), card.getCreator(), card.getTag(),
                card.getQuestion(), card.getAnswer(), card.getDeck(), card.getId());

        return "Card Was Updated";
    }

    private Card mapRowToCard(SqlRowSet rowSetResults) {

        Card card = new Card();
        card.setId(rowSetResults.getInt("id"));
        card.setModule(rowSetResults.getInt("module"));
        card.setCreator(rowSetResults.getString("creator"));
        card.setTag(rowSetResults.getString("tag"));
        card.setQuestion(rowSetResults.getString("question"));
        card.setAnswer(rowSetResults.getString("answer"));
        card.setDeck(rowSetResults.getString("deck"));

        return card;
    }


}







