import React from "react";
import HomeIcon from '@mui/icons-material/Home';
import NaturePeopleIcon from '@mui/icons-material/NaturePeople';
import PetsIcon from '@mui/icons-material/Pets';
import SettingsIcon from '@mui/icons-material/Settings';
import LogoutIcon from '@mui/icons-material/Logout';
import { Link } from "react-router-dom";
import authenticationService from '../../api/service/authenticationService';

import "./MenuBar.css";

const MenuBar = ({ activeElement }) => {

    const handleLogoutClick = () => {
        authenticationService.logout();
    }

    let home = false, places = false, myDoggy = false, settings = false;

    switch (activeElement) {
        case "home":
            home = true;
            break;
        case "places":
            places = true;
            break;
        case "my-doggy":
            myDoggy = true;
            break;
        case "settings":
            settings = true;
            break;
    }

    return (
        <div className="menu-bar">
            <ul className="menu-bar-list">
                <li className={`menu-bar-element ${home && 'is-active'}`} id="home">
                    <Link to="/home">
                        <span>
                            <HomeIcon />
                            Home
                        </span>
                    </Link>
                </li>
                <li className={`menu-bar-element ${places && 'is-active'}`} id="places">
                    <Link to="/places">
                        <span>
                            <NaturePeopleIcon />
                            Places
                        </span>
                    </Link>
                </li>
                <li className={`menu-bar-element ${myDoggy && 'is-active'}`} id="my-doggy">
                    <Link to="/my-doggy">
                        <span>
                            <PetsIcon />
                            My doggy
                        </span>
                    </Link>
                </li>
                <li className={`menu-bar-element ${settings && 'is-active'}`} id="settings">
                    <Link to="/settings">
                        <span>
                            <SettingsIcon />
                            Settings
                        </span>
                    </Link>
                </li>
                <li onClick={handleLogoutClick} className="menu-bar-element" id="logout">
                    <Link to="/login">
                        <span>
                            <LogoutIcon />
                            Log out
                        </span>
                    </Link>
                </li>
            </ul>
        </div>
    )
}

export default MenuBar;