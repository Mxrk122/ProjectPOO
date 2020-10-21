import firebase from 'firebase'

 // Your web app's Firebase configuration
  // Your web app's Firebase configuration
  const firebaseConfig = {
    apiKey: "AIzaSyAdLuHGwhpxs0ghJPlVYQOKKMhYDMpR8sM",
    authDomain: "a-plus-v2.firebaseapp.com",
    databaseURL: "https://a-plus-v2.firebaseio.com",
    projectId: "a-plus-v2",
    storageBucket: "a-plus-v2.appspot.com",
    messagingSenderId: "1034035789517",
    appId: "1:1034035789517:web:7f6e50ebb480760d98f384"
  }
  // Initialize Firebase
  const fire = firebase.initializeApp(firebaseConfig)
  export default fire