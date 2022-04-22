<template>
  <div id="register" class="text-center">
    <h1 id="title">That Flippin' App!</h1>
    <form class="form-register" @submit.prevent="register" autocomplete="off">
      <h1 id="subtitle" class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div id="form-fillout">
        <div id="username-box">
          <label for="username" class="sr-only"></label>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Create New Username"
            v-model="user.username"
            required
            autofocus
          />
        </div>
        <br />
        <div id="password-box">
          <label for="password" class="sr-only"></label>
          &nbsp;&nbsp;&nbsp;
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Create New Password"
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
          <router-link id="have-account" to:="{ name: 'login' }">Have an account?</router-link>
          &nbsp;&nbsp;
          <button id="create-account-btn"  type="submit">
            Create Account
          </button>
        </div>
      </div>
    </form>
    <div class="study-guy-container">
      <img id="study-guy-img" src="../assets/guy-studying.jpg" />

      <div id="study-guy-text" class="study-guy-text">
        <h2>Elevate your studying</h2> <br/>
        <p>
          <br/>
          In minutes you could have a whole new study tool!  Study, and as you learn, Edit your
          flashcards<br/>  so they work for you!
        </p>
      </div>

      <div id="study-method" class="study-method">
        <div>
          <h3>The age old study method with a Tech Elevator twist</h3>
          <p> 
            <br/><br/>
            Every new account comes with 35 flashcards pre-made by Tech Elevator
            alumni to help you study!
            
           
          </p>
        </div>
        <img
          id="tech-elevator-cleveland"
          src="../assets/tech-elevator-cleveland.jpg"
          alt="Students from Cleveland tech elevator campus"
        />
      </div>

      <div id="proven-science" class="proven-science">
        <div>
          <h3>A study method backed by science</h3>
          <br/>
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
    </div>
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
   background-image: url('../assets/parchment.jpg');
}

#accountExists-box button:hover {
  transition: .25s;
  background: radial-gradient(#00ADEE, #71D96F);
}
#test-box {
  display: flex;
  border: 10px lightgrey;
  width: 300px;
}
</style>

<style scoped>
.study-method div,
.proven-science div {
  display: flex;
  flex-direction: column;
  align-items: center;
 
}

.study-method img,
.proven-science img {
  width: 35%;
  max-height: 200px;
}

.study-method,
.proven-science {
  display: flex;
  column-gap: 50px;
}

.proven-science {
  flex-direction: row-reverse;
}

.study-method {
  margin-bottom: 80px;
}

.study-guy-container {
  width: 100%;
  
}
#study-guy-img {
  width: 60%;
  height: 400px;
  padding-left: 15px;
}

.study-guy-text {
  position: relative;
  width: 50%;
  bottom: 150px;
  font-size:large;
 
}



h2{ 
  font-weight: bold;
color:black;


}
.study-guy-text{
  color:black;
 

  
}

h1{
background-size:contain;
width:fit-content;
border-radius: 5px;
}

#create-account-button {
 transition: .25s;
  background: radial-gradient(#00ADEE, #71D96F);
}

#study-method {
background-image: url('../assets/notecard.png');
background-size:cover;
width:fit-content

}

#proven-science{
   background-image: url('../assets/notecard.png');
   background-size:cover;
   width:fit-content;
}

#study-guy-text{
  background-image:url('../assets/notecard.png');
background-size:co;
width:fit-content;
border-radius: 5px;
}

#title {
  background-image:url('../assets/parchment.jpg');
  width:fit-content;
}

#subtitle {
  font-size:large;
  background-image:url('../assets/parchment.jpg');
  width:fit-content;
  font-family: 'Courier New', Courier, monospace;
}
</style>
