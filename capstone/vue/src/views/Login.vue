<template>
  <div id="login" class="text-center">


   <h1 class="h3 mb-3 font-weight-normal">Welcome to That Flippin' App! <br/>Please Sign In</h1>
    
    <form id="sign-in" class="form-signin" @submit.prevent="login" autocomplete="off">
       
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>

      

      <div id="form-fillout">
        <div id="username-box">
          <label for="username" class="sr-only"></label> &nbsp;&nbsp;&nbsp;&nbsp;
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
        </div>
        <br />
        <div id="password-box">
        <label for="password" class="sr-only"></label> &nbsp;&nbsp;&nbsp;
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required        
        />
        </div>
        <br />
          <div id="submit-button">
          <button type="submit">Sign in</button>
    
          </div>

        <div  >
          <router-link id="account-link" :to="{ name: 'register' }">Register Here</router-link> &nbsp;&nbsp;&nbsp;&nbsp;
        </div>
        
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style>

</style>

<style scoped>



.login {
  display:flex;
  align-items: flex-start;
}

#sign-in {
  display:flex;
  justify-content: center;
  position:relative;
  top:200px;
  }


.h3 {
display:flex;
color: #00ADEE;
  justify-content: center;
  position:relative;
  top:200px;
  left:25%;
  font-family:'Courier New', Courier, monospace;
  font-size: 80px;
  background-image: url('../assets/notecard.png');
  background-repeat: no-repeat;
  background-size: cover;
  width: 60%;
  text-align: center;
  background-repeat: none;
}
 

#account-link {
  display:flex;

  align-items:center;
  background-image: url('../assets/parchment.jpg');
  border-radius:5px; 
  color:#556268;
  text-decoration: none;
 
  
}

#account-link:hover {
  color:black;
  
}


#submit-button{
  position:relative;
  left:30%;
  align-content: center;
  justify-content: center;
  
}





</style>
