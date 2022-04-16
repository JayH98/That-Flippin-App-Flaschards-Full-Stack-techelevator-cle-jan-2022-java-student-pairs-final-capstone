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
  <div class="flashcard-container">
      <flash-card v-bind:flashcard="flashcard" v-for="flashcard in flashcards" v-bind:key="flashcard.id"/>
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
            filter: {
                Module: '',
                Tag: '',
                Creator: '',
                Deck: ''
                 
            },
            flashcards: [],
            deckName: ''
        }
    },

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
</style>