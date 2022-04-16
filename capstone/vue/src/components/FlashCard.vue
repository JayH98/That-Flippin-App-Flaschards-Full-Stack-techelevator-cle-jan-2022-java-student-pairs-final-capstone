

<template>



  <div class="flashcard" @click="flipCard = !flipCard" v-bind:class="{'flipped': flipCard}">
    <div class="flashcard-front">
        <div class = 'box'>
          <section id='edit-flashcard-container'>
<router-link v-bind:to="{name: 'edit-flashcard', params: flashcard.id}">
        <button id="edit-flashcard">Edit </button></router-link>
          </section>
          <div id="search-container">
            Module: {{ flashcard.Module }} <br/>
             Tag: {{ flashcard.Tag }}
          </div>
      <section>
        <div id="question-box">
        Q: {{ flashcard.Question }} 
          </div>
          <div id="id">
          {{ flashcard.id }}
          </div>
        </section>
      
      
        </div>
    </div>

    <div class="flashcard-back">
        <div class = 'box'>
          

          <!-- The button is not clickable.  clicking it turns the card around too.
          how is that fixable?  I tried moving stuff around and still couldn't get the
          mark for review button respond to just itself being clicked -->
          <section>
      <button id="review-button" v-bind:to="{name: 'review-flashcard', params: flashcard.id}">Mark For Review</button> 
          </section>

<!-- The button will need to be moved, and also bound to some sort of logic or something
      which will put it in either an array for review, or just mark it as needed for review.
      Toggling the button between Mark for Review, and one that says "I KNOW THIS!" might work
      -->

      <!-- needs logic and might change anyways -->

          
          <!-- <div id="mod-back">
            Module: {{ flashcard.Module }} <br/>
             Tag: {{ flashcard.Tag }}
          </div> -->

      <div id="answer-block">
         A: {{flashcard.Answer}}
      </div>
      <section id="deck-box">
      <div id="creator">Created By:{{flashcard.Creator}} </div>

      <div id="deck">Deck:{{flashcard.Deck}}</div>
      </section>
      
      
      

      
        </div>
    </div>

  </div>
</template>

<script>


export default {
  name: "flashcard",
  props: ["flashcard"],
  components: {},
  data() {
    return {
      flipCard: false,
    };
  },
};
</script>

<style>
.flashcard {
  /* border: 5px solid gold; */
  display: flex;
  justify-content:center;
  align-items: center;
  position: relative;
  width: 30%;
  height: 300px;
  transform-style:preserve-3d;
  transition: 250ms;
  /* background-color: rgb(212, 206, 206); */
  background-color: #00ADEE;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 0 5px 2px rgba(0, 0, 0, .3);
  transform: perspective(1000px) rotateY(var(--rotate-y, 0))
  translateY(var(--translate-y, 0));
}

.flashcard:hover {
  --translate-y: -2px;
  box-shadow: 0 0 5px 2px rgba(0, 0, 0, .6);
}


.flipped {
    --rotate-y: 180deg;
}

.flashcard .flashcard-front,
.flashcard .flashcard-back {
    position: absolute;
    padding: 1rem;
    backface-visibility: hidden;
    display:flex;
    text-align: center;
    flex-direction: column;
    justify-content: space-between;
}

.flashcard .flashcard-back {
    transform: rotateY(180deg);
}

#review-button {
box-sizing: border-box;
margin: right 60%;;
    background-color: white;
    min-width: 100px;
    width: 20%;
    height: 35px;
    align-self: flex-end;
    border-radius:25px;
    block-size: fit-content;
    width:fit-content;
    position: relative;
    top: -75px;

   
    
    
    
    
  /* position: fixed;
  top:-45%;
  left:70%;
  block-size: fit-content;
  width: fit-content; */
  /* won't properly sit in the right corner like edit-flashcard would */
   
}

#edit-flashcard {
box-sizing: border-box;
margin: right 60%;;
    background-color: white;
    min-width: 100px;
    width: 20%;
    height: 35px;
    align-self: flex-end;
    border-radius:25px;
  position: fixed;
  top:5%;
  right:5%;
  block-size: fit-content;
  width: fit-content;

}

#edit-flashcard-container {
  justify-content: center;
  align-content: center;

}

#question-box {
  background: white;
border-radius: 10px;
border:black, solid;
border-style: inset;
font-size: 20px;

}

#mod {font-size: small;}

#tag {font-size: small;}


#mod-back {font-size: medium;}
#question {font-size: large;}

#answer-block {
background: white;
border-radius: 10px;
border:black, solid;
border-style: inset;
font-size: 20px;


}

#search-container {
  background: white;
border-radius: 10px;
border:black, solid;
border-style:ridge;
font-size: 12px;
width:fit-content;
block-size:fit-content;
position: fixed;
top: 5%;
left: 5%;
  
}

 #creator {
  block-size:fit-content;
  width:fit-content;
  font-size: small;
  position:fixed;
  left: 15%;
  bottom: -100%;
  
 }


#deck {
  
  font-size: small;
 block-size:fit-content;
  width:fit-content;
  font-size: small;
position: fixed;
bottom: -120%;
left: 15%;
border:none; 


}
/* #deck-box {
   block-size:fit-content;
  width:fit-content;
  font-size: small;
position: fixed;
bottom: 50%;
left: 95%;
border:none;
} */


/* #creator {
  block-size:fit-content;
  font-size: small;
position: fixed;
bottom: 50%;
left: 95%;
border:none;
transform:rotate(.25turn);
} */
/* Rotates to the edge of the some cards but not others */


#id {position: fixed;
bottom: 5%;
right: 5%;
border:none;
}

#mod-back {
background: white;
border-radius: 10px;
border:black, solid;
border-style:ridge;
font-size: 12px;
width:fit-content;
block-size:fit-content;
position: fixed;
top: 5%;
left: 5%;

}

</style>