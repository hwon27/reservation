<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>네이버 예약</title>
<link href="css/style.css" rel="stylesheet">
    <style>
        .container_visual {
            height: 414px;
        }
    </style>
</head>
<body>
<div id="container">
        <div class="header fade">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="./mainpage.jsp" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="./mainpage.jsp" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a href="#" class="btn_my"> <span title="예약확인">예약확인</span> </a>
            </header>
        </div>
        <div class="ct main">
            <div>
                <div class="section_visual">
                    <header>
                        <h1 class="logo">
                            <a href="./mainpage" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                            <a href="./mainpage" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                        </h1>
                        <a href="./myreservation.html" class="btn_my"> <span class="viewReservation" title="예약확인">예약확인</span> </a>
                    </header>
                    <p id="displayInfoId" style="display:none">${displayInfoId}</p>
                    <div class="pagination">
                       <div class="bg_pagination"></div>
                        <div class="figure_pagination">
                          	<span class="num">1</span>
                          		<span class="num off">/ <span class= "num2">2</span></span>
						</div>
                    	</div>
                    <div class="group_visual">
                        <div>
                            <div class="container_visual" style="width: 414px;">
                                <ul class="visual_img detail_swipe" style="transition-duration: 1s;">
                                
                                </ul>
                            </div>
                            <div class="prev">
                                <div class="prev_inn">
                                    <a href="#" class="btn_prev" title="이전">
                                        <!-- [D] 첫 이미지 이면 off 클래스 추가 -->
                                        <i class="spr_book2 ico_arr6_lt off"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="nxt">
                                <div class="nxt_inn">
                                    <a href="#" class="btn_nxt" title="다음">
                                        <i class="spr_book2 ico_arr6_rt"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="group_btn_goto"  style="display: none;">
                        <a class="btn_goto_home" title="홈페이지" href="#" target="siteUrl"> <i class="fn fn-home1"></i> </a>
                        <a class="btn_goto_tel" title="전화" href="#"> <i class="fn fn-call1"></i> </a>
						<a class="btn_goto_mail" title="이메일" href="#"> <i class="fn fn-mail1"></i> </a>
                        <a href="#" class="btn_goto_path" title="길찾기"> <i class="fn fn-path-find1"></i> </a>
                        <a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
                    </div>
                </div>
                <div class="section_store_details">
                    <!-- [D] 펼쳐보기 클릭 시 store_details에 close3 제거 -->
                    <div class="store_details close3">
                        <p class="dsc"> </p>
                    </div>
                    <!-- [D] 토글 상황에 따라 bk_more에 display:none 추가 -->
                    <div class="button">
                    <a class="bk_more _open"> <span class="bk_more_txt">펼쳐보기</span> <i class="fn fn-down2"></i> </a>
                    <a class="bk_more _close" style="display: none;"> <span class="bk_more_txt">접기</span> <i class="fn fn-up2"></i> </a>
                    </div>
                </div>
                <div class="section_event">
                    <div class="event_info_box">
                        <div class="event_info_tit">
                            <h4 class="in_tit"> <i class="spr_book ico_evt"></i> <span>이벤트 정보</span> </h4>
                        </div>
                        <div class="event_info">
                      		<div class="in_dsc">[네이버예약 특별할인]<br>R석 50%, S석 60% 할인</div>
                            
                        </div>
                    </div>
                </div>
                <div class="section_btn"> <button type="button" class="bk_btn"> <i class="fn fn-nbooking-calender2"></i> <span>예매하기</span> </button> </div>
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <div class="grade_area">
                                <!-- [D] 별점 graph_value는 퍼센트 환산하여 width 값을 넣어줌 -->
                                <span class="graph_mask"> <em class="graph_value" style="width: 84%; vertical-align: text-top;"></em> </span>
                                <strong class="text_value"> <span id="averageScore">3.0</span> <em class="total">5.0</em> </strong>
                                <span class="join_count"><em class="green">52건</em> 등록</span>
                            </div>
                            <ul class="list_short_review">
                                 <c:forEach var="comm" items="${comment}" begin="0" end="2" step="1">	
                 	           <li class="list_item">
                                    <div>
                                        <div class="review_area">
                                        <c:forEach var="commImg" items="${commentImage}" begin="0" end="2" step="1">
                                         <c:if test="${commImg.reservationUserCommentId==comm.commentId}">
                                           	<div class="thumb_area">
                                                <a href="#" class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="${commImg.saveFileName }" alt="리뷰이미지"> </a> <span class="img_count" >1</span>
                                             </div>
                                             </c:if>
                                             </c:forEach>
                                           	  <h4 class="resoc_name"></h4>
                                            <p class="review">${comm.comment}</p>
                                        </div>
                                        <div class="info_area">
                                            <div class="review_info"> 
                                            <span class="grade">${comm.score+".0"}</span> 
                                            <span class="name"> ${fn:substring(comm.reservationEmail,0,4)}****</span>
                                            <span class="date">${fn:substring(comm.createDate,0,10)} 방문</span> </div>
                                        </div>
                                    </div>
                                </li>
                              </c:forEach>
                             </ul>
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                    <a class="btn_review_more" href="./review?id=${displayInfoId}"> <span>예매자 한줄평 더보기</span> <i class="fn fn-forward1"></i> </a>
                </div>
                <div class="section_info_tab">
                    <!-- [D] tab 선택 시 anchor에 active 추가 -->
                    <ul class="info_tab_lst">
                        <li class="item active _detail">
                            <a class="anchor active" id="detail_tab"><span>상세정보</span></a>
                        </li>
                        <li class="item _path">
                            <a class="anchor" id="path_tab"><span>오시는길</span></a>
                        </li>
                    </ul>
                  </div>
                  
            </div>
        </div>
    </div>
    <footer>
        <div class="gototop">
            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
        </div>
        <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>
    <div class="displayInfoId" id="${displayInfoId}"></div>
    <div id="photoviwer"></div>
    <script>
    document.addEventListener("DOMContentLoaded",function(){
    		 var displayInfoId = ${displayInfoId}
			detailAjax("./api/products/${displayInfoId}");
			
	});
    </script>
   	
	
	
	
   <script type="rv-template" id="etImageList">
    <li class="item" style="width: 414px; height: -webkit-fill-available;"> <img style="height: -webkit-fill-available;" class="img_thumb" src="{{saveFileName}}"> <span class="img_bg"></span>
    <div class="visual_txt">
	</script>
	<script type="rv-template" id="etImageList2">
        <div class="visual_txt_inn">
            <h2 class="visual_txt_tit"> <span>{{productDescription}}</span> </h2>
            <p class="visual_txt_dsc"></p>
        </div>
    </div>
	</li>
	</script>
	<script type="rv-template" id="detail">
    <div class="detail_area_wrap">
        <div class="detail_area">
            <div class="detail_info">
                <h3 class="blind">상세정보</h3>
                <ul class="detail_info_group">
                    <li class="detail_info_lst"><strong class="in_tit">[소개]</strong>
                        <p class="in_dsc">{{productContent}}</p></li>
                    <li class="detail_info_lst"><strong class="in_tit">[공지사항]</strong>
                        <ul class="in_img_group">
                            <li class="in_img_lst"><img alt="" class="img_thumb"
                                                        src="https://ssl.phinf.net/naverbooking/20170131_238/14858250829398Pnx6_JPEG/%B0%F8%C1%F6%BB%E7%C7%D7.jpg?type=a1000">
                            </li>
                        </ul>
                    </li>
                 </ul>
            </div>
        </div>
    </div>
	</script>
	<!-- 오시는길 템플릿-->
	<script type="rv-template" id="path">
    <div class="detail_location hide">
        <div class="box_store_info no_topline">
            <a href="#" class="store_location" title="지도웹으로 연결"> <img
                    class="store_map img_thumb" alt="map"
                    src="{{saveFileName}}">
                <span class="img_border"></span> <span class="btn_map"><i
                        class="spr_book2 ico_mapview"></i></span>
            </a>
            <h3 class="store_name">{{productDescription}}</h3>
            <div class="store_info">
                <div class="store_addr_wrap">
                    <span class="fn fn-pin2"></span>
                    <p class="store_addr store_addr_bold">{{placeStreet}}</p>
                    <p class="store_addr">
                        <span class="addr_old">지번</span> <span class="addr_old_detail">{{placeLot}}</span>
                    </p>
                    <p class="store_addr addr_detail">{{placeName}}</p>
                </div>
                <div class="lst_store_info_wrap">
                    <ul class="lst_store_info">
                        <li class="item"><span class="item_lt"> <i
                                class="fn fn-call2"></i> <span class="sr_only">전화번호</span>
										</span> <span class="item_rt"> <a href="tel:{{telephone}}"
                                                                          class="store_tel">{{telephone}}</a></span>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="bottom_common_path column2">
                <a href="#" class="btn_path"> <i class="fn fn-path-find2"></i>
                    <span>길찾기</span>
                </a> <a href="#" class="btn_navigation before"> <i
                    class="fn fn-navigation2"></i> <span>내비게이션</span>
            </a>
            </div>
        </div>
   	</div>
	</script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>
 	<script>
	//탭전환
		var info=document.querySelector(".section_info_tab");
		info.addEventListener("click", function(e){
			console.log(e.target.tagName);
			var detail = document.querySelector("#detail_tab");
	        var path = document.querySelector("#path_tab");
	        
	     	var detailArea = document.querySelector(".detail_area_wrap");
     	var detailLocation = document.querySelector(".detail_location");
     	
     	if(e.target.className ==="._detail" || e.target.parentElement.id ==="detail_tab"){
     		  if (detail.classList.contains("active") === false) {
                  detail.classList.add("active");
                  path.classList.remove("active");
                  // 상세보기 보이기
                  detailArea.classList.remove("hide");
                  detailLocation.classList.add("hide");
     		  }
     	}else if(e.target.className ==="._path" || e.target.parentElement.id ==="path_tab") {
     		 if (path.classList.contains("active") === false) {
                 path.classList.add("active");
                 detail.classList.remove("active");
                 // 오시는길 보이기
                 detailLocation.classList.remove("hide");
                 detailArea.classList.add("hide");
             }
     	}
	     });
		const reserveButton = document.querySelector(".bk_btn");
	    reserveButton.addEventListener("click", function(){
	    	var displayInfoId = document.querySelector(".displayInfoId").id;
	        location.href = "/reservation/booking/form/" + displayInfoId;
	    	
	    });
	
		
 	
 	var detailUl=document.querySelector(".visual_img");	
 	  function addImageTemplate(json){		
    	var etTempl=document.querySelector("#etImageList").innerText;
   		var etTempl2=document.querySelector("#etImageList2").innerText;
   		var etBindTempl=Handlebars.compile(etTempl);
   		var etBindTempl2=Handlebars.compile(etTempl2);
   			
   		
   		var prodHTML=etBindTempl(json.productImages[0]);
		prodHTML+=etBindTempl2(json.displayInfo);
		
        var etHTML=json.productImages.reduce(function(prev){ 
           return prev+etBindTempl(json.productImages[1])+etBindTempl2(json.displayInfo);
       },"");
       
        detailUl.insertAdjacentHTML('beforeend',prodHTML);
		detailUl.insertAdjacentHTML('beforeend',etHTML);
	}
 	
    
    function productContent(json){
    	var productContent = json.displayInfo.productContent;
   		var storeDetail = document.querySelector(".store_details > .dsc");
   		storeDetail.innerText = productContent;
   		var productEvent = json.displayInfo.productEvent;
   		var storeEvent = document.querySelector(".event_info > .in_dsc");		
   		storeEvent.innerText = productEvent;
   		
    }
    
    function averageScore(json){
    	var avgScoreTemplate = document.querySelector("#averageScore");
    	var scoreGraph = document.querySelector(".graph_value");
    	var avgScore = json.averageScore;
    	var commCount = json.comments.length;
    	var commTemplate = document.querySelector(".green");
    	
    	commTemplate.innerText = commCount + "건";
    	
    	if(avgScore == "Nan" ) {
    		avgScoreTemplate.innerText = "0.0";
    		scoreGraph.style.width = "0%";
    	}else {
    		avgScore = (avgScore).toFixed(1);
    		avgScoreTemplate.innerText = avgScore;
    		scoreGraph.style.width = avgScore * 20 + "%";
    	}
    	
    }
     function information(json){
    	 var sectionInfoTab = document.querySelector(".section_info_tab");
    	 var resultHTML="";
    	 var displayInfo = json.displayInfo;
    	 var displayInfoImage = json.displayInfoImage;
    	 var data = {
    			 "productContent" : displayInfo.productContent,
    			 "productDescription": displayInfo.productDescription,
    	         "placeStreet": displayInfo.placeStreet,
    	         "placeLot": displayInfo.placeLot,
    	         "placeName": displayInfo.placeName,
    	         "telephone": displayInfo.telephone,
    	         "saveFileName": displayInfoImage.saveFileName
    	 };
    	 
    	 var detailInfoContainer = document.querySelector("#detail").innerHTML;
    	 var detailInfoTemplate = Handlebars.compile(detailInfoContainer);
    	 resultHTML = detailInfoTemplate(data);
    	 sectionInfoTab.innerHTML += resultHTML;
    	 
    	 var pathContainer = document.querySelector("#path").innerHTML;
    	 var pathTemplate = Handlebars.compile(pathContainer);
    	 resultHTML = pathTemplate(data);
    	 sectionInfoTab.innerHTML += resultHTML;
     }
    
    
    
    var pageUl=document.querySelector(".num2");	
 	function pageCount(json) {
 		var totalCount = json.productImages.length;
 		
 		var leftBtn=document.querySelector(".btn_prev");
 		var rightBtn=document.querySelector(".btn_nxt");
 		console.log(totalCount);
 		if(totalCount > 1){
 			pageUl.innerHTML = "2"
 		}else {
 			pageUl.innerHTML = "1"
 			leftBtn.style.display = "none";
 			rightBtn.style.display = "none";
 		}
 	}
 	var commentUl = document.querySelector(".list_short_review");
 	
 
 	
 	var etcnt=1;
 	var etMargin=0;
 	var promNum=document.querySelector(".num");
 	var leftBtn=document.querySelector(".btn_prev");
 	var lefticon=document.querySelector(".btn_prev i");
 	var rightBtn=document.querySelector(".btn_nxt");
 	var righticon=document.querySelector(".btn_nxt i");
 	
	leftBtn.addEventListener("click",function(){
		if(etcnt==2){
 			lefticon.classList.add("off"); 
 			righticon.classList.remove("off"); 
 			
			etcnt--;
			etMargin-=100;
	
			promNum.innerText=etcnt;
			detailUl.style.marginLeft ="-"+etMargin+"%";
		}
	});	
 	
 	rightBtn.addEventListener("click", function(){
 		if(etcnt==1){
 			lefticon.classList.remove("off"); 
 			righticon.classList.add("off"); 
 			
 	 		etcnt++;
 	 		etMargin+=100;  
 	 		
 	 		promNum.innerText=etcnt;
 			detailUl.style.marginLeft ="-"+etMargin+"%";
 		}
 		
   	}); 
 	
 	function detailAjax(url){
		var oReq = new XMLHttpRequest();
		oReq.addEventListener("load", function () {
			var json = JSON.parse(oReq.responseText);
				addImageTemplate(json);
				pageCount(json);
				productContent(json);
				averageScore(json);
				information(json);
												
		});
		oReq.open("GET", url, true);
		oReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		oReq.send();
	}
 	
 		var btn=document.querySelector(".button");
 		var open = document.querySelector("._open");
 		var close =  document.querySelector("._close");
 	
   		btn.addEventListener("click", function(e){
   		var detail = document.querySelector(".store_details");
   		 
   		console.log(e.target.className);
   		if(close.style.display == "none") {
   			detail.classList.remove("close3");
   			close.style.display = "";
   			open.style.display = "none";
   			
   		}
   		else if(open.style.display == "none") {
   			detail.classList.add("close3");
   			close.style.display = "none";
   			open.style.display = "";
   		}
   	});
   		
   		
   
 	</script>
 	
</body>
</html>