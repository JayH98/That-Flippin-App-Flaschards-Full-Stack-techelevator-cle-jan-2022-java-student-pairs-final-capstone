<template>


  <div class="flashcard" @dblclick="flipCard = !flipCard" v-bind:class="{'flipped': flipCard, 'markForReview': markForReview}">
    <div class="flashcard-front">
        <div class = 'box'>
      <section id='edit-flashcard-container'>
       <router-link v-bind:to="{name: 'edit-flashcard', params: { id: flashcard.id }}"><button id="edit-button">Edit Flashcard</button></router-link>
 <div class = "edit-buttons">
        <!-- <button v-show="this.$route.name ===  'edit-deck'" v-if="flashcard.deck !== this.$route.params.deckName" @click="addCardToDeck(flashcard.id)">Add to deck</button>
        <button v-show="this.$route.name === 'edit-deck'" @click="removeCardFromDeck(flashcard.id)" v-if="flashcard.deck === this.$route.params.deckName">Remove from deck</button>  -->
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
          <section>
            <button id="review-button" @click='changeReviewStatus(flashcard)'>Mark For Review</button>
          </section>

      <div id="answer-block">
         A: {{flashcard.answer}}
      </div>
      <section id="deck-box">
      <div>Created By:{{flashcard.creator}} </div>
      <div >Deck:{{flashcard.deck}}</div>
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
      this.markForReview = !this.markForReview;
      this.$emit('markForReview', flashcard);
      console.log(flashcard.question);
    }
  },


};
</script>

<style>
.flashcard {
  display: flex;
  justify-content:center;
  align-items: center;
  position: relative;
  width: 30%;
  height: 25rem;
  transform-style:preserve-3d;
  transition: 250ms;
  background-image: url('../assets/parchment.jpg');
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 0 5px 2px rgba(4, 132, 236, 0.3);
  transform: perspective(1000px) rotateY(var(--rotate-y, 0))
  translateY(var(--translate-y, 0));
}

.flashcard:hover {
  --translate-y: -5px;
  box-shadow: 0 0 5px 2px rgba(4, 132, 236, .6);
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

#review-button:hover {
 transform: translateY(-5px);
  transition: .25s;
  background: radial-gradient(#00ADEE, #71D96F);
  cursor:url('../assets/pointer.png'), pointer;
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

#edit-button {
  border-radius: 15px;
  box-sizing: border-box;
   margin: right 60%;
    background-color: white;
    min-width: 100px;
    width: 20%;
    height: 35px;
    block-size: fit-content;
    width: fit-content;
    position: relative;
    top: -80px;
}

#edit-button:hover {
  transform: translateY(-5px);
  transition: .25s;
  background: radial-gradient(#00ADEE, #71D96F);
  cursor:url('../assets/pointer_tilted.png'), pointer;
}

#deck-box {
justify-content:flex-end;

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
  font-family:'Courier New', Courier, monospace;
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
   font-family:'Courier New', Courier, monospace;
  block-size:fit-content;
  width:fit-content;
  font-size: small;
  position:fixed;
  left: 15%;
  bottom: -100%;
  
 }

#deck {
  font-family:'Courier New', Courier, monospace;
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
font-family:'Courier New', Courier, monospace;
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
  /* background-image: url(''); */
  background-color: #71D96F;
}

.test {
  color:oldlace;
}
</style>
