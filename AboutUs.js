/*

AboutUs.js

Autores:
Pedro Arriola 20188 패드로 아리어라
Oscar López 20679 어스칼 로팻스
Marco Orozco 마르코 오롯스코
Santiago Taracena 20017 산띠아고 탈으세나
Yong Park 20117 박용범

Última modificación: 2020-10-07

*/

// Librería utilizada.
import React from "react"

// Componentes utilizados.
import NavigationBar from "./components/NavigationBar"
import Texto from "./components/DescriptionAboutUs"
import MainAboutUs from "./components/MainAboutUs"

// Estilos utilizados.
import "./components/styles/style.css"
import "bootstrap/dist/css/bootstrap.css"

// Método que retorna la página AboutUs.
const AboutUs = () => {
    return (
        <div>
            <NavigationBar/>
            <MainAboutUs/>
            <Texto/>
        </div>
    )
}

export default AboutUs