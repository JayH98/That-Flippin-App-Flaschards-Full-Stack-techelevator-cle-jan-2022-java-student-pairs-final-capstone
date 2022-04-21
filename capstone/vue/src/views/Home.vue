<template>
  <div class="home">
    
    <div id="title">
    <h2>This Flippin' App <br/>
     Flashcards that T.E.A.C.H.<br/><span id="subtitle"> (Tech Elevator Acquiring Comprehension Helper)</span></h2>
   
    </div>

    

    <deck-list/>
    
  </div>
</template>

<script>
import DeckList from '../components/DeckList.vue';




export default {
  components: { DeckList},
  name: "home",

};
</script>

<style>

body {
  /* display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "header header"
  "title title"
  "deck deck"
  ;  */
  background-image: url('../assets/Woodstain.jpg');
  height: 100vh;
}

ul {
  display: flex;
}

.home {
  display: grid;
  align-items: center;
  background-position: center;
  background-size:auto;
  


}

h2, p, #beginStudy {
  padding-bottom: 10px;
  padding-left: 50px;
}

form {
  padding-left: 50px;
  padding-bottom: 50px;
}

#beginStudyBtn {
  padding: 5px;
  padding-left: 50px;
  width: 10%;
  padding: 5px;
  border-radius: 5px;
  color: #000000;
  background-color: #00afef;
  font-weight: bold;
  text-align: center;
  text-transform: uppercase;
}

#title {
  display:flex;
  justify-content: center;
  align-content: center;
  text-align: center;
  font-size: 2em;
  font-family:'Courier New', Courier, monospace;
  
  background-image: url('../assets/notecard.png');
  background-size: cover;
  font-weight: bolder;

  
  
}

#subtitle{
  font-size: .85em;
}




</style>
