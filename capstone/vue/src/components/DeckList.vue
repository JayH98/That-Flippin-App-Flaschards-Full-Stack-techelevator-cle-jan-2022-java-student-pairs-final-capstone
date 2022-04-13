<template>
  <div class="deck-container" v-show="$store.state.decks.length > 0">
      <deck v-bind:deck="deck" v-for="deck in $store.state.decks" v-bind:key="deck.Name"/>
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
    /* background: rgb(0,111,121);
    background: linear-gradient(90deg, rgba(0,111,121,1) 0%, rgba(0,157,183,1) 45%, rgba(0,212,255,1) 100%);
    border: 5px solid royalblue; */
}
</style>