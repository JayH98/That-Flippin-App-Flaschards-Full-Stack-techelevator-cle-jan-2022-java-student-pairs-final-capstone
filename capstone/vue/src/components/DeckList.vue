<template>
  <div class="deck-container" v-show='$store.state.decks.length > 0'>
      <deck v-bind:deck="deck" v-for="deck in $store.state.decks" v-bind:key="deck.Name"/>
  </div>
</template>

<script>
import Deck from './Deck.vue'

export default {
    name: 'flashcard-list',
    components: {
        Deck   
    }
}
</script>

<style>
.deck-container {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    row-gap: 10px;
    border: 5px solid royalblue;
}
</style>