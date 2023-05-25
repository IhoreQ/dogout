import React from "react";
import MenuIcon from '@mui/icons-material/Menu';
import SeparateBar from "../common/SeparateBar";
import MenuBar from "./MenuBar";

import "./Dashboard.css";

const toggleMenuBar = () => {
    const menuBar = document.querySelector(".menu-bar");
    const menuContainer = document.querySelector(".menu-container");

    if (menuBar.classList.contains("menu-bar-active") === true) {
        menuContainer.classList.remove("menu-container-active");
        setTimeout(() => {
            menuBar.classList.remove("menu-bar-active");
        }, 500)
    }
    else {
        menuBar.classList.add("menu-bar-active");
        menuContainer.classList.add("menu-container-active");
    }
}

const Dashboard = ({ activeElement }) => {

    const handleBurgerClick = () => {
        toggleMenuBar();
    }

    return (
        <div className="menu-container">
            <div className="menu-logo">
                <SeparateBar styles={{ visibility: "hidden" }} />
                <div className="menu-logo-inner">
                    <img src={"/img/dog-logo.png"} alt="" className="menu-dog-logo" />
                </div>
                <SeparateBar />
                <div onClick={handleBurgerClick} className="menu-burger">
                    <MenuIcon />
                </div>
            </div>
            <MenuBar activeElement={activeElement} />
        </div>
    )
}

export default Dashboard;