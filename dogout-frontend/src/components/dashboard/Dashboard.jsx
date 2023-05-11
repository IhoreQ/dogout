import React from "react";
import MenuIcon from '@mui/icons-material/Menu';
import SeparateBar from "../common/SeparateBar";
import MenuBar from "./MenuBar";

import "./Dashboard.css";

const Dashboard = ({ activeElement }) => {
    return (
        <div className="menu-container">
            <div className="menu-logo">
                <SeparateBar styles={{ visibility: "hidden" }} />
                <div className="menu-logo-inner">
                    <img src={"/img/dog-logo.png"} alt="" className="menu-dog-logo" />
                </div>
                <SeparateBar />
                <div className="menu-burger">
                    <MenuIcon />
                </div>
            </div>
            <MenuBar activeElement={activeElement} />
        </div>
    )
}

export default Dashboard;