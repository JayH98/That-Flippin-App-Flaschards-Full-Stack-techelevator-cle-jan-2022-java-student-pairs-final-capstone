<!-- <template>
<div>
  <h2>Hello World</h2>
  <flash-card-list/>
</div>

</template>

<script>
import FlashCardList from '../components/FlashCardList.vue'
export default {
  components: { FlashCardList },

}
</script>

<style>

</style>
-->


<template>
<div>
    <h1>Current deck: {{deckName}}</h1>

<nav class = "filter">

    <div class = "tag-label">
    <label for="tagFilter">Tag: </label>
    <input type="text" id="tagFilter" v-model="filter.tag"/>
    </div>

    <div class = "question-label">
    <label for="questionFilter">Question: </label>
    <input type="text" id="questionFilter" v-model="filter.question"/>
    </div>

    <button class = "reviewButton" @click="showReviewCards = !showReviewCards">{{showReviewCards ? 'Review All Cards' : 'Review Marked Cards'}}</button>

    <button class = "completeStudySessionBtn" @click="studySessionComplete = !studySessionComplete">{{studySessionComplete ? 'Study Deck Again' : 'Complete Study Session'}}</button>
    </nav>

  <div class="flashcard-container" v-show="!showReviewCards && !studySessionComplete">
      <flash-card v-bind:flashcard="flashcard" v-for="flashcard in filteredFlashCards" v-bind:key="flashcard.id" @markForReview="addForReview"/>
  </div>
  <div class="flashcard-container" v-show="showReviewCards">
      <flash-card v-bind:flashcard="flashcard" v-for="flashcard in flashcardsForReview" v-bind:key="flashcard.id"/>
  </div>
  <h2 v-show="studySessionComplete">Study session complete! You got {{flashcardsForReview.length}} wrong out of {{filteredFlashCards.length}}</h2>
  <button class = "completeStudySessionBtn" @click="studySessionComplete = !studySessionComplete">{{studySessionComplete ? 'Study Deck Again' : 'Complete Study Session'}}</button>
</div>
</template>

<script>
import FlashCard from '@/components/FlashCard.vue'
import DeckService from '@/services/DeckService.js'

export default {
    name: 'flashcard-list',
    components: {FlashCard},
    created() {
        DeckService.getCardsInDeck(this.$route.params.deckName).then((response) => {
            this.flashcards = response.data;
            this.deckName = this.$route.params.deckName;

            this.flashcards.forEach((flashcard) => {
            // const markForReview = 'markForReview';
            // flashcard[markForReview] = false;

            Object.assign(flashcard, {markForReview: false})

        });
            
        
        });
    },

    data() {
        return {
            deckName: '',
            flashcards: [],
            flashcardsForReview: [],
            showReviewCards: false,
            studySessionComplete: false,
             filter: {
                module: '',
                tag: '',
                creator: '',
                deck: ''
                 
            },
        }
    },
    methods: {
        addForReview(flashcard) {
            if (this.flashcardsForReview.includes(flashcard)) {
                let indexOfFlashcard = this.flashcardsForReview.indexOf(flashcard);
                this.flashcardsForReview.splice(indexOfFlashcard, 1);
            }
            else {
            this.flashcardsForReview.unshift(flashcard);
            console.log(flashcard.module);
            }
        }
    },
    computed: {
        filteredFlashCards() {
           return this.flashcards.filter((flashcard) => {
               if (this.filter.tag  && !flashcard.tag.toLowerCase().includes(this.filter.tag.toLowerCase())) {
                   return false;
               }
               if (this.filter.question  && !flashcard.question.toLowerCase().includes(this.filter.question.toLowerCase())) {
                   return false;
               }
               return true;
           })
        },
        
        }
    }



</script>

<style>
.flashcard-container {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    row-gap: 10px;
}

.tag-label {
    margin-bottom: 20px;
    font-size: large;
    font-family: fantasy;
    color: #556268;
}

.question-label {
    font-size: large;
    font-family:fantasy;
    color:#556268;
    


}

.filter {
    display: flex;
    justify-content: space-evenly;
}

h2 {
    color: #00ADEE;
}

.completeStudySessionBtn, .reviewButton {
/* background-color: #00ADEE; */
  border-radius: 5px;
  min-height: 30px;
  min-width: 130px;
  /* background-image: url('./assets/notecard.png');
  background-repeat:no-repeat;
  background-size:cover; */
  background-image: url('../assets/parchment.jpg');
}

.completeStudySessionBtn:hover, .reviewButton:hover {
  transform: translateY(-10px);
  transition: .25s;
  background: radial-gradient(#00ADEE, #71D96F);
}
</style>