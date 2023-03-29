const adminSettingsBox = document.querySelector('.admin-settings-box');

function checkAdminPrivileges() {

    fetch("/checkRole", {
        method: "GET"
    }).then(res => res.json().then(data => {
        if (data === 2) {
            adminSettingsBox.style.display = "flex";
        } else {
            adminSettingsBox.remove();
        }
    }));
}

function redirectToAdminPanel() {
    window.location.replace("adminPanel");
}

window.addEventListener("load", checkAdminPrivileges);
adminSettingsBox.addEventListener("click", redirectToAdminPanel);