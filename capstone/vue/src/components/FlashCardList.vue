<template>
  <div class="flashcard-container">
      <flash-card v-bind:flashcard="flashcard" v-for="flashcard in flashCardList" v-bind:key="flashcard.id" @refreshFlashCardList="refreshFlashCardList()"/>
  </div>
</template>

<script>
import FlashCard from '@/components/FlashCard.vue'
// import FlashCardService from '@/services/FlashCardService.js'

export default {
    name: 'flashcard-list',
    components: {
        FlashCard
        
    },
    props: ["flashCardList"],
    // created() {
    //     FlashCardService.getAllCards(this.$store.state.user.username).then((response) => {
    //         this.flashcards = response.data;
    //     });
    //     this.flashcards.forEach((flashcard) => {
    //         // const markForReview = 'markForReview';
    //         // flashcard[markForReview] = false;

    //         Object.assign(flashcard, {markForReview: false})
    //     });
    // },
    methods: {
        refreshFlashCardList() {
            this.$emit('refreshFlashCardList');
        }
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