<template>
  <div class = "deck">
      <h1>{{deck.Name}} Deck</h1>

       <div class = "te-logo">
      <img id = "te-logo" src = '../assets/TE_Logo.png' v-if="deck.Creator=='Tech Elevator'">
      </div>
      
      <!-- want to toggle the image so it only shows when tech elevator is the creator -->


      <section>Created by: {{deck.Creator}}</section>
        
     <router-link id="router-link" v-bind:to="{ name: 'card-deck', params: deck.id }"> 
         
         <button type="button" class = "study-button">
             
             Begin Study Session
             
             </button>
         
         </router-link>
      
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
    align-items: center;
    justify-content: center;
    background: rgb(0,111,121);
    /* background: linear-gradient(90deg, rgba(0,111,121,1) 0%, rgba(0,157,183,1) 45%, rgba(0,212,255,1) 100%); */
    background: linear-gradient(90deg, #71d96f 0%, rgba(0,212,255,1) 100%);
    border:inset;
    border-radius: 25px;
    width: 30%;
}

.deck > h1, .deck section {
    font-family: Arial, Arial, Helvetica, sans-serif;

    color: rgb(2, 2, 2);
}

.study-button {

    margin-right:50px;
    align-items: center;
    min-width: 100%;
    width: 95%;
    height: 35px;
    border-radius:25px; 
    background: linear-gradient(90deg, rgba(0,212,255,1) 0%, #71d96f 100%);
}

#router-link{
    display: inline-block;
    margin-right:50px;
    width:50%;
    align-items: center;
    
}

#te-logo{
    align-items:center;
   width: 50%;
   height: 50%;
    height: auto;
}


</style>