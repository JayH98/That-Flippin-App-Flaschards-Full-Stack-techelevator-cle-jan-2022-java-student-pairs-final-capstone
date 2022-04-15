import axios from 'axios';

export default {

  getCard(id) {
    return axios.get(`/flashcards/${id}`, id);
  },
  getAllCards(userID) {
    return axios.get(`/user/${userID}/flashcards`, userID);
  },
  updateCard(id, flashcard) {
    return axios.put(`/flashcard/${id}`, flashcard);
  }

  

}