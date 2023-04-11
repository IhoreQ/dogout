import React from "react";
import "../css/components/BlueButton.css"

const BlueButton = ({onClick, children}) => {
    return <button onClick={onClick} className="blue-button">{children}</button>
}

export default BlueButton;