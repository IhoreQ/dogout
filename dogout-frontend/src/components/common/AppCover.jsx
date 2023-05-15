import React from "react";

import "./AppCover.css";

const AppCover = ({ children }) => {
    return (
        <div className="app-cover">
            {children}
        </div>

    )
}

export default AppCover;