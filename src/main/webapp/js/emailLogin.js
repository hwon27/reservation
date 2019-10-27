function clickLoginButtonEvent() {
    const loginButton = document.querySelector(".login_btn");
    loginButton.addEventListener("click", function() {
        const reservationUser = new ReservationUser();
        if (reservationUser.isEmailValid) {
            const redirectPage = new RedirectPage();
           requestReservationInfoResponse(reservationUser.email);

        }
    });
};

function registEmailCheckEvent ()  {
    const loginInput = document.querySelector(".login_form");
    loginInput.addEventListener("keyup", function(evt)  {
        ReservationUser.prototype.checkResUserEmail(evt);
    });
};

function initLoginEvent ()  {
    registEmailCheckEvent();
    clickLoginButtonEvent();
};

document.addEventListener("DOMContentLoaded", function() {
    initLoginEvent();
});
