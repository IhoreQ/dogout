import React from "react";

import "./ContentContainer.css";

const ContentContainer = ({ children }) => {
    return (
        <div className="app-content-container">{children}</div>
    )
}

export default ContentContainer;