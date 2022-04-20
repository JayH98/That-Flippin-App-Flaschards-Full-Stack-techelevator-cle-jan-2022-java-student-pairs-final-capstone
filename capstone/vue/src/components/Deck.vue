<template>
  <div class = "deck">
      <h1 id="deck-name">{{deck.deck}}</h1>

      <img id="te-logo" v-if="deck.deck == 'Tech Elevator - Default'" src = "../assets/TE_Logo.png"/>
      
      <section id="creator-box">Created By: {{deck.username}}</section>

    <div class = "deck-buttons">
        <router-link v-bind:to="{ name: 'edit-deck', params: {deckName: deck.deck} }"> <button type="button" class = "edit">Edit Deck</button></router-link>
        <router-link v-bind:to="{ name: 'card-deck', params: {deckName: deck.deck} }"> <button type="button" class = "study-button">Begin Study Session</button></router-link>
    </div>
      
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
    align-items:center;
    justify-content: center;
    background-image: url('../assets/parchment.jpg');
    border:inset;
    border-radius: 25px;

    border: 5px solid royalblue;
    width: 30%;
}

.deck > h1, .deck section {
    font-family: Arial, Arial, Helvetica, sans-serif;

    color: rgb(2, 2, 2);
}

.deck-buttons {
    display: flex;
    justify-content: space-between;
    width: 100%;
}

.study-button, .edit {
    box-sizing: border-box;
    background-color: white;
    min-width: 100px;
    width: 20%;
    height: 35px;
    border-radius: 15px;
    border-style: groove;
}

.study-button:hover {
transition:1.8s;
background: radial-gradient(white, #71D96F);
transform:skewX(-15deg);
cursor:url('../assets/pointer.png'), pointer;
}

.edit:hover {
    transition: 1s;
    background: radial-gradient(white, rgba(0,212,255,1));
    transform:scale(1.15);
    cursor:url('../assets/pointer.png'), pointer;
}

#te-logo {
    width: 60%;
    height: auto;
    border-radius: 15px;
}

#deck-name{
    font-family:'Courier New', Courier, monospace;
    text-align: center;
}

#creator-box{
    font-size:large;
    font-family:'Courier New', Courier, monospace;
}



</style>