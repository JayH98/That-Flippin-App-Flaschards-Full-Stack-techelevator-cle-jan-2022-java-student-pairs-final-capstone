<template>
<div>
<a
      id="show-form-button"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >Create A Flashcard</a>

  <form v-on:submit.prevent v-if="showForm === true">
      <div class="form-element">
        <label for="creator">Creator:</label>
        <input id="creator" type="text" v-model="newCard.Creator" />
      </div>
      <div class="form-element">
        <label for="tag">Tag:</label>
        <input id="tag" type="text" v-model="newCard.Tag" />
      </div>  
      <div class="form-element">
        <label for="question">Question:</label>
        <input id="question" type="text" v-model="newCard.Question" />
      </div>  
      <div class="form-element">
        <label for="answer">Answer:</label>
        <input id="answer" type="text" v-model="newCard.Answer" />
      </div>
      <input type="submit" value="Save" v-on:click.prevent="addNewCard"/>
      <input type="button" value="Cancel" v-on:click.prevent="resetForm" />      

  </form>
</div>   
</template>

<script>
export default {
    name: "add-card",
    data() {
        return {
            showForm: false,
            newCard: {
                id : 0,
                Module : 0,
                Creator : "",
                Tag : "",
                Question : "",
                Answer : "",
            }
        }
    },
    methods: {
        addNewCard(){
            this.$store.commit("ADD_CARD", this.newCard)
        },
        resetForm(){
            this.showForm = false;
            this.newCard;
        }
    }
}


</script>

<style>

</style>