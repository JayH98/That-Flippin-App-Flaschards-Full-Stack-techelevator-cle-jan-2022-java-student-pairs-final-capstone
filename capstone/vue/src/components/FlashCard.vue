<template>
  <div class="flashcard">
    <div class="flashcard-front" v-bind:class="{'flipped': flipCard}" v-show="!flipCard" @click="flipCard = !flipCard">
      <h1>{{ flashcard.Module }} / {{ flashcard.tag }}</h1>

      <section>{{ flashcard.Question }}</section>

      <p>{{ flashcard.id }}</p>
      <!-- TE_Logo_right image above here or as object to go forward instead of "See Answer" -->

      <button type="button">See Answer</button>
    </div>

    <div class="flashcard-back" v-bind:class="{'flipped': !flipCard}" v-show="flipCard" @click="flipCard = !flipCard">
      <h1>{{ flashcard.Module }} / {{ flashcard.tag }}</h1>

      <p>{{flashcard.Answer}}</p>

      <p>{{flashcard.Creator}}</p>

      <button type="button" @click="flipCard = !flipCard">See Question</button>
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
  width: 30%;
  height: auto;
  margin-bottom: 10px;
  background-color: rgb(212, 206, 206);
  border-radius: 5px;
  box-shadow: 0 0 5px 2px rgba(0, 0, 0, .3);
  transform: rotateY(var(--rotate-y, 0));

}

.flipped {
    --rotate-y: 180deg;
}

</style>