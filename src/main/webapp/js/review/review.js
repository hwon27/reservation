function registRatingEvent () {
    const rating = document.querySelector(".rating");
    rating.addEventListener("click", function(evt)  {
        if (evt.target.classList.contains("rating_rdo")) {
            const ratingScore = new RatingScore();
            RatingScore.prototype.score = evt.target.value;
            ratingScore.changeScore();
            ratingScore.offStar();
            ratingScore.onStar();
        }
    });
};

function registTextAreaEvent()  {
    const reviewContents = document.querySelector(".review_contents");
    reviewContents.addEventListener("click", function(evt) {
        if (evt.currentTarget.classList.contains("review_contents")) {
            // placeholder 없애기
            TextArea.prototype.removePlaceholder();

            const textArea = document.querySelector(".review_textarea");
            textArea.focus();
            textArea.addEventListener("keyup", function(evt)  {
                // 글자수 표시
                TextArea.prototype.changeTextLength(textArea.value.length);
                // 글자수 제한
                TextArea.prototype.restrictTextLength(evt);
                // 리뷰 등록전 글자수 확인
                TextArea.prototype.checkTextArea(evt);
            });
        }
    });

    // TextArea Focus를 잃었을경우
    const reviewTextArea = document.querySelector(".review_textarea");
    reviewTextArea.addEventListener("focusout", function(evt) {
        const textValue = evt.target.value;
        if (textValue === "" || textValue === null) {
            TextArea.prototype.showPlaceholder();
        }
    });
};

const makeRequestDateUrl = () => {
    const reservationInfoId = document.querySelector("input[name=reservationInfoId]").value;
    const comment = document.querySelector(".review_textarea").value;
    const productId = document.querySelector("input[name=productId]").value;
    const score = document.querySelector(".star_rank").innerText;

    const requestUrl = "/reservation/api/reservations/" + reservationInfoId + "/comments?" +
        "comment=" + comment +
        "&productId=" + productId +
        "&score=" + score;

    return requestUrl;
};

function registFileUploadEvent  () {
    const fileInputTag = document.querySelector("#reviewImageFileOpenInput");
    fileInputTag.addEventListener("change", function(evt) {
        const image = evt.target.files[0];

        if (!FileUpload.prototype.validImageType(image)) {
            alert("유효하지 않은 형식입니다.");
        } else {
            FileUpload.prototype.showThumbNail(image);
        }
    });

    const cancelImageUploadButton = document.querySelector(".anchor");
    cancelImageUploadButton.addEventListener("click", function() {
        FileUpload.prototype.removeThumbNail();
        // 썸네일 이미지 값 지우기
        const thumbNailImage = document.querySelector("#reviewImageFileOpenInput");
        thumbNailImage.value = "";
    });
};

function reviewRegistEvent ()  {
    const button = document.querySelector(".bk_btn");
    button.addEventListener("click", function()  {
        if (TextArea.prototype.textIsValid && RatingScore.prototype.score > 0) {
            FileUpload.prototype.requestReview();
            FileUpload.prototype.redirectReservationListPage();
        } else if(RatingScore.prototype.score > 0){
            alert("5자 이상 입력해주세요.");
        } else {
            alert("점수를 매겨 주세요.");
        }
    });
};

document.addEventListener("DOMContentLoaded", function() {
    registRatingEvent();
    registTextAreaEvent();
    registFileUploadEvent();
    reviewRegistEvent();
});