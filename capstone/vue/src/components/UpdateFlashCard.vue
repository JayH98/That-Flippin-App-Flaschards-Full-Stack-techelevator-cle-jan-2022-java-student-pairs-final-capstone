<template>
<div>

  <form v-on:submit.prevent autocomplete="off">
      <div class="form-element">
        <label for="tag">Tag:</label>
        <input id="tag" type="text" placeholder="Edit Card Tag Here" v-model="updatedCard.Tag" />
      </div>  
      <div class="form-element">
        <label for="question">Question:</label>
        <textarea id="question" type="text" placeholder="Edit Question Here" v-model="updatedCard.Question" />
      </div>  
      <div class="form-element">
        <label for="answer">Answer:</label>
        <textarea id="answer" type="text" placeholder="Edit Answer Here" v-model="updatedCard.Answer" />
      </div>
      <input class="saveBtn" type="submit" value="Save" v-on:click.prevent="editFlashCard"/>
      <input class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="resetForm" />      

  </form>
</div>   
</template>

<script>
import FlashCardService from '../services/FlashCardService.js'

export default {
    name: "edit-card",
    props: ["flashcardID"],
    data() {
        return {
            showForm: false,
            updatedCard: {
                id: "",
                Module: "",
                Creator: "",
                Tag: "",
                Question: "",
                Answer: "",
                Deck: "",
            }
        }
    },
    methods: {
        created() {
          FlashCardService.getCard(this.flashcardID).then((response => {
            this.updatedCard = response.data;
          }))
        },
        updateCard(){
            FlashCardService.updateCard(this.flashcardID, this.updatedCard).then((response => {
              if (response.status === 200) {
                this.$router.push({name: 'home'});
              }
            }));
            this.resetForm();
        },
    },
    


}


</script>

<style>
a {
  padding-left: 50px;
  
}