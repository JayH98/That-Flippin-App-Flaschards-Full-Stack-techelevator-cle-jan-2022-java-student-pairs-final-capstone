<template>
  <div class="deck-container" v-show='$store.state.deck.length > 0'>
      <deck v-bind:deck="deck" v-for="deck in $store.state.deck" v-bind:key="deck.Name"/>
      <h2> {{deck.Name}} </h2>
      <p> {{deck.Creator}} </p>
  </div>
</template>

<script>
import Deck from './Deck.vue'

export default {
    name: 'deck-list',
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