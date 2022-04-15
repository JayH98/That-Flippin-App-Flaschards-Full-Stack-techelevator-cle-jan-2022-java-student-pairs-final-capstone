<template>
  <div class="flashcard" @click="flipCard = !flipCard" v-bind:class="{'flipped': flipCard}">
    <div class="flashcard-front">
        <div class = 'box'>
      <h1>{{ flashcard.Module }} / {{ flashcard.Tag }}</h1>
      <section>Q: {{ flashcard.Question }}</section>
      <p>ID: {{ flashcard.id }}</p>
      <!-- TE_Logo_right image above here or as object to go forward instead of "See Answer" -->
      <!-- <button type="button">See Answer</button> -->
        </div>
    </div>

    <div class="flashcard-back">
        <div class = 'box'>
          
      <h1>{{ flashcard.Module }} / {{ flashcard.Tag }}</h1>
      <p>A: {{flashcard.Answer}}</p>
      <p>Created By:{{flashcard.Creator}}</p>
      <p>Deck:{{flashcard.Deck}}</p>
      <!-- <button type="button">See Question</button> -->
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
    flex-direction: column;
    justify-content: space-between;
}

.flashcard .flashcard-back {
    transform: rotateY(180deg);
}



</style>