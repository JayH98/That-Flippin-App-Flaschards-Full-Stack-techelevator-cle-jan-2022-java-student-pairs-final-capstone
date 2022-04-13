<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register" autocomplete="off">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div id="form-fillout">
        <div id="username-box">
          <label for="username" class="sr-only">Username:</label> &nbsp;&nbsp;&nbsp;&nbsp;
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
          <label for="password" class="sr-only">Password:</label> &nbsp;&nbsp;&nbsp;
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />&nbsp;
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />
        </div>
        <br />
        <div id="accountExists-box">
          <router-link :to="{ name: 'login' }">Have an account?</router-link> &nbsp;&nbsp;
          <button class="btn btn-lg btn-primary btn-block" type="submit">
            Create Account
          </button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>

.form-register {
  margin: 10%;
  padding: 50px;
  
}

#form-fillout {
  display: flex;
  flex-direction: column;
  text-align: left;
  
}

#accountExists-box button {


    width: 10%;
    padding: 5px;
    border-radius: 5px;
    color: #000000;
    background-color: #00afef;
    font-weight: bold;
    text-align: center;
    text-transform: uppercase;
}

#test-box {
  display: flex;
  border: 10px lightgrey;
  width: 300px;
}


</style>
