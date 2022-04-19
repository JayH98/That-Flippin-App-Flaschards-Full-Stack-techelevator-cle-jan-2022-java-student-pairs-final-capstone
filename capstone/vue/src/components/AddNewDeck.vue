<template>
  <div>

<h4>Create Deck</h4>

    <form v-on:submit.prevent autocomplete="off">
      <div class="form-element">
        <label for="deckName">Deck Name:</label>
        <input
          id="deckName"
          type="text"
          placeholder="Insert Name Here"
          v-model="newDeck.deck"
        />
      </div>


      <input class="saveBtn" type="submit" value="Save" v-on:click.prevent="addNewDeck"/>
      <input class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="resetForm" />
    </form>
  </div>
</template>

<script>
import DeckService from '../services/DeckService';
export default {
  name: "add-deck",
  data() {
    return {
      newDeck: {
        username : this.$store.state.user.username,
        deck: "",
      },
    };
  },
  methods: {
    addNewDeck() {
      DeckService.createDeck(this.newDeck).then(response => {
        if (response.status === 201) {
          this.resetForm();
          console.log("Deck created successfully")
        }
      }).catch((error) =>{
        console.log(error.response.statusText)
      })

      // this.$store.commit("ADD_DECK", this.newDeck);
      // this.resetForm();
    },
    resetForm() {
      this.newDeck = {
        deck: "",
        username: ""
      };
    },
  },
};
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
.saveBtn:hover {
  transition:linear;
  
  
  background: linear-gradient(to right,#00ADEE, #71D96F 40%);

}

.cancelBtn:hover {
  transition:linear;
  
  background: linear-gradient(to left,#00ADEE,rgba(243,81,81) 40% )


}

</style>

 <!-- <a>Create A New Deck</a> -->