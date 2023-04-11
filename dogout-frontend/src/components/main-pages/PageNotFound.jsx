import React from 'react';
import { useNavigate } from 'react-router-dom';
import "../../css/PageNotFound.css"
import BlueButton from '../BlueButton';

function PageNotFound() {

    const navigate = useNavigate();

    const returnToHomePage = () => {
        navigate("/login");
    }
        
    React.useEffect(() => {
        document.title = '404 Not Found | DogOut';
      }, []);

    return (
        <div className='not-found-container'>
            <h2>This page is not available.</h2>
            <BlueButton onClick={returnToHomePage}>Return to the home page</BlueButton>
        </div>
    )
}

export default PageNotFound;