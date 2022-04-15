<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login" autocomplete="off">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
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
          <label for="username" class="sr-only">Username: </label> &nbsp;&nbsp;&nbsp;&nbsp;
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
        <label for="password" class="sr-only">Password: </label> &nbsp;&nbsp;&nbsp;
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
        <div id="account-box">
          <router-link :to="{ name: 'register' }">Need an account?</router-link> &nbsp;&nbsp;&nbsp;&nbsp;
          <button type="submit">Sign in</button>
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

<style scoped>



/* #login, #account-box{
  
  padding: 20px;
  
} */

/* .form-signin {
  margin: 10%;
  padding: 50px;
}

#form-fillout {
  display: flex;
  flex-direction: column;
  text-align: left;
  
}

#account-box button {
    width: 10%;
    padding: 5px;
    border-radius: 5px;
    color: #000000;
    background-color: #00afef;
    font-weight: bold;
    text-align: center;
    text-transform: uppercase;
}


html {
  background-color: #87ceeb;
   font-family: Arial, Helvetica, sans-serif; 
}  */


</style>