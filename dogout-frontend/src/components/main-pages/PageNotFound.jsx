import React from 'react';
import "../../css/PageNotFound.css"

function PageNotFound() {

    React.useEffect(() => {
        document.title = '404 Not Found | DogOut';
      }, []);

    return (
        <div>
            <h2>This page is not available.</h2>
            <button>Return to the home page</button>
        </div>
    )
}

export default PageNotFound;