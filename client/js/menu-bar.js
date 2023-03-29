const buttons = document.querySelectorAll(".menu-bar-element");

const menuBar = document.querySelector(".menu-bar");
const menuBurger = document.querySelector(".menu-burger");
const menuContainer = document.querySelector(".menu-container");


buttons.forEach((button) => {
    button.addEventListener("click", () => {

        document.querySelector(".is-active").classList.remove("is-active");
        button.classList.add("is-active");

        const containerName = button.id + "-container";
        document.querySelector(".container-is-active").classList.remove("container-is-active");
        document.querySelector("." + containerName).classList.add("container-is-active");

        if (menuBar.classList.contains("menu-bar-active") === true) {
            menuContainer.classList.remove("menu-container-active");
            setTimeout(() => {
                menuBar.classList.remove("menu-bar-active");
            }, 500)
    }
    });
});

menuBurger.addEventListener("click", () => {

    if (menuBar.classList.contains("menu-bar-active") === true) {
            menuContainer.classList.remove("menu-container-active");
            setTimeout(() => {
                menuBar.classList.remove("menu-bar-active");
            }, 500)
    }
    else {
        menuBar.classList.add("menu-bar-active");
        menuContainer.classList.add("menu-container-active");
    }
});