<template>
<div>
    <add-new-deck />
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