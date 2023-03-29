let userHasDog;
const removeDogButton = document.querySelector('.doggy-footer-remove-box');

function hasDog() {

    const myDoggyContent = document.querySelector(".my-doggy-content");
    const newDoggyContent = document.querySelector(".new-dog-content");

    fetch("/getIfUserHasDog", {
        method: "GET"
    }).then(res => res.json().then(data => {
        if (data === true) {
            userHasDog = true;
            myDoggyContent.style.display = "flex";
        }
        else {
            userHasDog = false;
            newDoggyContent.style.display = "flex";
        }
    }));
}

function getDogPhoto() {
    const dogPhoto = document.querySelector(".dog-photo");

    fetch("/getUserDogPhoto", {
        method: "GET"
    }).then(res => res.json().then(data => {
        dogPhoto.style.backgroundImage = `url('/public/uploads/${data}')`;
    }));
}

function removeDog() {
    fetch("/removeDog", {
        method: "GET"
    }).then(res => {
        if (res.ok) {
            window.location.replace('home');
        }
    });
}

window.addEventListener("load", hasDog);
window.addEventListener("load", getDogPhoto);
removeDogButton.addEventListener('click', removeDog);
