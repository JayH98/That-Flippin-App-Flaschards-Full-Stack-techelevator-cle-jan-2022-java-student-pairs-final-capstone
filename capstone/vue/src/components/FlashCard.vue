<template>


  <div class="flashcard" @click="flipCard = !flipCard" v-bind:class="{'flipped': flipCard}">
    <div class="flashcard-front">
        <div class = 'box'>
      <h1>{{ flashcard.module }} / {{ flashcard.tag }}</h1>
      <section>Q: {{ flashcard.question }}</section>
      <p>ID: {{ flashcard.id }}</p>
      <router-link v-bind:to="{name: 'edit-flashcard', params: { id: flashcard.id }}"><button>Edit Flashcard</button></router-link>
      <div class = "edit-buttons">
        <button v-show="this.$route.name ===  'edit-deck'" v-if="flashcard.deck !== this.$route.params.deckName" @click="addCardToDeck(flashcard.id)">Add to deck</button>
        <button v-show="this.$route.name === 'edit-deck'" @click="removeCardFromDeck(flashcard.id)" v-if="flashcard.deck === this.$route.params.deckName">Remove from deck</button>
      </div>
        </div>
    </div>

    <!-- Added button to edit card and delete card. -->
    <!-- <router-link tag="edit-flashcard" @click="edit-flashcard" v-bind:class="{'edit' : editCard}">
      <h1>{{ card.title }}</h1>
      <p>{{ card.description }}</p>
      <router-link tag="button":to="{ name: 'EditCard', params: {cardID: $route.params.cardID} }" class="btn editCard"> Edit Card </router-link>
      <button class="btn deleteCard" v-on:click="deleteCard"> Delete Card </button> -->
    

    <div class="flashcard-back">
        <div class = 'box'>
          <!-- The button is not clickable.  clicking it turns the card around too.
          how is that fixable?  I tried moving stuff around and still couldn't get the
          mark for review button respond to just itself being clicked -->
          <section>
      <button id="review-button">Mark For Review</button> 
          </section>

<!-- The button will need to be moved, and also bound to some sort of logic or something
      which will put it in either an array for review, or just mark it as needed for review.
      Toggling the button between Mark for Review, and one that says "I KNOW THIS!" might work
      -->

      <!-- needs logic and might change anyways -->

          
          
      

      <h1>{{ flashcard.module }} / {{ flashcard.tag }}</h1>
      <p>A: {{flashcard.answer}}</p>
      <p>Created By:{{flashcard.creator}}</p>
      <p>Deck:{{flashcard.deck}}</p>

      
      
      

      
        </div>
    </div>

  </div>
</template>

<script>
import FlashCardService from '../services/FlashCardService';
export default {
  name: "flashcard",
  props: ["flashcard"],
  components: {},
  data() {
    return {
      deckName: this.$route.params.deckName,
      flipCard: false,
      // editCard: ??? and/or deleteCard: ???
      addFlashCard: {},
    };
  },
  methods: {
    removeCardFromDeck(id) {
      FlashCardService.removeCardFromDeck(id).then((response) => {
        if (response.status == 200) {
          console.log("Yay. Card was removed to deck");
        }
      })
    },
    addCardToDeck(cardId) {
      this.addFlashCard = {id: cardId, deck: this.deckName};

      FlashCardService.addCardToDeck(this.addFlashCard).then((response) => {
        if (response.status == 200) {
          console.log("Yay. Card was added to deck");
        }
      })
    }
  },

  // Added the methods of searching for cards (not done yet) and deleting cards. I used CardDetail.vue in Lecture Final from mod 3 POST to assist. 
//    methods: {
//     retrieveCard() {
//       boardsService
//         .getCard(this.$route.params.cardID)
//         .then(response => {
//           this.$store.commit("SET_CURRENT_CARD", response.data);
//           this.isLoading = false;
//         })
//         .catch(error => {
//           if (error.response && error.response.status === 404) {
//             alert(
//               "Something is not right... This card may have been deleted or you have entered an invalid card ID. Try again!"
//             );
//             this.$router.push("/");
//           }
//         });
//     },
//     deleteCard() {
//       if (
//         confirm(
//           "Are you sure you want to delete this card? Be warned this action cannot be undone."
//         )
//       ) {
//         boardsService
//           .deleteCard(this.card.id)
//           .then(response => {
//             if (response.status === 200) {
//               alert("Card successfully deleted");
//               this.$router.push(`/board/${this.card.boardId}`);
//             }
//           })
//           .catch(error => {
//             if (error.response) {
//               this.errorMsg =
//                 "Error deleting card. Response received was '" +
//                 error.response.statusText +
//                 "'.";
//             } else if (error.request) {
//               this.errorMsg =
//                 "Error deleting card. Server could not be reached.";
//             } else {
//               this.errorMsg =
//                 "Error deleting card. Request could not be created.";
//             }
//           });
//       }
//     },
//   },
//   created() {
//     this.retrieveCard();
//   },
//   computed: {
//     card() {
//       return this.$store.state.card;
//     }
//   }
};
</script>

<style>
.flashcard {
  /* border: 5px solid gold; */
  display: flex;
  justify-content:center;
  align-items: center;
  position: relative;
  width: 30%;
  height: 300px;
  transform-style:preserve-3d;
  transition: 250ms;
  /* background-color: rgb(212, 206, 206); */
  background-color: #00ADEE;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 0 5px 2px rgba(0, 0, 0, .3);
  transform: perspective(1000px) rotateY(var(--rotate-y, 0))
  translateY(var(--translate-y, 0));
}

.flashcard:hover {
  --translate-y: -2px;
  box-shadow: 0 0 5px 2px rgba(0, 0, 0, .6);
}


.flipped {
    --rotate-y: 180deg;
}

.flashcard .flashcard-front,
.flashcard .flashcard-back {
    position: absolute;
    padding: 1rem;
    backface-visibility: hidden;
    display:flex;
    text-align: center;
    flex-direction: column;
    justify-content: space-between;
}

.flashcard .flashcard-back {
    transform: rotateY(180deg);
}

#review-button {
   box-sizing: border-box;
    background-color: white;
    min-width: 100px;
    width: 20%;
    height: 35px;
    align-self: flex-end;
   
}

.edit-buttons {
  display: flex;
}

.box {
  display: flex;
  flex-direction: column;
}


</style>
