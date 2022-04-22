<template>
<div class="home">
  <div id="create-deck">
    <h1 style="color:black">Create Deck</h1>
    <add-new-deck />
  </div>
    <div id="create-card"><h2 style="color:black"> Create FlashCard </h2>
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


.home {
  justify-content:center;
  
  
 
}
#create-deck{
  text-align: center;
  position: relative;
  background-image: url('../assets/notecard.png');
  background-size:100%;  
  justify-content: center;
  background-repeat: no-repeat;
  align-content: center;
  width: 150%;
  font-family: 'Courier New', Courier, monospace;

}

#create-card{
  text-align: center;
  background-image: url('../assets/notecard.png');
  background-size:cover;
  background-repeat:no-repeat;
  align-content:center;
  width:150%;
  font-family: 'Courier New', Courier, monospace;
  
}

.h1{
  font-size: xx-large;
  
}

.h2{
  font: xx-large;
}
</style>