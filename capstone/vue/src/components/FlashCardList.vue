<template>
  <div class="flashcard-container">
      <flash-card v-bind:flashcard="flashcard" v-for="flashcard in flashcards" v-bind:key="flashcard.id"/>
  </div>
</template>

<script>
import FlashCard from '@/components/FlashCard.vue'
import FlashCardService from '@/services/FlashCardService.js'

export default {
    name: 'flashcard-list',
    components: {
        FlashCard
        
    },
    created() {
        FlashCardService.getAllCards(this.$store.state.user.username).then((response) => {
            this.flashcards = response.data;
        });
        this.flashcards.forEach((flashcard) => {
            // const markForReview = 'markForReview';
            // flashcard[markForReview] = false;

            Object.assign(flashcard, {markForReview: false})
        });
    },

    data() {
        return {
            filter: {
                Module: '',
                Tag: '',
                Creator: '',
                Deck: ''
                 
            },
            flashcards: []
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