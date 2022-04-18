package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Component
public class JdbcDeckDao implements DeckDao {


    private JdbcTemplate jdbcTemplate;

    public JdbcDeckDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }


    public Deck editDeck(String name, String creator) {
        Deck newDeck = new Deck();
        String deckSearchSql = "UPDATE deck_table " +
                "SET ?, ? ; ";
        // WHERE will be on card during edit selection (BY ID)


        SqlRowSet editedDeck = jdbcTemplate.queryForRowSet(deckSearchSql, name, creator);

        return newDeck;

        // title and the cards inside eg. remove cards from the deck
        // Create a new created deck class?

    }

    public List<Deck> findDeckByUsername(String username) {
        List<Deck> decks = new ArrayList<>();
        String sql = "SELECT deck, deck_id, username " +
                "FROM deck_table " +
                "WHERE username = ? OR username = 'admin'; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
        while (rowSet.next()) {
            decks.add(mapRowToDeck(rowSet));
        }
        return decks;
    }

    public Deck findDeckByDeckName(String deckName) {
        String sql = "SELECT deck, deck_id, username " +
                "FROM deck_table " +
                "WHERE deck = ? ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, deckName);
        if (rowSet.next()) {
            return mapRowToDeck(rowSet);
        }
        return null;
    }


    public String createDeck(Deck deck) {
        String sql = "INSERT INTO deck_table " +
                "(deck, username) " +
                "VALUES (?, ?);";
        jdbcTemplate.update(sql, deck.getDeck(), deck.getUsername());
        return "Deck was created";
    }

    private Deck mapRowToDeck(SqlRowSet rowSetResults) {

        Deck deck = new Deck();
        deck.setDeckId(rowSetResults.getInt("deck_id"));

        deck.setUsername(rowSetResults.getString("username"));

        deck.setDeck(rowSetResults.getString("deck"));

        return deck;
    }

}


