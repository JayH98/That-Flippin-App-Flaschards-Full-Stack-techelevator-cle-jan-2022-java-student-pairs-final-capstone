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