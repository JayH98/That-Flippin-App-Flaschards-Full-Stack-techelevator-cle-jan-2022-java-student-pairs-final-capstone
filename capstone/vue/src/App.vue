<template>
  <div id="app">

    <header>
      <div class = "header-left-content">
        <img id="te-logo" src="./assets/vector_long_logo_dark.png" alt="Tech Elevator Logo">
      </div>
      <div class = "header-right-content">
        <nav class = "header-buttons">
          <ul>
            <router-link id="home-button" style="text-decoration : none" v-bind:to="{ name: 'home' }"><button class = "home-button">HOME</button></router-link>  &nbsp;&nbsp;
            <router-link id="create-button" style="text-decoration : none" v-bind:to="{ name: 'create-deck'}" v-if="$store.state.token != ''"><button class = "create-button">CREATE</button></router-link>
           
            <router-link id="logout-button" style="text-decoration : none" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"><button class = "logout-button">LOGOUT</button></router-link>
            <router-link id="meet-us" style="text-decoration : none" v-bind:to="{ name: 'meet-us'}"><button class = "meet-us">CONTACT US</button></router-link>
         </ul>
        </nav>
      </div>
    </header>  
  
    <router-view />
  </div>
</template>

<style>
#app {
  /* min-width: 1250px; */
  margin: 0;
  width: 100%;
}

body {
  display: block;
  min-height: 600px;
  background-color: rgb(189, 189, 189);
  background: url('./assets/Woodstain.jpg');
  margin: 0;
  /* width: 100vw; */
}

header {
  display: flex;
  justify-content: space-between;
  width: 100%;
}

.home-button, .logout-button, .create-button, .edit-button {
  border-radius: 5px;
  height: 30px;
  width: 90px;
  background-image: url('./assets/parchment.jpg');
}

.create-button:hover {
  transform: translateY(-10px);
  transition: .25s;
  background: radial-gradient(#00ADEE, #71D96F);
  cursor:url('./assets/pointer_tilted.png'), pointer;
}

.home-button:hover {
 transform: translateY(-10px);
  transition: .25s;
  background: radial-gradient(#00ADEE, #71D96F);
  cursor:url('./assets/pointer_tilted.png'), pointer;
  
}

.logout-button:hover { 
  transform: translateY(-10px);
  transition: .25s;
  background: radial-gradient(#00ADEE, rgb(243, 81, 81));
cursor:url('./assets/pointer_tilted.png'), pointer;
}

.meet-us:hover{
transform: translateY(-10px);
  transition: .25s;
  background: radial-gradient(#00ADEE, #71D96F);
cursor:url('./assets/pointer_tilted.png'), pointer;
}


.meet-us {
  background-color: #00ADEE;
  border-radius: 5px;
  height: 40px;
  width: 90px;
  background-image: url('./assets/parchment.jpg');
}

#app {
  background-image: url('./assets/Woodstain.jpg');
}

.header-left-content {
align-items:center;
justify-content: center;
object-fit: cover;


}
#te-logo{
  background:white;
  border-radius: 5px;
  height: 50px;
  justify-content: center;
  align-items: center;
  object-fit: cover;
}


  
</style>


<style scoped>

#app {
  height: 100%;
  width: 100%;
  background-color: rgb(189, 189, 189);
  cursor:url('./assets/pointer_tilted.png'), pointer;
}




</style>

