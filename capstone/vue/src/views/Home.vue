<template>
  <div class="home">
    <h1>Home</h1>
    <p>Select A Deck or Topic Tag</p>

    <input type="checkbox" id="module1" value="module1" />
    <label for="module1"> Module 1 </label>
    <input type="checkbox" id="module2" value="module2" />
    <label for="module2"> Module 2 </label>
    <input type="checkbox" id="module3" value="module3" />
    <label for="module3"> Module 3 </label>
    <input type="checkbox" id="module4" value="module4" />
    <label for="module4"> Module 4 </label>

    <p>
      <input type="checkbox" id="java" value="java" />
      <label for="java"> Java </label>
      <input type="checkbox" id="mvc" value="mvc" />
      <label for="mvc"> MVC </label>
      <input type="checkbox" id="html" value="html" />
      <label for="html"> HTML </label>
      <input type="checkbox" id="resume" value="resume" />
      <label for="resume"> Resume </label>
    </p>

    <p>
      <input type="checkbox" id="git" value="git" />
      <label for="git"> Git </label>
      <input type="checkbox" id="sql" value="sql" />
      <label for="sql"> SQL </label>
      <input type="checkbox" id="http" value="http" />
      <label for="http"> HTTP </label>
      <input type="checkbox" id="api" value="api" />
      <label for="api"> API </label>
    </p>

    <p>
      
      <input type="checkbox" id="css" value="css" />
      <label for="css"> CSS </label>
      <input type="checkbox" id="javascript" value="javascript" />
      <label for="javascript"> JavaScript </label>
      <input type="checkbox" id="dom" value="dom" />
      <label for="dom"> DOM </label>
      <input type="checkbox" id="vue" value="vue" />
      <label for="vue"> VUE </label>
    </p>

    <p>
      <input type="checkbox" id="interview" value="interview" />
      <label for="interview"> Interview </label>
      <input type="checkbox" id="LinkedIn" value="LinkedIn" />
      <label for="LinkedIn"> LinkedIn </label>
    </p>

    <!-- When a new tag is added, should a new button be added?  Or should it just be forced
    into a specific module? -->

    <!-- needs v-bind to tie to the modules selected in the store -->

    <section>
      <button id="beginStudy" type="button">Begin Study Session</button>
    </section>

    <section>
      <button id="createCard" type="button">Create New Card</button>

      <!-- Create New Card needs v-bind and logic to add a new card to the selected module.
 crossover with Study Session would be perfect on this occasion -->
    </section>
  </div>
</template>

<script>
export default {
  name: "home",

  // Created methods section in case needed later
  // methods:(){
  // },

  // computed section for retrieving/adding cards
  // computed:() {
  // },
};
</script>
