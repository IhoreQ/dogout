const registerForm = document.querySelector('.register-form');
const emailInput = registerForm.querySelector('input[name="email"]');

function isEmail(email) {
    return /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(email);
}

function markValidation(element, condition) {
    !condition ? element.classList.add('no-valid') : element.classList.remove('no-valid');
}

function validateEmail() {
    setTimeout(function() {
        console.log("Siema");
        markValidation(emailInput, isEmail(emailInput.value));
    }, 1000
    );
}

emailInput.addEventListener('keyup', validateEmail);