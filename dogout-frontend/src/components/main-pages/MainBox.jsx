import React from "react";
import "./MainBox.css"

const MainBox = ({children}) => {
    return (
        <div className="main-container">
            <div className="app-container">
            {children}
            </div>
        </div>
    )
}

export default MainBox;