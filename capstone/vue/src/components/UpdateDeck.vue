<template>
<div>

  <form v-on:submit.prevent autocomplete="off">
     
      <div class="form-element">
        <label for="tag">Deck Name: </label>
        <input id="tag" type="text" placeholder="Edit Deck Name Here" v-model="updatedDeck.deck" />
      </div>   
      
      <button class="saveBtn" type="submit" value="Save" v-on:click.prevent="editDeck">Save Changes</button>
      <button class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="resetForm">Cancel</button> 

      <deck v-bind:deck="updatedDeck"/>
      <flash-card-list/>     

  </form>
</div>   
</template>

<script>
import Deck from './Deck.vue';
import DeckService from '../services/DeckService.js'
import FlashCardList from './FlashCardList.vue';
export default {
  components: { Deck, FlashCardList },
    name: 'edit-deck',
    props: ["deckName"],
    data() {
        return {
            showForm: false,
            updatedDeck: {
                deck: "",
            }
        }
    },
    created() {
        DeckService.getDeck(this.$route.params.deckName).then((response) => {
        this.updatedDeck = response.data;
        console.log("Deck was retrieved")
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
        }
    },
   


}


</script>

<style>
  input.saveBtn,
input.cancelBtn {
  width: 10%;
  padding: 5px;
  border-radius: 5px;
  color: #000000;
  background-color: #00afef;
  font-weight: bold;
  text-align: center;
  text-transform: uppercase;
}


