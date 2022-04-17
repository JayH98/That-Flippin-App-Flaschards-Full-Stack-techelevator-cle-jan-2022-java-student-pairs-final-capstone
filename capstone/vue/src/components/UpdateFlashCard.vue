<template>
  <div>
    <form @submit.prevent="updateCard" autocomplete="off">
      <div class="form-element">
        <label for="tag">Tag:</label>
        <input
          id="tag"
          type="text"
          placeholder="Edit Card Tag Here"
          v-model="updatedCard.tag"
        />
      </div>
      <div class="form-element">
        <label for="question">Question:</label>
        <textarea
          id="question"
          type="text"
          placeholder="Edit Question Here"
          v-model="updatedCard.question"
        />
      </div>
      <div class="form-element">
        <label for="answer">Answer:</label>
        <textarea
          id="answer"
          type="text"
          placeholder="Edit Answer Here"
          v-model="updatedCard.answer"
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
      {{ updatedErrorMessage }}
    </div>
    <div class="errorMessage" v-show="cardRetrievedFailure">
      {{ retrievedErrorMessage }}
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
      cardRetrievedFailure: false,
      updatedErrorMessage: "",
      retrievedErrorMessage: "",
      showForm: false,
      updatedCard: {
        id: 0,
        module: 0,
        creator: "",
        tag: "",
        question: "",
        answer: "",
        deck: "",
      },
    };
  },
  created() {
      FlashCardService.getCard(this.$route.params.id).then((response) => {
        this.updatedCard = response.data;
        console.log("Card was retrieved")
      })
      .catch((error) => {
        console.log("Card was not retrieved")
        this.cardRetrievedFailure = true;
          this.retrievedErrorMessage = "";
          if (error.response) {
            if (error.response.status === 500) {
              this.retrievedErrorMessage =
                "Error retrieving card. An internal server error occurred.";
            } else if (error.response.status === 404) {
              this.retrievedErrorMessage =
                "Error retrieving card. URL could not be found.";
            } else {
              this.retrievedErrorMessage =
                "Error retrieving card. Response received was code " +
                error.response.status +
                " '" +
                error.response.statusText +
                "'.";
            }
          }
          else if (error.request) {
            this.retrievedErrorMessage = "Error. Request for flashcard was made to server but no response was sent."
          }
          else {
            this.retrievedErrorMessage = "Error. No request for flashcard was made."
          }
        });
    },

  methods: {
    updateCard() {
      FlashCardService.updateCard(this.flashcardID, this.updatedCard)
        .then((response) => {
          if (response.status === 202) {
            console.log("Card was updated");
            this.cardUpdatedFailure = false;
            this.resetForm();
            this.$router.push({ name: "home" });
          }
          this.$router.push({ name: "create-deck" });
        })
        .catch((error) => {
          this.updatedErrorMessage = "";
          if (error.response) {
            this.cardUpdatedFailure = true;
            if (error.response.status === 500) {
              
              this.updatedErrorMessage =
                "Error updating form. An internal server error occurred.";
            } else if (error.response.status === 404) {
              this.updatedErrorMessage =
                "Error updating card. URL could not be found.";
            } else {
              this.updatedErrorMessage =
                "Error updating form. Response received was code " +
                error.response.status +
                " '" +
                error.response.statusText +
                "'.";
            }
          }
          else if (error.request) {
            this.retrievedErrorMessage = "Error. Request to update flashcard was made to server but no response was sent."
          }
          else {
            this.retrievedErrorMessage = "Error. No request to update flashcard was made."
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
