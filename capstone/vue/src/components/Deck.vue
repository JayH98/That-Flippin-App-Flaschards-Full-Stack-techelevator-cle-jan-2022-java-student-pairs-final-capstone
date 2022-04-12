


<template>
  <div class = "Deck">
      <h1>{{Deck.name}}</h1>
      
      <section>Created by:{{Deck.creator}}</section>
        
      <button type="button">Study This Deck</button>
      
  </div>


</template>

<script>


export default {
    name: 'deck',
    props: ['deck'],
    components: {
        
    }
}
// eslint-disable-next-line vue/comment-directive
</script>

<style>
.deck-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}



</style>