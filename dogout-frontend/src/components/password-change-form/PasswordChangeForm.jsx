import React, { useState, useContext } from "react";
import SignButton from "../common/SignButton";
import { WarningContext } from "../../App";
import { InformationContext } from "../../App";
import userService from "../../api/service/userService";

import "./PasswordChangeForm.css";
import SeparateBar from "../common/SeparateBar";

const PasswordChangeForm = () => {

    const [passwords, setPasswords] = useState({
        "oldPassword": '',
        "newPassword": '',
        "repeatedNewPassword": ''
    });

    const { setWarning, setWarningId } = useContext(WarningContext);
    const { setInformation, setInformationId} = useContext(InformationContext);

    const onPasswordChange = (event) => {
        const { name, value } = event.target;

        setPasswords(prevInfo => {
            return {
                ...prevInfo,
                [name]: value
            }
        })
    }

    const triggerWarning = (id) => {
        setWarningId(id);
        setWarning(true);
    }

    const showInformation = (id) => {
        setInformationId(id);
        setInformation(true);
    }

    const checkIfPasswordsMatch = () => {
        return passwords.newPassword === passwords.repeatedNewPassword;
    }

    const validatePassword = () => {
        return passwords.newPassword.length >= 6;
    }

    const handleChangePassword = async (event) => {
        event.preventDefault();

        if (!validatePassword()) {
            triggerWarning("PASSWORD_TOO_SHORT");
        }
        else if (!checkIfPasswordsMatch()) {
            triggerWarning("PASSWORDS_DO_NOT_MATCH");
        }
        else {
            const { data: res } = await userService.changePassword(passwords);

            if (!res) {
                triggerWarning("WRONG_CURRENT_PASSWORD");
                return;
            }

            showInformation("PASSWORD_CHANGED");

            setPasswords({
                "oldPassword": '',
                "newPassword": '',
                "repeatedNewPassword": ''
            })
        }
    }

    return (
        <div className="password-change-container">
            <h1>Change password</h1>
            <SeparateBar />
            <form className="settings-form">
                <input onChange={onPasswordChange} value={passwords.oldPassword} type="password" name="oldPassword" placeholder="Current password" />
                <input onChange={onPasswordChange} type="password" value={passwords.newPassword} name="newPassword" placeholder="New password" />
                <input onChange={onPasswordChange} type="password" value={passwords.repeatedNewPassword} name="repeatedNewPassword" placeholder="Repeat new password" />
                <SignButton onClick={handleChangePassword}>Change</SignButton>
            </form>
        </div>
    )
}

export default PasswordChangeForm;