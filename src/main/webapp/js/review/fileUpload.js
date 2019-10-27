function FileUpload() {

}

FileUpload.prototype = {
    validImageType: function (image) {
        let isValid = (/^([a-zA-Z0-9\s_\\.\-\(\):])+(.jpg|.png)$/).test(image.type);
        return isValid;
    },
    showThumbNail: function (image) {
        // File Reader 객체 생성
        const fileReader = new FileReader();
        fileReader.readAsDataURL(image);

        // 이미지 정보 노출
        const thumbNailImage = document.querySelector(".item_thumb");
        fileReader.onloadend = function()  {
            thumbNailImage.src = fileReader.result;
        };

        const thumbNailList = document.querySelector(".item");
        thumbNailList.style.display = "inline-block";
    },
    removeThumbNail: function () {
        const thumbNailImage = document.querySelector(".item_thumb");
        thumbNailImage.src = "";

        const thumbNailList = document.querySelector(".item");
        thumbNailList.style.display = "none";
    },
    requestReview: function () {
        const file = document.querySelector("#reviewImageFileOpenInput").files[0];
        const url = makeRequestDateUrl();
        const formData = new FormData();
        formData.append("reviewImg", file);

        var oReq=new XMLHttpRequest();
    	oReq.addEventListener("load",function(){
    		var json=JSON.parse(this.responseText);
    		
    		 makeReservationListCard(json);

    		 registRequestCancelEvent();
    		
    	});
    	oReq.open("POST", url, true);
    	oReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    	oReq.send(formData);
        

       
    },
    redirectReservationListPage: function () {
        window.location.href = document.querySelector(".btn_back").href;
    }
};