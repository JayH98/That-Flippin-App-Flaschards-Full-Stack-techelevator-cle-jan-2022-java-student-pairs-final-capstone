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
          <label for="username" class="sr-only">Username: </label>
          &nbsp;&nbsp;&nbsp;&nbsp;
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
          <label for="password" class="sr-only">Password: </label>
          &nbsp;&nbsp;&nbsp;
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
          <router-link :to="{ name: 'register' }">Need an account?</router-link>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <button type="submit">Sign in</button>
        </div>
      </div>
    </form>


    <!-- BELOW COPIED FROM views/register.vue -->
    <!-- <div class="study-guy-container">
      <img id="study-guy-img" src="../assets/guy-studying.jpg" />

      <div class="study-guy-text">
        <h2>Elevate your studying</h2>
        <p>
          This is placeholder text. Later, I will put something more meaningful
          here
        </p>
      </div>

      <div class="study-method">
        <div>
          <h3>The age old study method with a Tech Elevator twist</h3>
          <p>
            Every new account comes with 35 flashcards premade by Tech Elevator
            alumni to help you study!
          </p>
        </div>
        <img
          id="tech-elevator-cleveland"
          src="../assets/tech-elevator-cleveland.jpg"
          alt="Students from Cleveland tech elevator campus"
        />
      </div>

      <div class="proven-science">
        <div>
          <h3>A study method backed by science</h3>
          <p>
            Flashcards have been proven to increase information retention and
            improve conceptual understanding
          </p>
        </div>
        <img
          id="flashcard"
          src="../assets/flashcards.jpg"
          alt="Decks of flashcards"
        />
      </div>
    </div> -->
    <!-- ABOVE COPIED FROM views/register.vue -->
    <!-- BELOW JHH modified copied FROM views/register.vue -->

    <!-- <div class="pictures-container">
      <img id="flashCardsIndexCardsOnDardWoodTableTop-img" src="../assets/flashCardsIndexCardsOnDardWoodTableTop.jpeg" />

    </div> -->


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
/* BELOW IS OLD CODE */
/* #login, #account-box{  
  padding: 20px;  
} */
/* .form-signin {
  margin: 10%;
  padding: 50px;
}*/
/* #form-fillout {
  display: flex;
  flex-direction: column;
  text-align: left;  
}*/
/* #account-box button {
    width: 10%;
    padding: 5px;
    border-radius: 5px;
    color: #000000;
    background-color: #00afef;
    font-weight: bold;
    text-align: center;
    text-transform: uppercase;
}*/
/* html {
  background-color: #87ceeb;
   font-family: Arial, Helvetica, sans-serif; 
}  */
/* ABOVE IS OLD CODE */




/* BELOW IS COPIED FROM views/register.vue CODE */
/* .form-register {
  padding: 50px;
}*/
/* #form-fillout {
  display: flex;
  flex-direction: column;
  text-align: left;
} */
/* #accountExists-box button {
  width: 10%;
  padding: 5px;
  border-radius: 5px;
  color: #000000;
  background-color: #00afef;
  font-weight: bold;
  text-align: center;
  text-transform: uppercase;
} */
/* #test-box {
  display: flex;
  border: 10px lightgrey;
  width: 300px;
} */
</style>

<style scoped>
/* .study-method div,
.proven-science div {
  display: flex;
  flex-direction: column;
  align-items: center;
} */

/* .study-method img,
.proven-science img {
  width: 35%;
  max-height: 200px;
} */

/* .study-method,
.proven-science {
  display: flex;
  column-gap: 50px;
} */

/* .proven-science {
  flex-direction: row-reverse;
} */

/* .study-method {
  margin-bottom: 80px;
} */

/* .study-guy-container {
  width: 100%;
} */
/* #study-guy-img {
  width: 100%;
  height: 400px;
  padding-left: 15px;
} */

/* .study-guy-text {
  position: relative;
  width: 50%;
  bottom: 150px;
} */

/* h2,
.study-guy-text p {
  color: rgb(3, 221, 3);
  font-weight: bold;
}  */
/* ABOVE IS COPIED FROM views/register.vue CODE */


</style>

