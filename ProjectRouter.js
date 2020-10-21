/*

ProjectRouter.js

Autores:
Pedro Arriola 20188 패드로 아리어라
Oscar López 20679 어스칼 로팻스
Marco Orozco 마르코 오롯스코
Santiago Taracena 20017 산띠아고 탈으세나
Yong Park 20117 박용범

Última modificación: 2020-10-07

*/

// Librerías utilizadas.
import React from "react"
import {BrowserRouter as Router, Route, Switch, Redirect} from "react-router-dom"

// Componentes utilizados.
import LandingPage from "./LandingPage"
import Courses from "./Courses"
import Login from "./Login"
import AboutUs from "./AboutUs"
import NotFoundPage from "./404"

// Método que retorna el Router de la página.
const ProjectRouter = () => {
    return (
        <Router>
            <Switch>
                <Route exact path="/inicio" component = {LandingPage}/>
                <Route exact path="/cursos" component = {Courses}/>
                <Route exact path="/login" component = {Login}/>
                <Route exact path="/nosotros" component = {AboutUs}/>
                <Route exact path="/404" component = {NotFoundPage}/>
                <Redirect to="/404" />
            </Switch>
        </Router>
    )
}

export default ProjectRouter