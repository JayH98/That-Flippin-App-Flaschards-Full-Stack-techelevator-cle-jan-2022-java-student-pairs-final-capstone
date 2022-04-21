<template>
  <div class="deck-container" v-show="decks.length > 0">
      <deck v-bind:deck="deck" v-for="deck in decks" v-bind:key="deck.Name"/>
  </div>
</template>

<script>
import Deck from './Deck.vue'
import DeckService from '@/services/DeckService.js'


export default {
    name: 'deck-list',
    data() {
        return {
            decks: []
        }
    },
    created() {
        DeckService.getAllDecks(this.$store.state.user.username).then((response) => {
            this.decks = response.data;
        })
    },
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
    
}
</style>