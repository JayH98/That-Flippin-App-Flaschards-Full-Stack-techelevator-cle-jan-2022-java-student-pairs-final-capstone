<template>
  <div>
    <form @submit.prevent="updateCard" autocomplete="off">
      <div class="form-element">
        <label for="tag">Tag:</label>
        <input
          id="tag"
          type="text"
          placeholder="Edit Card Tag Here"
          v-model="updatedCard.Tag"
        />
      </div>
      <div class="form-element">
        <label for="question">Question:</label>
        <textarea
          id="question"
          type="text"
          placeholder="Edit Question Here"
          v-model="updatedCard.Question"
        />
      </div>
      <div class="form-element">
        <label for="answer">Answer:</label>
        <textarea
          id="answer"
          type="text"
          placeholder="Edit Answer Here"
          v-model="updatedCard.Answer"
        />
      </div>
      <button class="saveBtn" type="submit" value="Save">Save</button>
      <button
        class="cancelBtn"
        type="button"
        value="Cancel"
        v-on:click.prevent="resetForm"
      >
        Cancel
      </button>
    </form>

    <flash-card v-bind:flashcard="updatedCard"/>
    <div class="errorMessage" v-show="cardUpdatedFailure">
      {{ errorMessage }}
    </div>
  </div>
</template>

<script>
import FlashCard from '@/components/FlashCard.vue'
import FlashCardService from "../services/FlashCardService.js";

export default {
  name: "edit-card",
  components: {FlashCard},
  props: ["flashcardID"],
  data() {
    return {
      cardUpdatedFailure: false,
      errorMessage: "",
      showForm: false,
      updatedCard: {
        id: 0,
        Module: "",
        Creator: "",
        Tag: "",
        Question: "",
        Answer: "",
        Deck: "",
      },
    };
  },
  methods: {
    created() {
      FlashCardService.getCard(this.flashcardID).then((response) => {
        this.updatedCard = response.data;
        // this.updatedCard.id = response.data.id
      })
      // .catch(());
    },
    updateCard() {
      FlashCardService.updateCard(this.flashcardID, this.updatedCard)
        .then((response) => {
          if (response.status === 202) {
            this.cardUpdatedFailure = false;
            this.resetForm();
            this.$router.push({ name: "home" });
          }
          this.$router.push({ name: "create-deck" });
        })
        .catch((error) => {
          this.errorMessage = "";
          if (error.response) {
            this.cardUpdatedFailure = true;
            if (error.response.status === 500) {
              
              this.errorMessage =
                "Error updating form. An internal server error occurred.";
            } else if (error.response.status === 404) {
              this.errorMessage =
                "Error updating card. URL could not be found.";
            } else {
              this.errorMessage =
                "Error updating form. Response received was code " +
                error.response.status +
                " '" +
                error.response.statusText +
                "'.";
            }
          }
        });
    },
    resetForm() {
      this.updatedCard.Tag = "";
      this.updatedCard.Question = "";
      this.updatedCard.Answer = "";
    },
  },
};
</script>

<style scoped>
a {
  padding-left: 50px;
}

.errorMessage {
  width: 400px;
  background-color: #F08080;
  color: black;
}
</style>
