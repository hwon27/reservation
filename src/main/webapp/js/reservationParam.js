function ReservationParam() {

}

ReservationParam.prototype = {
    makeReservationParam: function (displayInfo) {
        const reservationParam = {
            displayInfoId: 0,
            prices: [],
            productId: 0,
            reservationEmail: "",
            reservationName: "",
            reservationTelephone: "",
            reservationYearMonthDay: ""
        };

        reservationParam.displayInfoId = displayInfo.displayInfoId;
        const priceNodes = document.querySelectorAll("input[name=price]");
        priceNodes.forEach((priceNode) => {
            reservationParam.prices.push(priceNode.defaultValue);
        });
        reservationParam.productId = displayInfo.productId;
        reservationParam.reservationEmail = document.querySelector("#email").value;
        reservationParam.reservationName = document.querySelector("#name").value;
        reservationParam.reservationTelephone = document.querySelector("#tel").value;
        reservationParam.reservationYearMonthDay = TicketInfo.prototype.reservationYearMonthDay;

        return reservationParam
    }
};
    
            
        

   

