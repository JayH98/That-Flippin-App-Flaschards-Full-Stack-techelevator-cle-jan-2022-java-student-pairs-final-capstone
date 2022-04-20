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

    <router-link v-bind:to="{name: 'marked-review', params: {markedReview: this.flashcardsForReview}}"><button class = "review-label">Review Marked Cards</button></router-link>
    </nav>

  <div class="flashcard-container">
      <flash-card v-bind:flashcard="flashcard" v-for="flashcard in filteredFlashCards" v-bind:key="flashcard.id" @markForReview="addForReview"/>
  </div>
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
            this.flashcardsForReview.unshift(flashcard);
            console.log(flashcard.module);
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
</style>