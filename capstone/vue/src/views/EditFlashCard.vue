<template>
  <div>
    <h1>Edit Topic</h1>
    <update-flash-card v-bind:flashcardID="parseInt($route.params.id)" />
  </div>
</template>

<script>
import UpdateFlashCard from "@/components/UpdateFlashCard.vue";

export default {
    name: 'edit-flashcard',
    components: {
    UpdateFlashCard
  }
};
</script>

<style>
</style>
