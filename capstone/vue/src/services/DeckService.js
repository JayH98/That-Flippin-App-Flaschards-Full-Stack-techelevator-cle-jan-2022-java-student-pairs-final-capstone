import axios from 'axios';

export default {

  getDeck(id) {
    return axios.get(`/decks/${id}`);
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