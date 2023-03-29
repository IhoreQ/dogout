const activeWalkTextBox = document.querySelector(".active-walk-text");
const activeWalkBox = document.querySelector(".active-walk-box");
const placePhoto = document.querySelector(".active-walk-box");
const finishButton = document.querySelector(".active-walk-finish");
const timeLeft = document.querySelector(".proper-time");

function isOnAWalk() {
    fetch("/isUserOnAWalk", {
        method: "GET"
    }).then(res => res.json().then(data => {
        if (data === true) {
            activeWalkBox.style.display = "flex";
            activeWalkTextBox.innerHTML = "Active walk:";
        } else {
            activeWalkTextBox.innerHTML = "No active walks.";
        }
    }));
}

function getPlacePhoto() {
    fetch("/getPlacePhoto", {
        method: "GET"
    }).then(res => res.json().then(data => {
        placePhoto.style.backgroundImage = `url('/public/img/places/${data}')`;
    }));
}

function endTheWalk() {
    fetch("/endTheWalk", {
        method: "GET"
    }).then(res => {
        if (res.ok) {
            window.location.reload();
        }
    });
}

function decrementSeconds() {
    let time = timeLeft.innerHTML;
    let hours = parseInt(time.substring(0, 2));
    let minutes = parseInt(time.substring(3,5));
    let seconds = parseInt(time.substring(6, 8));

    if (hours === 1) {
        minutes = 59;
        seconds = 59;
    }

    seconds--;

    if (minutes === 0 && seconds === 0) {
        clearInterval(interval);
        endTheWalk();
    }

    if (seconds < 0) {
        minutes--;
        seconds = 59;
    }

    if (minutes < 10)
        minutes = "0" + minutes;
    if (seconds < 10)
        seconds = "0" + seconds;

    timeLeft.innerHTML = "00:" + minutes + ":" + seconds;
}

window.addEventListener("load", getPlacePhoto);
window.addEventListener("load", isOnAWalk);
finishButton.addEventListener("click", endTheWalk);
let interval = setInterval(decrementSeconds, 1000);