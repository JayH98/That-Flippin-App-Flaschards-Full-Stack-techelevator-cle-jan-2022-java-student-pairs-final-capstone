<template>
  <div id="app">
    <div id="nav">
      <ul>
      <img id="te-logo" src="./assets/TechElevator.png" alt="Tech Elevator Logo">
      <li id="home-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'home' }">HOME</router-link>&nbsp;&nbsp;</li>
      <!-- <li id="logout-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li> -->

      </ul>
    </div>
    <router-view />
  </div>
</template>

<style>

img {
  height: 4rem;
  
}

#nav ul {
  font-family: Arial, Helvetica, sans-serif;
    /* background-color: #87CEEB; */
    display: flex;
    /* justify-content: space-between; */
    flex-direction: row;
    align-items: center;
    list-style: none;
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
  
}

#app {
  background-color: rgb(189, 189, 189);
}

footer {
    grid-area: footer;
}





</style>

