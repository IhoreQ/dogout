import React, { useEffect, useState } from "react";
import SignButton from "../common/SignButton";
import SeparateBar from "../common/SeparateBar";
import CustomSelect from "../common/CustomSelect";
import placeService from "../../api/service/placeService";

import "./CityChangeForm.css";

const CityChangeForm = () => {

    const [cities, setCities] = useState([]);
    const [city, setCity] = useState('');

    useEffect(() => {
        const fetchCities = async () => {
            const response = await placeService.getCities();
            if (response.status === 200) {
                setCities(response.data);
                setCity(response.data[0].name);
            }
        }

        fetchCities();
    }, [])

    const changeCity = (event) => {
        setCity(event.target.value);
    }

    const handleClick = (event) => {
        event.preventDefault();
    }

    return (
        <div className="city-change-container">
            <h1>Change city</h1>
            <SeparateBar />
            <form className="settings-form">
                <CustomSelect name="city" onChange={changeCity}>
                    {cities.map(city => <option key={city.idCity} value={city.id}>{city.name}</option>)}
                </CustomSelect>
                <SignButton onClick={handleClick}>Change</SignButton>
            </form>
        </div>
    )
}

export default CityChangeForm;