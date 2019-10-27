  
function BookingEvent() {

}

BookingEvent.prototype = {
    
    removeConfirmedReservationList: function (reservationInfoId) {
        const confirmedReservation = document.getElementById(reservationInfoId);

        ReservationCard.prototype.confirmedReservation -= 1;
        confirmedReservation.remove();
    },
    popUpButtonEvent: function () {
        const popup = document.querySelector(".popup_booking_wrapper");
        popup.style.display = "block";
    },
    popUpCancelNoEvent: function () {
        const popup = document.querySelector(".popup_booking_wrapper");

        const no = document.querySelector(".btn_gray");
        no.addEventListener("click", function() {
            popup.style.display = "none";
        });

        const xButton = document.querySelector(".popup_btn_close");
        xButton.addEventListener("click", function() {
            popup.style.display = "none";
        });
    },
    popUpCancelYesEvent: function (reservationInfoId) {
        const popup = document.querySelector(".popup_booking_wrapper");

        const yes = document.querySelector(".btn_green");
        yes.id = reservationInfoId;

        yes.addEventListener("click", function(evt) {
            if (BookingEvent.prototype.equalReservationInfoId(evt, reservationInfoId)) {
                popup.style.display = "none";
                removeConfirmedReservationList(reservationInfoId);
                requestUpdateReservation(reservationInfoId);
            }
        });
    },
    equalReservationInfoId: function (evt, reservationInfoId) {
        return (evt.target.parentElement.id === reservationInfoId) || (evt.target.parentElement.parentElement.id === reservationInfoId);
    }

};

function removeConfirmedReservationList (reservationInfoId) {
    const confirmedReservation = document.getElementById(reservationInfoId);

    ReservationCard.prototype.confirmedReservation -= 1;
    confirmedReservation.remove();
}
function requestUpdateReservation (reservationInfoId) {
    const reqReservationResponseUrl = "/reservation/api/reservations/" + reservationInfoId;
    var oReq=new XMLHttpRequest();
	oReq.addEventListener("load",function(){
		var json=JSON.parse(this.responseText);
		console.log(json);
		goToCancelReservationList(reservationInfoId);
	});
	oReq.open("PUT", reqReservationResponseUrl, true);
	oReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	oReq.send();
    
  
}
function goToCancelReservationList (reservationInfoId) {
    const reqReservationInfoUrl = "/reservation/api/reservationInfo?reservationInfoId=" + reservationInfoId;
    var oReq=new XMLHttpRequest();
	oReq.addEventListener("load",function(){
	var json=JSON.parse(this.responseText);
	
	const reservationCard = new ReservationCard(json, json.cancelYn);
		 reservationCard.makeReservationCard();
		 ReservationCard.prototype.setReservationListNumber();
	});
	oReq.open("GET", reqReservationInfoUrl, true);
	oReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	oReq.send();
   
}