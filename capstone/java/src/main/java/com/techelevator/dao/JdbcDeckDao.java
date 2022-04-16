package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class JdbcDeckDao implements DeckDao{


    private JdbcTemplate jdbcTemplate;

    public JdbcDeckDao(DataSource datasource) { this.jdbcTemplate = new JdbcTemplate(datasource);}


    public Deck editDeck(String name, String creator) {
        Deck newDeck = new Deck();
        String deckSearchSql = "UPDATE deck_table "+
                "SET ?, ? ; ";
        // WHERE will be on card during edit selection (BY ID)


        SqlRowSet editedDeck = jdbcTemplate.queryForRowSet(deckSearchSql, name, creator);

        return newDeck;

        // title and the cards inside eg. remove cards from the deck
        // Create a new created deck class?

    }

    public Deck findDeckByUsername(String username) {
        String sql = "SELECT deck " +
                "FROM deck_table "+
                "WHERE username = ?; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
        if (rowSet.next()) {
            return mapRowToDeck(rowSet);
        } return null;
    }

    private Deck mapRowToDeck(SqlRowSet rowSetResults) {

        Deck deck = new Deck();
        deck.setDeckId(rowSetResults.getInt("deck_id"));

        deck.setUsername(rowSetResults.getString("username"));

        deck.setDeck(rowSetResults.getString("deck"));

        return deck;
    }

    }


