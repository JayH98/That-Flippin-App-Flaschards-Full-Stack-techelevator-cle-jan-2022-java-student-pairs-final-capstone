<template>
  <div>

    <form v-on:submit.prevent autocomplete="off">
      <div class="form-element">
       
        <input
          id="deckName"
          type="text"
          placeholder="Insert Deck Name Here"
          v-model="newDeck.deck"
        />
      </div>


      <input class="saveBtn" type="submit" value="Save" v-on:click.prevent="addNewDeck"/>
      <input class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="cancelEdit()" />
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

     
    },
    resetForm() {
      this.newDeck = {
        deck: "",
        username: ""
      };
    },
    cancelEdit() {
          this.$router.push({path: '/'})
        }
  },
};
</script>

<style>

input.saveBtn,
input.cancelBtn {
  position:relative;
  right:7%;
  font-family:'Courier New', Courier, monospace;
  width: 50%;
  padding: 5px;
  border-radius: 5px;
  color: #000000;
  background-color: #00afef;
  font-weight: bold;
  text-align: center;
  text-transform: uppercase;
  background-image: url('../assets/parchment.jpg');
  
}
.saveBtn:hover {
  transition:linear;
  
  
  background: linear-gradient(to right,#00ADEE, #71D96F 40%);
  cursor:url('../assets/pointer_tilted.png'), pointer;
}

.cancelBtn:hover {
  transition:linear;
  
  background: linear-gradient(to left,#00ADEE,rgba(243,81,81) 40% );
 

  cursor:url('../assets/pointer_tilted.png'), pointer;
}

</style>

