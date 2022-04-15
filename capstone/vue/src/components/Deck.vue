<template>
  <div class = "deck">
      <h1>{{deck.Name}}</h1>
      
      <section>Created by: {{deck.Creator}}</section>
        
     <router-link v-bind:to="{ name: 'card-deck', params: deck.id }"> <button type="button" class = "study-button">Begin Study Session</button></router-link>
      
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
.deck {
    display: flex;
    text-align: center;
    flex-direction: column;
    justify-content: center;
    background: rgb(0,111,121);
    background: linear-gradient(90deg, rgba(0,111,121,1) 0%, rgba(0,157,183,1) 45%, rgba(0,212,255,1) 100%);
    border: 5px solid royalblue;
    width: 30%;
}

.deck > h1, .deck section {
    font-family: Arial, Arial, Helvetica, sans-serif;

    color: rgb(2, 2, 2);
}

.study-button {
    box-sizing: border-box;
    background-color: white;
    min-width: 100px;
    width: 20%;
    height: 35px;
    align-self: flex-end;
}



</style>