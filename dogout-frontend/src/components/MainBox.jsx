import React from "react";
import "../css/components/MainBox.css"

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