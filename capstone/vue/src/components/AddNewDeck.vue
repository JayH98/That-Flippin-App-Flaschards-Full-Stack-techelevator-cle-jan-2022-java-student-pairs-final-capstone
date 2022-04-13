<template>
  <div>
    <a
      id="show-form-button"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
      >Create A New Deck</a
    >

    <form v-on:submit.prevent v-if="showForm === true" autocomplete="off">
      <div class="form-element">
        <label for="deckName">Deck Name:</label>
        <input
          id="deckName"
          type="text"
          placeholder="Insert Name Here"
          v-model="newDeck.Name"
        />
      </div>

      <div class="form-element">
        <label for="creator">Creator:</label>
        <input
          id="creator"
          type="text"
          placeholder="Who Are You?"
          v-model="newDeck.Creator"
        />
      </div>

      <input class="saveBtn" type="submit" value="Save" v-on:click.prevent="addNewDeck"/>
      <input class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="resetForm" />
    </form>
  </div>
</template>

<script>
export default {
  name: "add-deck",
  data() {
    return {
      showForm: false,
      newDeck: {
        Creator: "",
        Name: "",
      },
    };
  },
  methods: {
    addNewDeck() {
      this.$store.commit("ADD_DECK", this.newDeck);
    },
    resetForm() {
      this.showForm = false;
      this.newDeck;
    },
  },
};
</script>

<style>

input.saveBtn,
input.cancelBtn {
  width: 10%;
  padding: 5px;
  border-radius: 5px;
  color: #000000;
  background-color: #00afef;
  font-weight: bold;
  text-align: center;
  text-transform: uppercase;
}


</style>