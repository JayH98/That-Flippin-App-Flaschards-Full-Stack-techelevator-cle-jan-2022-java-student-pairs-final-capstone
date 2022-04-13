<template>
<div>
<a
      id="show-form-button"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >Create A Flashcard</a>

  <form v-on:submit.prevent v-if="showForm === true" autocomplete="off">
      <div class="form-element">
        <label for="creator">Creator:</label>
        <input id="creator" type="text" placeholder="Who Are You?" v-model="newCard.Creator" />
      </div>
      <div class="form-element">
        <label for="tag">Tag:</label>
        <input id="tag" type="text" placeholder="New Card Tag" v-model="newCard.Tag" />
      </div>  
      <div class="form-element">
        <label for="question">Question:</label>
        <textarea id="question" type="text" placeholder="Insert Question Here" v-model="newCard.Question" />
      </div>  
      <div class="form-element">
        <label for="answer">Answer:</label>
        <textarea id="answer" type="text" placeholder="Insert Answer Here" v-model="newCard.Answer" />
      </div>
      <div class="form-element">
        <label for="deck">Deck:</label>
        <input id="deck" type="text" placeholder="Deck Name" v-model="newCard.Deck" />
      </div>
      <input class="saveBtn" type="submit" value="Save" v-on:click.prevent="addNewCard"/>
      <input class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="resetForm" />      

  </form>
</div>   
</template>

<script>
export default {
    name: "add-card",
    data() {
        return {
            showForm: false,
            newCard: {
                id : 0,
                Module : 0,
                Creator : "",
                Tag : "",
                Question : "",
                Answer : "",
                Deck: "",
            }
        }
    },
    methods: {
        addNewCard(){
            this.$store.commit("ADD_CARD", this.newCard);
            this.resetForm;
        },
        resetForm(){
            this.showForm = false;
            this.newCard = {
                id : 0,
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