<template>
  <div class = "flashcard" @click="flipCard=!flipCard">
      <h1>{{flashcard.module}} / {{flashcard.tag}}</h1>
      
      <section>{{flashcard.question}}</section>

      <p>{{flashcard.id}}</p>
        <!-- TE_Logo_right image above here or as object to go forward instead of "See Answer" -->
        
      <button type="button">See Answer</button>
      
  </div>
</template>

<script>


export default {
    name: 'flashcard',
    props: ['flashcard'],
    components: {
        
    },
    data() {
        return {
            flipCard: false,
        }
    }
}
</script>

<style>
.flashcard-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>