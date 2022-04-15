<template>
<div>
  <h1>Edit Deck</h1>
<form>
      <input  list="decks" placeholder="Select Deck" multiple/>
    <datalist id="decks">
      <option value="Tech Elevator"/>
      <option value="HAHA JK"/>
    
    <!-- I couldn't find a way to let you open the dropdown again after you selected something
    will need to look for a way if possible unless we move to a different style -->
    
    </datalist>
</form>
     <edit-deck/>
    <h2>Edit Card</h2>
    <form>
      <input  list="cards" placeholder="Select Card" multiple/>
    <datalist id="cards">
      <option value="PSYCH! Under Construction"/>
    </datalist>
</form>
    <edit-flash-card/>
</div>
</template>

<script>
import EditDeck from '../components/EditDeck.vue';
import EditFlashCard from '../components/EditFlashCard.vue';


export default {
  components: {EditDeck, EditFlashCard},
name: "edit"
};
</script>
   

<style>

</style>