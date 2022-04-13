<template>
  <div class="home">
    <h2>Home</h2>
    <p>Select A Deck or Topic Tag</p>
    <add-flash-card />

    <add-new-deck />
    
    


    <form>
      <input  list="options" multiple/>
    <datalist id="options">
      <option value="Module 1"/>
        <option value="Module 2"/>
        <option value="Module 3"/>
        <option value="Module 4"/>
        <option value="Java"/>
        <option value="MVC"/>
        <option value="HTML"/>
        <option value="Resume"/>
        <option value="Git"/>
        <option value="SQL"/>
        <option value="HTTP"/>
        <option value="API"/>
        <option value="CSS"/>
        <option value="JavaScript"/>
        <option value="DOM"/>
        <option value="Vue"/>
        <option value="Interview"/>
        <option value="LinkedIn"/>
          </datalist>
        
    </form>


    <!-- <input type="checkbox" id="module1" value="module1" name="studyTopic"
    v-model="studyTopic" />
    <label for="module1"> Module 1 </label>
    <input type="checkbox" id="module2" value="module2" name="studyTopic" 
    v-model="studyTopic"/>
    <label for="module2"> Module 2 </label>
    <input type="checkbox" id="module3" value="module3" name="studyTopic"
    v-model="studyTopic"/>
    <label for="module3"> Module 3 </label>
    <input type="checkbox" id="module4" value="module4" name="studyTopic"
    v-model="studyTopic" />
    <label for="module4"> Module 4 </label>

    <p>
      <input type="checkbox" id="java" value="java" name="studyTopic"
      v-model="studyTopic" />
      <label for="java"> Java </label>
      <input type="checkbox" id="mvc" value="mvc" name="studyTopic"
      v-model="studyTopic"/>
      <label for="mvc"> MVC </label>
      <input type="checkbox" id="html" value="html" name="studyTopic"
      v-model="studyTopic" />
      <label for="html"> HTML </label>
      <input type="checkbox" id="resume" value="resume" name="studyTopic"
      v-model="studyTopic" />
      <label for="resume"> Resume </label>
    </p>

    <p>
      <input type="checkbox" id="git" value="git" name="studyTopic"
      v-model="studyTopic" />
      <label for="git"> Git </label>
      <input type="checkbox" id="sql" value="sql" name="studyTopic"
      v-model="studyTopic"/>
      <label for="sql"> SQL </label>
      <input type="checkbox" id="http" value="http" name="studyTopic"
      v-model="studyTopic" />
      <label for="http"> HTTP </label>
      <input type="checkbox" id="api" value="api" name="studyTopic"
      v-model="studyTopic"/>
      <label for="api"> API </label>
    </p>

    <p>
      
      <input type="checkbox" id="css" value="css" name="studyTopic"
      v-model="studyTopic"/>
      <label for="css"> CSS </label>
      <input type="checkbox" id="javascript" value="javascript" name="studyTopic"
      v-model="studyTopic"/>
      <label for="javascript"> JavaScript </label>
      <input type="checkbox" id="dom" value="dom" name="studyTopic"
      v-model="studyTopic" />
      <label for="dom"> DOM </label>
      <input type="checkbox" id="vue" value="vue" name="studyTopic"
      v-model="studyTopic" />
      <label for="vue"> VUE </label>
    </p>

    <p>
      <input type="checkbox" id="interview" value="interview" name="studyTopic"
      v-model="studyTopic" />
      <label for="interview"> Interview </label>
      <input type="checkbox" id="LinkedIn" value="LinkedIn" name="studyTopic"
      v-model="studyTopic" />
      <label for="LinkedIn"> LinkedIn </label>

      ===== Creator is a blanket case for the multiple "Creators" which will exist later =====
      <input type="checkbox" id="creator" value="creator" />
      <label for="creator"> Creator </label>
    </p> -->

    <!-- When a new tag is added, should a new button be added?  Or should it just be forced
    into a specific module? -->

    <!-- needs v-bind to tie to the modules selected in the store -->

    <section>
      <button id="beginStudyBtn" type="button">Begin Study Session</button>
    </section>

    <section>
      
      
      <form> 
        <!-- <label for="question"> Question: </label> <br>
        <textarea type="text" id="question" name="question" placeholder="Insert Question Here"/><br>

        <label for="answer"> Answer: </label> <br>
        <textarea type="text" id="answer" name ="question" placeholder="Insert Answer Here"/><br>

        <label for="creator"> Card Creator's Name: </label> <br>
        <input type="text" id="creator" name="creator" placeholder="Who Are You?"><br> -->

      <!-- Form for New Card should appear after new card is selected? -->

        <!-- <button id="createCard" type="button">Create New Card</button> <br> -->

       

        <!-- <label for="newDeckName">New Deck's Name: </label><br>
        <input type="text" id="newDeckName" name="newDeckName" placeholder="Insert New Deck Name"> <br>

        <label for="newTopic"> New Deck's Topic / Tag: </label><br>
        <textarea id="newTopic" name="newTopic" placeholder="Insert New Deck's Topic / Tag"/><br>
        
        <button id="createNewDeck" type="button"> Create New Deck</button> <br> -->
      <!-- Create New Card needs v-bind and logic to add a new card to the selected module
      AND ONLY the selected module.
 crossover with Study Session would be perfect on this occasion -->
      </form>
    </section>

    <flash-card-list/>
    
  </div>
</template>

<script>
import AddFlashCard from '../components/AddFlashCard.vue';
import AddNewDeck from '../components/AddNewDeck.vue';
import FlashCardList from '../components/FlashCardList.vue';


export default {
  components: { AddFlashCard, AddNewDeck, FlashCardList},
  name: "home",

  // Created methods section in case needed later
  // methods:(){
  // },

};
</script>

<style>

body {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "ul ul"
  "#home #home"
  ;              
}

ul {
  display: flex;
}

.home {
  display: grid;
  
}

h2, p, #beginStudy {
  padding-bottom: 10px;
  padding-left: 50px;
}

form {
  padding-left: 50px;
  padding-bottom: 50px;
}

#beginStudyBtn {
  padding: 5px;
  padding-left: 50px;
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