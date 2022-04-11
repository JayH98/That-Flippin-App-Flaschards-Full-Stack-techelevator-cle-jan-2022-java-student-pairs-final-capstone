<template>
  <div class = "flashcard">
      <p>{{flashcard.id}}</p>
      <p>{{}}
  </div>
</template>

<script>


export default {
    name: 'reading-list',
    props: ['flashcard'],
    components: {
        
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