const footer = document.querySelector(".places-footer-ideas");
const closeButton = document.querySelector(".app-cover-close");
const appCover = document.querySelector(".app-cover");
const spinner = document.querySelector("#spinner");
const loadCover = document.querySelector(".load-cover");


footer.addEventListener("click", () => {
    appCover.style.display = "flex";
});

function turnOff() {
    appCover.style.display = "none";
}

function turnOn() {
    appCover.style.display = "flex";
}

function showAddingPage() {
    document.querySelector(".new-dog-info").style.display = "none";
    document.querySelector(".new-dog-add-page").style.display = "flex";
}

const fileUpload = document.querySelector("#file-upload");

fileUpload.addEventListener("change", function() {
    document.querySelector("#file-chosen").textContent = this.files[0].name;
});

function loadData() {
    spinner.removeAttribute('hidden');
    fetch('https://www.mocky.io/v2/5185415ba171ea3a00704eed?mocky-delay=1000ms')
        .then(() => {
            spinner.setAttribute('hidden', '');
            loadCover.style.opacity = "0";
            setTimeout(function () {
                loadCover.style.display = "none";
            }, 1000);
        });
}

window.addEventListener("load", loadData);