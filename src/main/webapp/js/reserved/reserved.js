function registRequestCancelEvent () {
    const confirmedReservationList = document.querySelector(".confirmed");
    confirmedReservationList.addEventListener("click", function(evt)  {
        if (evt.target.className === "btn" || evt.target.innerHTML === "취소") {
            let reservationInfoId = evt.target.parentElement.id;
            if (reservationInfoId === "") {
                reservationInfoId = evt.target.parentElement.parentElement.id;
            }
            BookingEvent.prototype.popUpButtonEvent();
            BookingEvent.prototype.popUpCancelNoEvent();
            BookingEvent.prototype.popUpCancelYesEvent(reservationInfoId);
        }
    });
};

function makeReservationListCard (reservationInfoResponse) {
    const reservatioInfoList = reservationInfoResponse.reservations;
    reservatioInfoList.forEach(function(reservationInfo)  {
        const reservationCard = new ReservationCard(reservationInfo, reservationInfo.cancelYn);
        reservationCard.makeReservationCard();
    });

    ReservationCard.prototype.setAllListNumber(reservationInfoResponse);
    ReservationCard.prototype.setReservationListNumber();
};

function requestReservationInfoResponse  () {
    const reservationEmail = document.querySelector(".reservationEmail").id;
    const url = "/reservation/api/reservations?reservationEmail=" + reservationEmail;
	var oReq=new XMLHttpRequest();
	oReq.addEventListener("load",function(){
		var json=JSON.parse(this.responseText);
		
		 makeReservationListCard(json);

		 registRequestCancelEvent();
		
	});
	oReq.open("GET", url, true);
	oReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	oReq.send();
   

};

document.addEventListener("DOMContentLoaded", function() {
    requestReservationInfoResponse();
});