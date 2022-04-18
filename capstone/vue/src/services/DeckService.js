import axios from 'axios';

export default {

  getDeck(deckName) {
    return axios.get(`/decks/${deckName}`);
  },
  getAllDecks(username) {
    return axios.get(`/user/${username}/decks`);
  },
  updateDeck(id, deck) {
    return axios.put(`/flashcard/${id}`, deck);
  },
  getCardsInDeck(deckname) {
      return axios.get(`/flashcard/deck/${deckname}`)
  }

  

}