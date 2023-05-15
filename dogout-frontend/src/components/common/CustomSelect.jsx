import React from "react";

import "./CustomSelect.css";

const CustomSelect = ({ children, name, onChange }) => {
    return (
        <select className="custom-select" name={name} onChange={onChange}>
                    {children}
        </select>
    )
}

export default CustomSelect;