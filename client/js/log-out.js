const logOutButton = document.querySelector(".log-out-button");

function logOut() {
    document.cookie = 'user_enabled' + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
}

logOutButton.addEventListener("click", logOut);