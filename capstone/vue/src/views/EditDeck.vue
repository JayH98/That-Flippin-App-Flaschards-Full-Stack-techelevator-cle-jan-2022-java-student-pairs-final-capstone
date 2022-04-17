<template>
  <div>
    <h1>Edit Flashcard</h1>
    <update-deck v-bind:deckID="parseInt($route.params.id)"/>
  </div>
</template>

<script>
import UpdateDeck from '../components/UpdateDeck.vue';


export default {
    name: 'edit-deck',
    components: {
        UpdateDeck
    
  }
};
</script>

<style>
</style>