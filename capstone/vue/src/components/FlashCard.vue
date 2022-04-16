<template>


  <div class="flashcard" @click="flipCard = !flipCard" v-bind:class="{'flipped': flipCard}">
    <div class="flashcard-front">
        <div class = 'box'>
      <h1>{{ flashcard.module }} / {{ flashcard.tag }}</h1>
      <section>Q: {{ flashcard.question }}</section>
      <p>ID: {{ flashcard.id }}</p>
      <router-link v-bind:to="{name: 'edit-flashcard', params: { id: flashcard.id }}"><button>Edit Flashcard</button></router-link>
        </div>
    </div>

    <div class="flashcard-back">
        <div class = 'box'>
          

          <!-- The button is not clickable.  clicking it turns the card around too.
          how is that fixable?  I tried moving stuff around and still couldn't get the
          mark for review button respond to just itself being clicked -->
          <section>
      <button id="review-button">Mark For Review</button> 
          </section>

<!-- The button will need to be moved, and also bound to some sort of logic or something
      which will put it in either an array for review, or just mark it as needed for review.
      Toggling the button between Mark for Review, and one that says "I KNOW THIS!" might work
      -->

      <!-- needs logic and might change anyways -->

          
          
      

      <h1>{{ flashcard.module }} / {{ flashcard.tag }}</h1>
      <p>A: {{flashcard.answer}}</p>
      <p>Created By:{{flashcard.creator}}</p>
      <p>Deck:{{flashcard.deck}}</p>

      
      
      

      
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
    background-color: white;
    min-width: 100px;
    width: 20%;
    height: 35px;
    align-self: flex-end;
   
}



</style>