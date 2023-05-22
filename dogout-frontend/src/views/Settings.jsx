import React, { useContext } from "react";
import MainBox from "../components/common/MainBox";
import AppWrapper from "../components/common/AppWrapper";
import Dashboard from "../components/dashboard/Dashboard";
import ContentContainer from "../components/common/ContentContainer";
import PasswordChangeForm from "../components/password-change-form/PasswordChangeForm";
import CityChangeForm from "../components/city-change-form/CityChangeForm";
import { WarningContext } from "../App";
import { InformationContext } from "../App";
import Warning from "../components/warning/Warning";
import Information from "../components/information/Information";

import "./Settings.css";

const Settings = () => {

    const { warning } = useContext(WarningContext);
    const { information } = useContext(InformationContext);

    React.useEffect(() => {
        document.title = 'Settings | DogOut';
    }, []);

    return (
        <MainBox>
            <AppWrapper>
                {warning && <Warning />}
                {information && <Information />}
                <Dashboard activeElement="settings" />
                <ContentContainer>
                    <div className="settings-container">
                        <div className="settings-content">
                            <PasswordChangeForm />
                            <CityChangeForm />
                        </div>
                    </div>
                </ContentContainer>
            </AppWrapper>
        </MainBox>
    )
}

export default Settings;