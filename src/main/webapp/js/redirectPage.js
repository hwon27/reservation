function RedirectPage() {

}


  	function  requestReservationInfoResponse (reservationUserEmail) {
        
            const url = "/reservation/api/reservations?reservationEmail=" + reservationUserEmail;
            
        	var oReq=new XMLHttpRequest();
    		oReq.addEventListener("load",function(){
    		var json=JSON.parse(this.responseText);
    		if(json.size !==0) {
    			 redirectReservationListPage();
    		}else {
    			redirectNonListPage();
    		}	
    		
    		});
    		oReq.open("GET", url, true);
    		oReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    		oReq.send();
  		
            
    }
   function redirectNonListPage () {
        alert("예약 내역이 없습니다.");
    }
   function redirectReservationListPage () {
        const inputEmailForm = document.querySelector("#form1");
        inputEmailForm.submit();
    }
   
