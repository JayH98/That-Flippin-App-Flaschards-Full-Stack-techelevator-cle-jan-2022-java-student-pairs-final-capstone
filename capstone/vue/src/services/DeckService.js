import axios from 'axios';

export default {

  getDeck(deckName) {
    return axios.get(`/decks/${deckName}`);
  },
  getAllDecks(username) {
    return axios.get(`/user/${username}/decks`);
  },
  updateDeck(deck, previousDeckName) {
    return axios.put(`/deck/${previousDeckName}/editDeck`, deck);
  },
  getCardsInDeck(deckname) {
      return axios.get(`/flashcard/deck/${deckname}`)
  },
  createDeck(deck) {
    return axios.post("/deck/createDeck", deck)
  }

  

}