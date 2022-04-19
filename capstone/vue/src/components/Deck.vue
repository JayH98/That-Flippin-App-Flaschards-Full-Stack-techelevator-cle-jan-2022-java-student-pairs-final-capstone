<template>
  <div class = "deck">
      <h1>{{deck.deck}}</h1>

      <img id="te-logo" src = "../assets/TE_Logo.png"/>
      
      <section>Created by: {{deck.username}}</section>

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
    /* background: rgb(0,111,121); */
    /* background: linear-gradient(90deg, rgba(0,111,121,1) 0%, rgba(0,157,183,1) 45%, rgba(0,212,255,1) 100%); */
    background: linear-gradient(90deg, #71d96f 0%, rgba(0,212,255,1) 100%);
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
/* background: linear-gradient(90deg, rgba(0,212,255,1) 100%, #71d96f 0%, ); */
background: radial-gradient(white, #71D96F);
transform:rotate(1turn);

}

.edit:hover {
    transition: 25s;
    background: radial-gradient(white, rgba(0,212,255,1));
    transform:skewY(5deg);
}

#te-logo{
    width: 50%;
    height: 50%;
    height: auto;
}


</style>