import React from 'react';
import { useNavigate } from 'react-router-dom';
import "./PageNotFound.css"
import SignButton from '../components/common/SignButton';

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
            <SignButton onClick={returnToHomePage}>Return to the home page</SignButton>
        </div>
    )
}

export default PageNotFound;