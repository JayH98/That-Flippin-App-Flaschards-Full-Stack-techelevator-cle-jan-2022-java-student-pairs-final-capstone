<template>
  <div id="app">

    <header>
      <img id="te-logo" src="./assets/vector_long_logo_dark.png" alt="Tech Elevator Logo">
      <!-- <img id="te-logo" src="./assets/TechElevator.png" alt="Tech Elevator Logo"> -->
      <h1>Full Stack Flashcards</h1>
    </header>  

    
     
      <!-- <li id="home-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'home' }" v-bind:tag="li">HOME</router-link>&nbsp;&nbsp;</li> -->
      <!-- <li id="logout-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'logout' }"  v-bind:tag="li" v-if="$store.state.token != ''">Logout</router-link></li> -->
      <!-- <li id="logout-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'logout' }">Logout</router-link></li> -->

      <nav>
        <ul>
          <router-link id="home-button" style="text-decoration : none" v-bind:to="{ name: 'home' }">HOME</router-link>  &nbsp;&nbsp;
          <router-link id="logout-button" style="text-decoration : none" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT</router-link>
          <router-link id="create-deck" style="text-decoration : none" v-bind:to="{ name: 'create-deck'}" v-if="$store.state.token != ''" >CREATE</router-link>
        </ul>
      </nav>
  
    <router-view />
  </div>
</template>

<style>

header img {
  height: 4rem;
  margin-left: -50px;
  
}
 
nav ul {
  font-family: Arial, Helvetica, sans-serif;
  display: flex;
  flex-direction: row;
  align-items: center;
  list-style: none;
  justify-content: space-between;
  padding: 10px;
  margin: 50px;
}



#home-button, #logout-button, #create-deck {
    font-weight: bold;
    list-style: none;
    width: 40%;
    background-color: #00afef;
    color: #000000;
    border-radius: 5px;
    text-align: center;
    line-height: 50px;
    padding: 10px;
    margin: 20px -10px 20px 20px;
  
}

#app {
  background-color: rgb(189, 189, 189);
}

footer {
    grid-area: footer;
}

header {
    grid-area: header;
    display: flex;
}
nav {
    grid-area: nav;
}

#app {
  display: grid;
  grid-template-columns: 2fr 2fr;
  grid-template-areas: 
            "header nav";
}

img {
  grid-area: img;
}

body {
  width: 100%;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: 
  "img img #home-button #logout-button";
}

h1 {
 grid-area: h1;
 padding-left: 10px;
 color: #556268
}

header {
  display: grid;
  grid-template-rows: 2fr 2fr;
  grid-template-areas: "img "
                         "h1";
}

header img {
  height: 80px;
  width: auto;
  padding-left: 60px;
  padding-top: 10px;
} 


</style>

