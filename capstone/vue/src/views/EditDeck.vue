<template>
  <div>
    <section id="title">
    <h1 style="color:black">Edit Deck</h1>
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
h1 {
  color: #00ADEE;
}
#title{
 color: black;

}

</style>