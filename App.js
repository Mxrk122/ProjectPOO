/*

App.js

Autores:
Pedro Arriola 20188 패드로 아리어라
Oscar López 20679 어스칼 로팻스
Marco Orozco 마르코 오롯스코
Santiago Taracena 20017 산띠아고 탈으세나
Yong Park 20117 박용범

Última modificación: 2020-10-07

*/

// Librerías utilizadas.
import React, {Component} from "react"
import fire from "./config/Fire"
import {BrowserRouter, Route, Switch, Redirect} from "react-router-dom"

// Componentes utilizados.
import LandingPage from "./pages/LandingPage.js"
import Courses from "./pages/Courses.js"
import AboutUs from "./pages/AboutUs.js"
import NotFoundPage from "./pages/404.js"
import Login from "./pages/Login.js"

// Clase App que contiene al Router de la página.
class App extends Component {

  // Método constructor.
  constructor() {
    super();
    this.state = ({
      user: null,
    });
    this.authListener = this.authListener.bind(this);
  }

  // Método que retorna la verificación del usuario.
  componentDidMount() {
    this.authListener();
  }

  // Método que autentifica al usuario.
  authListener() {
    fire.auth().onAuthStateChanged((user) => {
      console.log(user);
      if (user) {
        this.setState({ user });
        localStorage.setItem('user', user.uid);
      } else {
        this.setState({ user: null });
        localStorage.removeItem('user');
      }
    });
  }

  // Método que renderiza la página.
  render() {
    return (
      <div>
        <BrowserRouter>
          <Switch>
            <Route exact path = "/LandingPage" component = {LandingPage}/>
            <Route exact path = "/Login" render = {() => (
              this.state.user ? <Login/> : <Redirect to = "/LandingPage"/>
            )}/>
            <Route exact path = "/Courses" component = {Courses}/>
            <Route exact path = "/AboutUs" component = {AboutUs}/>
            <Route exact path = "/404" component = {NotFoundPage}/>
          </Switch>
        </BrowserRouter>
      </div>
    )
  }
}

export default App