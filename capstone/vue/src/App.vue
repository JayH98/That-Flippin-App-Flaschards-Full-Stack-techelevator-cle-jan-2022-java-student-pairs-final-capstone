<template>
  <div id="app">

    <header>
      <img id="te-logo" src="./assets/vector_long_logo_dark.png" alt="Tech Elevator Logo">
      <h1>Full Stack Flashcards</h1>
    </header>  

    
     
      <!-- <li id="home-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'home' }">HOME</router-link>&nbsp;&nbsp;</li> -->
      <!-- <li id="logout-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li> -->
      <!-- <li id="logout-button"><router-link style="text-decoration : none" v-bind:to="{ name: 'logout' }">Logout</router-link></li> -->

      <nav>
        <ul>
          <li><router-link id="home-button" style="text-decoration : none" v-bind:tag="li" v-bind:to="{ name: 'home' }">HOME</router-link> <li> &nbsp;&nbsp;
          <li><router-link id="logout-button" style="text-decoration : none" v-bind:tag="li" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT</router-link></li>
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
  /* background-color: #87CEEB; */
  display: flex;
  flex-direction: row;
  align-items: center;
  list-style: none;
  /* justify-content: space-between; */
  justify-content: space-between;
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

