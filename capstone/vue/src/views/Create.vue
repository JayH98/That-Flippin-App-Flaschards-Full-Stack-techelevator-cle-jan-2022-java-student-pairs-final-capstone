<template>
<div class="home">
  <div id="create-deck">
    <h1>Create Deck</h1>
    <add-new-deck />
  </div>
    <div id="create-card"><h2> Create FlashCard </h2>
    <add-flash-card />
    </div>
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



#create-deck{
  position: relative;
  background-image: url('../assets/notecard.png');
  background-size:contain;  
  
  background-repeat: no-repeat;
  align-content: center;
  
}

#create-card{
  background-image: url('../assets/notecard.png');
  background-size: contain;
  background-repeat:no-repeat;
  align-content:center;
}

</style>