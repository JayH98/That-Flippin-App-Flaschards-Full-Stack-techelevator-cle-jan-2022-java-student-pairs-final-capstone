<template>
<div>
<h4>Create A Flashcard</h4>

  <form v-on:submit.prevent autocomplete="off">
      <div class="form-element">
        <label for="tag">Tag:</label>
        <input id="tag" type="text" placeholder="New Card Tag" v-model="newCard.tag" />
      </div>  
      <div class="form-element">
        <label for="question">Question:</label>
        <textarea id="question" type="text" placeholder="Insert Question Here" v-model="newCard.question" />
      </div>  
      <div class="form-element">
        <label for="answer">Answer:</label>
        <textarea id="answer" type="text" placeholder="Insert Answer Here" v-model="newCard.answer" />
      </div>
      <div class="form-element">
        <label for="deck">Deck:</label>
        <input id="deck" type="text" placeholder="Deck Name" v-model="newCard.deck" />
      </div>
      <input class="saveBtn" type="submit" value="Save" v-on:click.prevent="addNewCard"/>
      <input class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="resetForm" />      

  </form>
</div>   
</template>

<script>
import FlashCardService from '../services/FlashCardService.js'

export default {
    name: "add-card",
    data() {
        return {
            newCard: {
                module : 0,
                creator : this.$store.state.user.username,
                tag : "",
                question : "",
                answer : "",
                deck: "",
            }
        }
    },
    methods: {
        addNewCard(){
            FlashCardService.createCard(this.newCard).then(response => {
              if (response.status === 201) {
              this.resetForm();
              console.log("Card created successfully");
              
              }
            })
            
        },
        resetForm(){
            this.newCard = {
                Module : 0,
                Creator : "",
                Tag : "",
                Question : "",
                Answer : "",
                Deck: "",
            };
        }
    }
}


</script>

<style>
a {
  padding-left: 50px;
  
}

/* below is unNeeded due to being in component AddNewDeck */
/* input.saveBtn,
input.cancelBtn {
  width: 10%;
  padding: 5px;
  border-radius: 5px;
  color: #000000;
  background-color: #00afef;
  font-weight: bold;
  text-align: center;
  text-transform: uppercase;
} */



</style>