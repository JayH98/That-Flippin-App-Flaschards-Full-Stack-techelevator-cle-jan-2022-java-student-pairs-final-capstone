<template>
<div>
<!-- <h4>Create A Flashcard</h4> -->

  <form v-on:submit.prevent autocomplete="off">
      <div class="form-element">
        <label for="tag"></label>
        <input id="tag" type="text" placeholder="Insert New Card Tag Here" v-model="newCard.tag" />
      </div>  
      <div class="form-element">
        <label for="question"></label>
        <textarea id="question" type="text" placeholder="Insert New Question Here" v-model="newCard.question" />
      </div>  
      <div class="form-element">
        <label for="answer"></label>
        <textarea id="answer" type="text" placeholder="Insert New Answer Here" v-model="newCard.answer" />
      </div>
      <div class="form-element">
        <label for="deck"></label>
        <input id="deck" type="text" placeholder="Deck Name" v-model="newCard.deck" />
      </div>
      <input class="saveBtn" type="submit" value="Save" v-on:click.prevent="addNewCard"/>
      <input class="cancelBtn" type="button" value="Cancel" v-on:click.prevent="resetForm" />      

  </form>
</div>   
</template>

<script>
import FlashCardService from '../services/FlashCardService.js'

export default {
    name: "add-card",
    data() {
        return {
            newCard: {
                module : 0,
                creator : this.$store.state.user.username,
                tag : "",
                question : "",
                answer : "",
                deck: "",
            }
        }
    },
    methods: {
        addNewCard(){
            FlashCardService.createCard(this.newCard).then(response => {
              if (response.status === 201) {
              this.resetForm();
              console.log("Card created successfully");
              
              }
            })
            
        },
        resetForm(){
            this.newCard = {
                Module : 0,
                Creator : "",
                Tag : "",
                Question : "",
                Answer : "",
                Deck: "",
            };
        }
    }
}


</script>

<style>
a {
  padding-left: 50px;
  
}

.saveBtn, .cancelBtn {
  background-image: url('../assets/parchment.jpg');
}

.saveBtn:hover {
  transition:linear;
  transition-delay: .25s;
  
  background: linear-gradient(to right,#00ADEE, #71D96F 40%);
  cursor:url('../assets/pointer.png'), pointer;
}

.cancelBtn:hover {
  transition:linear;
  transition-delay: .25s;
  background: linear-gradient(to left,#00ADEE,rgba(243,81,81) 40% );
  cursor:url('../assets/pointer.png'), pointer;

}

</style>