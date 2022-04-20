<template>
    <div class="review-flashcard-container">
      <flash-card v-bind:flashcard="flashcard" v-for="flashcard in reviewFlashcards" v-bind:key="flashcard.id" @markForReview="addForReview"/>
  </div>
</template>



<script>
import FlashCard from '@/components/FlashCard.vue'

export default ({

    components: {FlashCard},
    data() {
        return {
            reviewFlashcards: this.$route.params.markedReview,
        }
    }
})
</script>

<style>
.review-flashcard-container {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    row-gap: 10px;
}


</style>