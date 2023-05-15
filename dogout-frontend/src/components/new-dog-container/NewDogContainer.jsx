import React, { useState } from "react";
import NewDogInitiator from "./NewDogInitiator";

import "./NewDogContainer.css";
import NewDogForm from "./NewDogForm";

const NewDogContainer = () => {

    const initiator = sessionStorage.getItem("dog-adding-initiator") == null ? false : true;
    const [initiatorClicked, setInitiatorClicked] = useState(initiator);

    return (
        <div className="new-dog-container">
            {!initiatorClicked
                ? <NewDogInitiator setInitiatorClicked={setInitiatorClicked} />
                : <NewDogForm />}
        </div>
    )
}

export default NewDogContainer;