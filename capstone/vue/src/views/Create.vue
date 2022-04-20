<template>
<div class="home">
    <h1> Create Deck</h1>
    <add-new-deck />
    <h2> Create FlashCard </h2>
    <add-flash-card />
</div>
</template>

<script>
import AddFlashCard from '../components/AddFlashCard.vue';
import AddNewDeck from '../components/AddNewDeck.vue'

export default {
  components: { AddNewDeck, AddFlashCard },
name: "create-deck"
};
</script>
   

<style>
</style>