import axios from 'axios';

export default {

  getCard(id) {
    return axios.get(`/flashcards/${id}`);
  },
  getAllCards(username) {
    return axios.get(`/user/${username}/flashcards`);
  },
  updateCard(id, flashcard) {
    return axios.put(`/flashcard/${id}`, flashcard);
  },
  createCard(flashcard){
    return axios.post(`/flashcard/createCard`, flashcard);
  }

  

}