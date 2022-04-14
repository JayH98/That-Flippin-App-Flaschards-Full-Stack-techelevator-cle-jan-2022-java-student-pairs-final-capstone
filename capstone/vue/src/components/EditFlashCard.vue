<template>
<div>
<a
      id="show-Edit-flashcard-form-button"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >Edit A Flashcard</a>

  <form v-on:submit.prevent v-if="showForm === true" autocomplete="off">
     
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
export default {
    name: "edit-card",
    data() {
        return {
            showForm: false,
            updatedCard: {
                
                Creator : "",
                Tag : "",
                Question : "",
                Answer : "",
                Deck: "",
            }
        }
    },
    methods: {
        editCard(){
            this.$store.commit("EDIT_CARD", this.updatedCard);
            this.resetForm;
        },
        resetForm(){
            this.showForm = false;
            this.updatedCard = {
                Tag : "",
                Question : "",
                Answer : "",
            };
        }
    },
    


}


</script>

<style>
a {
  padding-left: 50px;
  
}