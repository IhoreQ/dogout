let pageID = window.location.hash;
let pageName = pageID.substring(1);

if (pageName === "" || pageName === "home") {
    document.querySelector("#home").classList.add("is-active");
    document.querySelector("#home-container").classList.add("container-is-active");
} else {

    if (pageName === "my-doggy-form") {
        document.querySelector("#my-doggy").classList.add("is-active");
        document.querySelector("#my-doggy-container").classList.add("container-is-active");
    }

    document.querySelector(pageID).classList.add("is-active");
    document.querySelector(pageID + "-container").classList.add("container-is-active");
}
