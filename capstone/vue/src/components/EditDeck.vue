<template>
<div>
<a
      id="show-Edit-Deck-form-button"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >Edit A Deck</a>

  <form v-on:submit.prevent v-if="showForm === true" autocomplete="off">
     
      <div class="form-element">
        <label for="tag">Tag:</label>
        <input id="tag" type="text" placeholder="Edit Deck Tag Here" v-model="updatedDeck.Tag" />
      </div>  
      <div class="form-element">
        <label for="question">Name:</label>
        <textarea id="question" type="text" placeholder="Edit Name Here" v-model="updatedDeck.Name" />
      </div>  
      
      <input class="saveBtn" type="submit" value="Save" v-on:click.prevent="editDeck"/>
      <input class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="resetForm" />      

  </form>
</div>   
</template>

<script>
export default {
    name: "edit-deck",
    data() {
        return {
            showForm: false,
            updatedDeck: {
                
                
                Tag : "",
               
               
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
            this.updatedDeck = {
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