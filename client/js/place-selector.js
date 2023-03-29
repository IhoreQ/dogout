const placeTextBox = document.querySelectorAll(".place-text-box");
const placeBox = document.querySelectorAll(".place-box");

function setPlaceCookie() {

    let placeName;

    if (this.hasAttribute("id")) {
        placeName = this.getAttribute('id');
    } else {
        placeName = this.parentElement.getAttribute('id');
    }

    fetch(`/getPlaceID/${placeName}`, {
        method: "GET"
    }).then(res => res.json()
        .then(data => {
            document.cookie = `chosen_place=${data};path=/`;
            window.location.replace("place");
        }));
}

placeTextBox.forEach(place => {
    place.addEventListener("click", setPlaceCookie)
})

placeBox.forEach(place => {
    place.addEventListener("click", setPlaceCookie)
})