import React from "react";

import "../css/components/Logo.css"

const Logo = () => {
    return (
        <div className="logo">
            <img src={require('../img/dog-logo.png')} alt="" className="dog-logo" />
        </div>
    )
}

export default Logo;