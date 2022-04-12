<template>
  <div id="app">
    <div id="nav">
      <ul>
      <img id="te-logo" src="./assets/vector_long_logo_dark.png" alt="Tech Elevator Logo">
      <!-- <li id="home-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'home' }">HOME</router-link>&nbsp;&nbsp;</li> -->
      <!-- <li id="logout-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li> -->
      <!-- <li id="logout-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'logout' }">Logout</router-link></li> -->

      <router-link id="home-button" style="text-decoration : none" v-bind:tag="li" v-bind:to="{ name: 'home' }">HOME</router-link> &nbsp;&nbsp;
      <router-link id="logout-button" style="text-decoration : none" v-bind:tag="li" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
     
      </ul>
    </div>
    <router-view />
  </div>
</template>

<style>

img {
  height: 4rem;
  margin-left: -50px;
  
}

#nav ul {
  font-family: Arial, Helvetica, sans-serif;
  /* background-color: #87CEEB; */
  display: flex;
  flex-direction: row;
  align-items: center;
  list-style: none;
  /* justify-content: space-between; */
  justify-content: space-around;
  padding: 10px;
  margin: 50px;
}



#home-button, #logout-button {
    font-weight: bold;
    list-style: none;
    width: 20%;
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

body {
  width: 100%;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: 
  "img img #home-button #logout-button";
}



</style>

