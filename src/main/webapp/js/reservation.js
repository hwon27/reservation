function makeReservationPrice(productPrices, ticketInfoData)  {
    productPrices.forEach(function(productPrice)  {
        let ticketInfo = new TicketInfo(productPrice.productPriceId, 0, 0, 4);
        ticketInfoData.push(ticketInfo);
    });
}


function makeTicketNumberTemplate (productPrices) {
    let resultHTML = "";
    productPrices.forEach(function(productPrice)  {
        const data = TicketTemplate.prototype.makeMappingData(productPrice);
        const template = TicketTemplate.prototype.getTicketTypeFormTemplate();
        resultHTML += TicketTemplate.prototype.makeTicketTypeFormTemplate(template, data);
    });

    const ticketBody = document.querySelector(".ticket_body");
    ticketBody.innerHTML = resultHTML;

    showReservationDay();
}

function registTicketButtonEvent (productPrices, ticketInfoData) {
    const ticketBody = document.querySelector(".ticket_body");
    const pivot = ticketInfoData[0].productPriceId;
    ticketBody.addEventListener("click", function(event)  {
        if (TicketInfo.prototype.isButtonArea(event.target)) {
            let productPriceId = event.target.parentElement.id;

            const ticketInfo = ticketInfoData[pivot - productPriceId];
            const countControl = document.getElementById(productPriceId).parentElement;
            let productPrice = productPrices[pivot - productPriceId];

            if (ticketInfo.isClickedPlus(event.target)) {
                ticketInfo.plusButton(countControl, productPrice);
            } else if (ticketInfo.isClickedMinus(event.target)) {
                ticketInfo.minusButton(countControl, productPrice);
            }
        }
    });
}

function registReservationUserEvent () {
    const reservationUser = new ReservationUser();
    const inputBox = document.querySelectorAll(".inline_control");

    const userNameInputBox = inputBox[0];
    userNameInputBox.addEventListener("keyup", function(evt) {
        reservationUser.checkResUserName(evt);
    });

    const userTelephoneInputBox = inputBox[1];
    userTelephoneInputBox.addEventListener("keyup", function(evt)  {
        reservationUser.checkResUserTelephone(evt);
    });

    const userEmailInputBox = inputBox[2];
    userEmailInputBox.addEventListener("keyup", function(evt) {
        reservationUser.checkResUserEmail(evt);
    });
}

function registAgreementToggleEvent ()  {
    const reservationAgree = new ReservationAgree();

    const chkAgree = document.querySelector(".chk_txt_label");
    chkAgree.addEventListener("click", function() {
        if (reservationAgree.isValidContent()) {
            reservationAgree.switchColorReservationButton();
        }
    });

    const lookButton = document.querySelectorAll(".btn_agreement");

    const lookCollectAgreeButton = lookButton[0];
    lookCollectAgreeButton.addEventListener("click", function(evt)  {
        reservationAgree.toggleAgreementContent(evt);
    });

    const lookProvideAgreeButton = lookButton[1];
    lookProvideAgreeButton.addEventListener("click", function(evt)  {
        reservationAgree.toggleAgreementContent(evt);
    });
};

function registPostRequestEvent (displayInfo, ticketInfoData)  {
    const registButton = document.querySelector(".bk_btn_wrap");
    registButton.addEventListener("click", function() {
        if (ReservationAgree.prototype.isValidContent()
            && ReservationAgree.prototype.isReservationButtonOnColor()) {
        	
            const hiddenForm = new HiddenForm();
            hiddenForm.makeHiddenPrices(ticketInfoData);
           

            const reservationParamObj = new ReservationParam();
            const reservationParam = reservationParamObj.makeReservationParam(displayInfo);
           
            	console.log(reservationParam);
            	const url = "/reservation/api/reservations";
            	
            	var oReq = new XMLHttpRequest();
            	oReq.addEventListener("load", function () {
            		var json = JSON.parse(this.responseText);
            		
            		 window.location.replace("/reservation");
            											
            	});
            	oReq.open("POST", url);
            	oReq.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
            	oReq.send(JSON.stringify(reservationParam));
                
                       
        }
    });
}

function requestDisplayInfoData ()  {
    const displayInfoId = document.querySelector(".displayInfoId").id;
    const url = "/reservation/api/products/" + displayInfoId;
    
  
    var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", function () {
		var json = JSON.parse(oReq.responseText);
		
		const productPrices = json.productPrices;
	    const ticketInfoData = [];
		TicketInfo.prototype.displayInfoId = json.displayInfoId;
	    TicketInfo.prototype.productId = json.productId;

	    makeReservationPrice(productPrices, ticketInfoData);

	    makeTicketNumberTemplate(productPrices);
	    registTicketButtonEvent(productPrices, ticketInfoData);

	    registReservationUserEvent();

	    registAgreementToggleEvent();

	    registPostRequestEvent(json.displayInfo, ticketInfoData);
											
	});
	oReq.open("GET", url, true);
	oReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	oReq.send();
    
}

document.addEventListener("DOMContentLoaded", function() {
    requestDisplayInfoData();
});