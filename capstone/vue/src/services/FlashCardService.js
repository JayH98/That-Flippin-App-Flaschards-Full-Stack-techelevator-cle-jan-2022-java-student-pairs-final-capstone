import axios from 'axios';

export default {

  getCards(user) {
    return axios.get('/flashcard', user)
  },

  

}