import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},

    // Addition of a filter for searching
    // Do we need to add a blank flashcard?
    decks: [ {
      Name:"Tech Elevator",
      Creator: "Tech Elevator",
    }
      
    ],
    
    flashcards: [
        {
        id: 1,
        Module: 3,
        Creator: "Tech Elevator",
        Tag: "DOM",
        Question: "What does DOM stand for?",
        Answer: "Document Object Model",
        Deck: "Tech Elevator",
        },
        
        {
        id:2,
        Module: 3,
        Creator: "Tech Elevator",
        Tag: "DOM",
        Question: 'What type of tools in a web browser are used to inspect a DOM?',
        Answer: 'Developer Tools',
        Deck:"Tech Elevator",
        },
        
        {
        id:3,
        Module: 3,
        Creator: 'Tech Elevator',
        Tag: 'Vue',
        Question: 'What three programming languages can you use simultaneously in a Vue document?',
        Answer: 'HTML, CSS, and JavaScript',
        Deck:"Tech Elevator",
        },
        
        {
        id:4,
        Module: 3,
        Creator: 'Tech Elevator',
        Tag: 'VUE',
        Question: 'If a Vue router is not found, which error code is returned?',
        Answer: '404',
        Deck:"Tech Elevator",
        },
        
        {
        id:5,
        Module: 4,
        Creator: 'Tech Elevator',
        Tag: 'Interview',
        Question: 'True or False: Dirty laundry in the background of a video interview is okay',
        Answer: 'False',
        Deck:"Tech Elevator",
        },
        
        {
        id:6,
        Module: 4,
        Creator: 'Tech Elevator',
        Tag: 'Interview',
        Question: 'What does the STAR in STAR questions stand for?',
        Answer: 'Situation, Task, Action, Result',
        Deck:"Tech Elevator",
        },
        
        {
        id:7,
        Module: 4,
        Creator: 'Tech Elevator',
        Tag: 'Interview',
        Question: 'True or False:  When introducing yourself during a technical interview you should tailor your pitch to the more technical audience',
        Answer: 'True',
        Deck:"Tech Elevator",
        },
        
        {
        id:8,
        Module: 4,
        Creator: 'Tech Elevator',
        Tag: 'Resume',
        Question: 'True or False:  Having your full address on your resume is always helpful',
        Answer: 'false',
        Deck:"Tech Elevator",
        },
        
        {
        id:9,
        Module: 4,
        Creator: 'Tech Elevator',
        Tag: 'Resume',
        Question: 'True or False:  A brightly colored resume is always the best',
        Answer: 'False',
        Deck:"Tech Elevator",
        },
        
        {
        id:10,
        Module: 4,
        Creator: 'Tech Elevator',
        Tag: 'LinkedIn',
        Question: 'True or False:  Recruiters don’t use LinkedIn to find potential employees',
        Answer: 'False',
        Deck:"Tech Elevator",
        },
        
        {
        id:11,
        Module: 4,
        Creator: 'Tech Elevator',
        Tag: 'LinkedIn',
        Question: 'True or False:  Posing with my dog in my LinkedIn profile picture is acceptable',
        Answer: 'False',
        Deck:"Tech Elevator",
        },
        
        {
        id:12,
        Module: 4,
        Creator: 'Tech Elevator',
        Tag: 'LinkedIn',
        Question: 'True or False: LinkedIn will not help you find a job',
        Answer: 'False',
        Deck:"Tech Elevator",
        },

        {
          id:13,
          Module: 1,
          Creator: 'Tech Elevator',
          Tag: 'Java',
          Question: 'What are the three Principles of Object Oriented Programming?',
          Answer: 'Polymorphism, Encapsulation, and Inheritance',
          Deck:"Tech Elevator",
        },

          {
          id:14,
          Module: 2,
          Creator: 'Tech Elevator',
          Tag: 'MVC',
          Question: 'What does MVC Stand for?',
          Answer: 'Model, View, Controller',
          Deck:"Tech Elevator",
          },

          {
          id:35,
          Module: 3,
          Creator: 'Tech Elevator',
          Tag: 'HTML',
          Question: 'What does HTML stand for?',
          Answer: 'Hyper Text Markup Language',
          Deck:"Tech Elevator",
          },
          
          {
          id:15,
          Module: 4,
          Creator: "Tech Elevator",
          Tag:"Resume",
          Question: "How long, ideally, should your resume be?",
          Answer: "1 Page",
          Deck:"Tech Elevator",
          },

          {
          id:16,
          Module: 1,
          Creator:"Tech Elevator",
          Tag: 'Git',
          Question: "What is version control?",
          Answer: "Version control is software used to help keep track of changes over time to a codebase",
          Deck:"Tech Elevator",
          },
          
          {
          id:17,
          Module: 1,
          Creator:"Tech Elevator",
          Tag: "Git",
          Question: 'What two steps must you take in Git before pushing your work?',
          Answer: 'Add and Commit',
          Deck:"Tech Elevator",
          },
          
          {
          id:18,
          Module: 1,
          Creator: 'Tech Elevator',
          Tag: 'Java',
          Question: 'In a Map, a value is paired with what?',
          Answer: 'A Key',
          Deck:"Tech Elevator",
          },
          
          {
          id:19,
          Module: 1,
          Creator: 'Tech Elevator',
          Tag: 'Java',
          Question: 'What is Polymorphism?',
          Answer: 'The ability of different objects to respond in a unique way to the same message',
          Deck:"Tech Elevator",
        },
          
          {
          id:20,
          Module: 1,
          Creator: 'Tech Elevator',
          Tag: 'Java',
          Question: 'What command is used to end the iteration of a loop?',
          Answer: 'Break',
          Deck:"Tech Elevator",
          },
          
          {
          id:21,
          Module: 1,
          Creator: 'Tech Elevator',
          Tag: 'Java',
          Question: 'What expression deals with True and False?',
          Answer: 'Boolean',
          Deck:"Tech Elevator",
          },
          
          {
          id:22,
          Module: 2,
          Creator: 'Tech Elevator',
          Tag: 'SQL',
          Question: 'What does SQL stand for?',
          Answer: 'Structured Query Language',
          Deck:"Tech Elevator",
          },
          
          
          {
          id:23,
          Module: 2,
          Creator: 'Tech Elevator',
          Tag: 'SQL',
          Question: 'If I wanted to select all rows in a table, what symbol would I use?',
          Answer: '*',
          Deck:"Tech Elevator",
          },
          
          {
          id:24,
          Module: 2,
          Creator: 'Tech Elevator',
          Tag: 'SQL',
          Question: 'What term would you use to connect two separate tables?',
          Answer: 'Join',
          Deck:"Tech Elevator",
          },
          
          {
          id:25,
          Module: 2,
          Creator: 'Tech Elevator',
          Tag: 'HTTP',
          Question: 'What is the difference between HTTP and HTTPS?',
          Answer: 'HTTPS is secured/encrypted',
          Deck:"",
          },
          
          {
          id:26,
          Module: 2,
          Creator: 'Tech Elevator',
          Tag: 'HTTP',
          Question: '.com, .org, and .gov are examples of what URL part?',
          Answer: 'Top Level Domain',
          Deck:"Tech Elevator",
          },
        
          {
          id:27,
          Module: 2,
          Creator: 'Tech Elevator',
          Tag: 'API',
          Question: 'What does API stand for?',
          Answer: 'Application Programming Interface',
          Deck:"Tech Elevator",
          },
          
          {
          id:28,
          Module: 2,
          Creator: 'Tech Elevator',
          Tag: 'API',
          Question: 'What does JSON stand for?',
          Answer: 'JavaScript Object Notation',
          Deck:"Tech Elevator",
          },
          
          {
          id:29,
          Module: 2,
          Creator: 'Tech Elevator',
          Tag: 'API',
          Question: 'What term is used to send an update request to an API?',
          Answer: 'PUT',
          Deck:"Tech Elevator",
          },
          
          {
          id:30,
          Module: 3,
          Creator: 'Tech Elevator',
          Tag: 'CSS' ,
          Question:  'True or False: An ID assigned to more than one element in CSS',
          Answer: 'False',
          Deck:"Tech Elevator",
          },
          
          {
          id:31,
          Module: 3,
          Creator: 'Tech Elevator',
          Tag: 'CSS',
          Question: 'px is an example of what kind of length unit?',
          Answer: 'Absolute',
          Deck:"Tech Elevator",
          },
          
          {
          id:32,
          Module: 3,
          Creator: 'Tech Elevator',
          Tag: 'CSS',
          Question: 'What is Responsive Web Design?',
          Answer: 'Responsive web design is a set of practices that allows pages to alter their layout and appearance to suit different screen sizes and resolutions',
          Deck:"Tech Elevator",
          },
          
          {
          id:33,
          Module: 3,
          Creator: 'Tech Elevator',
          Tag: 'JavaScript',
          Question: 'What does NaN stand for?',
          Answer: 'Not a Number',
          Deck:"Tech Elevator",
          },

          {
          id:34,
          Module: 3,
          Creator: 'Tech Elevator',
          Tag: 'JavaScript',
          Question: 'What is the boolean value of “!null”',
          Answer: 'True',
          Deck:"Tech Elevator",
          },
        ],
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    ADD_CARD(state, flashcard) {
      state.flashcards.unshift(flashcard);
    },
    ADD_DECK(state, deck) {
      state.decks.push(deck);
    }

    // Is this how the whole card will be added to the store or do we need to specify ID etc.

  }
})
