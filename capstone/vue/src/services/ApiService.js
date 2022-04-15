import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

// I THINK THIS IS WHERE IT SHOULD BE AND WHAT IT SHOULD LOOK LIKE




export default {
// THIS MEANS NOTHING, IT'S JUST WHAT I THINK IT MIGHT LOOK LIKE.  I'M NOT SURE WHERE THE ROUTE
// FOR THE FUNCTION SHOULD COME FROM.  WHAT WAS STATED IN INTELLIJ?  NOT SURE
    get() {
        return http.get('/something');
    }


}

