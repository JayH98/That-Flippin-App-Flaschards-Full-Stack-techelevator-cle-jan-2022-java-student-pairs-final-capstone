<template>
<div>

  <form v-on:submit.prevent autocomplete="off">
     
      <div class="form-element">
        <label for="tag"></label>
        <input id="tag" type="text" placeholder="Edit Deck Name Here" v-model="updatedDeck.deck" />
      </div>   
      
      <button class="saveBtn" type="submit" value="Save" v-on:click.prevent="editDeck">Save Changes</button>
      <button class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="cancelEdit()">Cancel</button> 

      <deck v-bind:deck="updatedDeck"/>
      <flash-card-list v-bind:flashCardList = "allFlashCards" @refreshFlashCardList="getAllCards()"/>

  </form>
</div>   
</template>

<script>
import Deck from './Deck.vue';
import DeckService from '../services/DeckService.js'
import FlashCardService from '../services/FlashCardService.js'
import FlashCardList from './FlashCardList.vue';
export default {
  components: { Deck, FlashCardList },
    name: 'edit-deck',
    props: ["deckName"],
    data() {
        return {
            showForm: false,
            allFlashCards: [],
            updatedDeck: {
                deck: "",
            }
        }
    },
    created() {
        DeckService.getDeck(this.$route.params.deckName).then((response) => {
        this.updatedDeck = response.data;
        console.log("Deck was retrieved");

        this.getAllCards();
      })
    },
    methods: {
        editDeck(){
            this.$store.commit("EDIT_DECK", this.updatedCard);
            this.resetForm;
        },
        resetForm(){
            this.showForm = false;
            this.updatedDeck = {
                Tag : "",
                Question : "",
                Answer : "",
            };
        },
        
        getAllCards() {
          FlashCardService.getAllCards(this.$store.state.user.username).then((response) => {
            this.allFlashCards = response.data;
            console.log("All flashcards retrieved")

        });
        },

        cancelEdit() {
          this.$router.push({path: '/'})
        }
    }
}



</script>

<style>
  input.saveBtn,
input.cancelBtn {
  width: 10%;
  padding: 5px;
  border-radius: 15px;
  color: #000000;
  background-color: #00afef;
  font-weight: bold;
  text-align: center;
  text-transform: uppercase;
  

}

</style>
