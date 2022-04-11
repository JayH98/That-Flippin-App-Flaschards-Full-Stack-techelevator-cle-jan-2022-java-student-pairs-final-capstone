<template>
  <div id="app">
    <div id="nav">
      <ul>

      <img id="te-logo" src="./assets/TechElevator.png" alt="Tech Elevator Logo">
      <li><router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;</li>
      <li><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>

      </ul>
    </div>
    <router-view />
  </div>
</template>

<style>

img {
  height: 4rem;
  border: 10px solid red;
}

#nav ul {
  font-family: Arial, Helvetica, sans-serif;
    background-color: #87CEEB;
    display: flex;
    /* justify-content: space-between; */
    flex-direction: row;
    align-items: center;
    list-style: none;
}

#nav li {
    text-transform: uppercase;
    font-weight: bold;
    list-style: none;
    width: 30%;
    background-color: #00afef;
    border-radius: 5px;
    text-align: center;
    line-height: 50px;
}



</style>

