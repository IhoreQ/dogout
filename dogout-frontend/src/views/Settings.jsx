import React from "react";
import MainBox from "../components/common/MainBox";
import AppWrapper from "../components/common/AppWrapper";
import Dashboard from "../components/dashboard/Dashboard";

const Settings = () => {

    React.useEffect(() => {
        document.title = 'Settings | DogOut';
      }, []);

    return (
        <MainBox>
            <AppWrapper>
                <Dashboard activeElement="settings"/>
            </AppWrapper>
        </MainBox>
    )
}

export default Settings;