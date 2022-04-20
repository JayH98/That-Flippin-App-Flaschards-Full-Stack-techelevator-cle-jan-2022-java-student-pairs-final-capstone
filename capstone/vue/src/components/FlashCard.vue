<template>


  <div class="flashcard" @dblclick="flipCard = !flipCard" v-bind:class="{'flipped': flipCard, 'markForReview': markForReview}">
    <div class="flashcard-front">
        <div class = 'box'>
      <!-- <h1>{{ flashcard.module }} / {{ flashcard.tag }}</h1>
      <section>Q: {{ flashcard.question }}</section>
      <p>ID: {{ flashcard.id }}</p>
      <router-link v-bind:to="{name: 'edit-flashcard', params: { id: flashcard.id }}"><button>Edit Flashcard</button></router-link>
      <div class = "edit-buttons">
        <button v-show="this.$route.name ===  'edit-deck'" v-if="flashcard.deck !== this.$route.params.deckName" @click="addCardToDeck(flashcard.id)">Add to deck</button>
        <button v-show="this.$route.name === 'edit-deck'" @click="removeCardFromDeck(flashcard.id)" v-if="flashcard.deck === this.$route.params.deckName">Remove from deck</button> -->
      <section id='edit-flashcard-container'>
       <router-link v-bind:to="{name: 'edit-flashcard', params: { id: flashcard.id }}"><button>Edit Flashcard</button></router-link>
 <div class = "edit-buttons">
        <button v-show="this.$route.name ===  'edit-deck'" v-if="flashcard.deck !== this.$route.params.deckName" @click="addCardToDeck(flashcard.id)">Add to deck</button>
        <button v-show="this.$route.name === 'edit-deck'" @click="removeCardFromDeck(flashcard.id)" v-if="flashcard.deck === this.$route.params.deckName">Remove from deck</button> 
 </div>
      </section>
      <section>
        <div id="question-box">
          Q: {{flashcard.question}}
        </div>
        <div id="id">
          {{flashcard.id}}
        </div>
      </section>
      
      
      </div>
        </div>
   

    

    <div class="flashcard-back">
        <div class = 'box'>
          <!-- The button is not clickable.  clicking it turns the card around too.
          how is that fixable?  I tried moving stuff around and still couldn't get the
          mark for review button respond to just itself being clicked -->
          <section>
          <!-- <input type="checkbox" v-on:click="changeReviewStatus($event, flashcard.id)"/> -->
            <button id="review-button" @click='changeReviewStatus(flashcard)'>Mark For Review</button>
          </section>

<!-- The button will need to be moved, and also bound to some sort of logic or something
      which will put it in either an array for review, or just mark it as needed for review.
      Toggling the button between Mark for Review, and one that says "I KNOW THIS!" might work
      -->

      <!-- needs logic and might change anyways -->

          
          
      

      <!-- <h1>{{ flashcard.module }} / {{ flashcard.tag }}</h1>
      <p>A: {{flashcard.answer}}</p>
      <p>Created By:{{flashcard.creator}}</p>
      <p>Deck:{{flashcard.deck}}</p> -->

      <div id="answer-block">
         A: {{flashcard.answer}}
      </div>
      <section id="deck-box">
      <div id="creator">Created By:{{flashcard.creator}} </div>
      
      
      <div id="deck">Deck:{{flashcard.deck}}</div>
      </section>

      
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
      markForReview: false,
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
    },
    changeReviewStatus(flashcard) {
      // this.markForReview = !this.markForReview;

      // if (event.target.parentElement.parentElement.parentElement.parentElement.classList.contains("markForReview")) {
      //   event.target.parentElement.parentElement.parentElement.parentElement.classList.add("test");
      //   console.log("Made it into method")
      // }
      this.markForReview = !this.markForReview;
      this.$emit('markForReview', flashcard);
      console.log(flashcard.question);
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
  /* height: 20%; */
  height: 25rem;
  transform-style:preserve-3d;
  transition: 250ms;
  /* background-color: rgb(212, 206, 206); */
  /* background-color: #00ADEE; */
  background-image: url('../assets/parchment.jpg');
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
   margin: right 60%;
    background-color: white;
    min-width: 100px;
    width: 20%;
    height: 35px;
    align-self: flex-end;
    border-radius: 25px;
    block-size: fit-content;
    width: fit-content;
    position: relative;
    top: -75px;
   
}

#edit-flashcard{
  box-sizing: border-box;
margin: right 60%;;
    background-color: white;
    min-width: 100px;
    width: 20%;
    height: 35px;
    align-self: flex-end;
    border-radius:25px;
  position: fixed;
  top:5%;
  right:5%;
  block-size: fit-content;
  width: fit-content;
}

#edit-flashcard-container {
  justify-content: center;
  align-content: center;

}


#question-box {
  background: white;
border-radius: 10px;
border:black, solid;
border-style: inset;
font-size: 20px;
}

#mod {font-size: small;}

#tag {font-size: small;}

#mod-back {font-size: medium;}
#question {font-size: large;}


.edit-buttons {
  display: flex;
}

#answer-block {
background: white;
border-radius: 10px;
border:black, solid;
border-style: inset;
font-size: 20px;
}

#search-container {
  background: white;
border-radius: 10px;
border:black, solid;
border-style:ridge;
font-size: 12px;
width:fit-content;
block-size:fit-content;
position: fixed;
top: 5%;
left: 5%;
  
}

 #creator {
  block-size:fit-content;
  width:fit-content;
  font-size: small;
  position:fixed;
  left: 15%;
  bottom: -100%;
  
 }

#deck {
  
  font-size: small;
 block-size:fit-content;
  width:fit-content;
  font-size: small;
position: fixed;
bottom: -120%;
left: 15%;
border:none; 
}

#id {position: fixed;
bottom: 5%;
right: 5%;
border:none;
}

#mod-back {
background: white;
border-radius: 10px;
border:black, solid;
border-style:ridge;
font-size: 12px;
width:fit-content;
block-size:fit-content;
position: fixed;
top: 5%;
left: 5%;

}


.box {
  display: flex;
  flex-direction: column;
}

.markForReview {
  background-color: mediumaquamarine;
}

.test {
  color:oldlace;
}
</style>
