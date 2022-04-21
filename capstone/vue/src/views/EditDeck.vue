<template>
  <div>
    <section id="title">
    <h1>Edit Deck</h1>
    </section>
    <update-deck v-bind:deckName="$route.params.deckName"/>
  </div>
</template>

<script>
import UpdateDeck from '../components/UpdateDeck.vue';


export default {
    name: 'edit-deck',
    components: {
        UpdateDeck
    
  }
};
</script>

<style>
#title{
 color: black;

}

</style>