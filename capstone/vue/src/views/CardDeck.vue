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

    <div class = "tag-label">
    <label for="tagFilter">Tag: </label>
    <input type="text" id="tagFilter" v-model="filter.tag"/>
    </div>

    <div class = "question-label">
    <label for="questionFilter">Question: </label>
    <input type="text" id="questionFilter" v-model="filter.question"/>
    </div>

  <div class="flashcard-container">
      <flash-card v-bind:flashcard="flashcard" v-for="flashcard in filteredFlashCards" v-bind:key="flashcard.id"/>
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
        })
    },

    data() {
        return {
            deckName: '',
            flashcards: [],
             filter: {
                module: '',
                tag: '',
                creator: '',
                deck: ''
                 
            },
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
        }
    }

    // computed: {
    //     filteredCards() {
    //         let filteredCards = this.FlashCards;
    //         if (this.filter.Module != "") {
    //             filteredCards = filteredCards.filter(module => FlashCard.module.includes(this.filter.Module))
    //             }

    //         if (this.filter.Tag != "") {
    //             filteredCards = filteredCards.filter(tag => FlashCard.tag.includes(this.filter.Tag))
    //         }

    //         if (this.filter.Creator != "") {
    //             filteredCards = filteredCards.filter(creator => FlashCard.creator.includes(this.filter.Creator))
    //         }

    //         if (this.filter.Deck != "") {
    //             filteredCards = filteredCards.filter(deck => FlashCard.deck.includes(this.filter.Deck))
    //          }
    //         return filteredCards;
    // }
// }
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
}
</style>