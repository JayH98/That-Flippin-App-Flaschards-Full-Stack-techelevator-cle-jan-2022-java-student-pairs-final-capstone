<template>
  <div>
    <h1>Edit Flashcard</h1>
    <update-deck v-bind:deckName="$route.params.deckName"/>
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