<template>
<div>

  <form v-on:submit.prevent autocomplete="off">
      <div class="form-element">
        <label for="tag"></label>
        <input id="tag" type="text" placeholder="Edit Deck Name Here" v-model="updatedDeck.deck" />
      </div>   
      
      <button class="saveBtn" type="submit" value="Save" v-on:click.prevent="editDeck()">Save Changes</button>
      <button class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="cancelEdit()">Cancel</button>
  </form>



<deck v-bind:deck="updatedDeck"/>

  <div class = "deckUpdated" v-show="deckUpdated">Deck name updated successfully!</div>
  <div class = "deckUpdateFailed" v-show="deckUpdateFailed">We're sorry. An error occurred </div>

  <div class = "filterForm">
    <div class = "tag-label">
      <label for="tagFilter"> </label>
      <input type="text" id="tagFilter" v-model="filter.tag" placeholder="Search By Tag"/>
    </div>

    <div class = "question-label">
      <label for="questionFilter"> </label>
      <input type="text" id="questionFilter" v-model="filter.question" placeholder="Search By Question"/>
    </div>
  </div>

  <h2>All FlashCards</h2>
  
  
<flash-card-list v-bind:flashCardList = "filteredFlashCards" @refreshFlashCardList="getAllCards()"/>

</div>   
</template>

<script>
import Deck from './Deck.vue';
import DeckService from '../services/DeckService.js'
import FlashCardService from '../services/FlashCardService.js'
import FlashCardList from './FlashCardList.vue';
export default {
  components: { Deck, FlashCardList },
    name: 'update-deck',
    props: ["deckName"],
    data() {
        return {
            deckUpdated: false,
            deckUpdateFailed: false,
            filter: {
              tag: '',
              question: ''
            },
            allFlashCards: [],
            updatedDeck: {
                deck: "",
            }, 
            previousDeckName: '',
        }
    },
    created() {
        DeckService.getDeck(this.$route.params.deckName).then((response) => {
        this.updatedDeck = response.data;
        this.previousDeckName = response.data.deck;
        console.log("Deck was retrieved");

        this.getAllCards();
      })
    },
    computed: {
           filteredFlashCards() {
             return this.allFlashCards.filter((flashcard) => {
               if (this.filter.tag  && !flashcard.tag.toLowerCase().includes(this.filter.tag.toLowerCase())) {
                   return false;
               }
               if (this.filter.question  && !flashcard.question.toLowerCase().includes(this.filter.question.toLowerCase())) {
                   return false;
               }
               return true;
           })
        
            }
      },

    methods: {
        editDeck(){
            DeckService.updateDeck(this.updatedDeck, this.previousDeckName).then((response) => {
              if (response.status === 200) {
                this.deckUpdated = true;
                this.deckUpdateFailed = false;
                this.previousDeckName = this.updatedDeck.deck;
                this.getAllCards();
              }
            })
            .catch ((error) => {
              this.deckUpdateFailed = true;
              this.deckUpdated = false;
              error.response.status
            })
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

<style scoped>

form {
  padding-bottom: 5px;
}

.deckUpdated {
  background-color: #00ADEE;
  width: 220px;
  margin-left: 15px;

}

.deckUpdateFailed {
  background-color: rgba(255, 108, 108, 0.746);
  width: 220px;
  margin-left: 15px;
}

.deck {
  margin-bottom: 10px;
}

.filterForm {
  display: flex;
  gap: 10px;
}

h2 {
  background-image: url('../assets/notecard.png');
  background-repeat: no-repeat;
  box-sizing: border-box;
  width: 250px;
  height: 80px;
  padding-top: 20px;
  background-size: 100%;
  color:black;
}
</style>





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


