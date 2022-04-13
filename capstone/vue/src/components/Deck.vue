<template>
  <div class = "Deck">
      <h1>{{deck.Name}}</h1>
      
      <section>Created by:{{deck.Creator}}</section>
        
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