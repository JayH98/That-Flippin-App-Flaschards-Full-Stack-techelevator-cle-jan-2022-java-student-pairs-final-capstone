<template>
  <div class="flashcard-container">
      <flash-card v-bind:flashcard="flashcard" v-for="flashcard in $store.state.flashcards" v-bind:key="flashcard.id"/>
  </div>
</template>

<script>
import FlashCard from '@/components/FlashCard.vue'

export default {
    name: 'flashcard-list',
    components: {
        FlashCard
        
    }
}
</script>

<style>
.flashcard-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    border: 5px solid brown;
}
</style>