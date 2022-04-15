<template>
<div>

  <form v-on:submit.prevent autocomplete="off">
     
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
    name: 'edit-deck',
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
        editDeck(){
            this.$store.commit("EDIT_DECK", this.updatedCard);
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
