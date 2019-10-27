<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>예약서비스</title>
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <div id="container">
        <div class="header">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="#" class="lnk_logo" title="네이버">
                    	<span class="spr_bi ico_n_logo">네이버</span>
                    </a>
                    <a class="lnk_logo" title="예약">
                    	<span class="spr_bi ico_bk_logo">예약</span>
                    </a>
                </h1>
                	<a href="./login" class="btn_my">
                			<span class="viewReservation" title="예약확인">예약확인</span>
               		</a>
            </header>
        </div>
        <hr>
        <div class="event">
            <div class="section_visual">
                <div class="group_visual">
                    <div class="container_visual">
                        <div class="prev_e" style="display:none;">
                            <div class="prev_inn">
                                <a href="#" class="btn_pre_e" title="이전">
                                	<i class="spr_book_event spr_event_pre">이전</i>
                                </a>
                            </div>
                        </div>
                        <div class="nxt_e" style="display:none;">
                            <div class="nxt_inn">
                                <a href="#" class="btn_nxt_e" title="다음">
                                	<i class="spr_book_event spr_event_nxt">다음</i>
                                </a>
                            </div>
                        </div>
                        <div>
                            <div class="container_visual">
                                <!-- [D] 이전,다음 버튼을 클릭할때마다 캐러셀 형태로 순환 됨 -->
                                <ul class="visual_img" style="transition-duration: 1s; transform: translateX(0%);">
                                 
								 </ul>
                               </div>
                            <span class="nxt_fix" style="display:none;"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section_event_tab">
                <ul class="event_tab_lst tab_lst_min" >
                	<li class="item" data-category="0" >
                        <a class="anchor active">전체리스트</a>
                    </li>
                </ul>
            </div>
            <div class="section_event_lst">
                <p class="event_lst_txt">바로 예매 가능한 행사가 <span class="pink"> ${totalCount }</span>개 있습니다</p>
                <div class="wrap_event_box">
                    <!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
                    <ul class="lst_event_box" id= "leftUL">
                    	  <c:forEach var="allList" items="${items}" begin="0" end="1" step="1">
		                   <li class="item">
                            	<a href="detail?id=${allList.displayInfoId}" class="item_book">
                                <div class="item_preview"> 
                                	<img alt="${allList.productDescription}" class="img_thumb" src="${allList.productImageUrl}">
                                	<span class="img_border"></span> 
                                </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span>${allList.productDescription}</span><small class="sm">${allList.placeName}</small></h4>
                                    <p class="event_txt_dsc">${allList.productContent}</p>
                                </div>
                            	</a>
                          </li>
	                	</c:forEach>
                    </ul>
                    <ul class="lst_event_box" id="rightUL">
                     	<c:forEach var="allList" items="${items}" begin="2" end="3" step="1">
		                   <li class="item">
                            		<a href="detail?id=${allList.displayInfoId}" class="item_book">
                                <div class="item_preview"> 
                                	<img alt="${allList.productDescription}" class="img_thumb" src="${allList.productImageUrl}">
                                	<span class="img_border"></span> 
                                </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span>${allList.productDescription}</span><small class="sm">${allList.placeName}</small></h4>
                                    <p class="event_txt_dsc">${allList.productContent}</p>
                                </div>
                            	</a>
                          </li>
	                	</c:forEach>
                    </ul>
                    <!-- 더보기 -->
                    <div class="more">
                        <button class="btn" ><span>더보기</span></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="gototop">
            <a href="#" class="lnk_top" > 
            	<span class="lnk_top_text">TOP</span> 
            </a>
        </div>
        <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>
	
    <script type="rv-template" id="promotionItem">
  		<li class="item" style="background-image: url(./{productImageUrl});">
        	<a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
            	<div class="event_txt">
                	<h4 class="event_txt_tit"></h4>
                	<p class="event_txt_adr"></p>
                	<p class="event_txt_dsc"></p>
            	</div>
        	</a>
    	</li>
    </script>
    <script>
    document.addEventListener("DOMContentLoaded",function(){
    		
			promotionAjax("/reservation/api/promotions");
			categoryAjax("/reservation/api/categories");
			
	});
    </script>
	<script>
	function PromotionList(json){
		var html = document.getElementById("promotionItem").innerHTML;
		var length = json.items.length;
		var resultHTML = "";
		var promotionUL = document.querySelector("ul.visual_img");
		
		
		
		for(var i=0; i<length; i++){
			resultHTML += html.replace("{productImageUrl}", json.items[i].productImageUrl);
							
		}
		promotionUL.innerHTML = resultHTML;
	}
	
	
	function promotionAjax(url){
		var oReq = new XMLHttpRequest();
		oReq.addEventListener("load", function () {
			var json = JSON.parse(oReq.responseText);
			PromotionList(json);
			
		});
		oReq.open("GET", url);
		oReq.send();
	}
	
	var promUl=document.querySelector(".visual_img");
	   
	var n = 1100;
	function slide(){
  	  if(n==1100){
  	    n=0;
  	  	promUl.style.transitionDuration="0s";
  	    promUl.style.transform ="translateX(-"+n+"%)";
  	  }
  	  else{
  	    n+=100;  
  	  	promUl.style.transitionDuration="1s";
  	    promUl.style.transform ="translateX(-"+n+"%)";
  	  }
  	  setTimeout(slide,5000);
  	}slide();
   </script>
   <script type="rv-template" id="categoryList">
		<li class="item" data-category="{id}">
			<a class="anchor"> {name} </a>
		</li>
   </script>
   <script type="rv-template" id="itemList">
        <li class="item">
            <a href="detail?id={displayInfoId}" class="item_book">
                <div class="item_preview">
                    <img alt="{productDescription}" class="img_thumb" src="{productImageUrl}">
                    <span class="img_border"></span>
                </div>
                <div class="event_txt">
                    <h4 class="event_txt_tit"> <span>{productDescription}</span> <small class="sm">{placeName}</small> </h4>
                    <p class="event_txt_dsc">{productContent}</p>
                </div>
            </a>
        </li>
    </script>
    <script> 
   	function categoryList(json){
   		var html = document.getElementById("categoryList").innerHTML;
   		var categoryUL = document.querySelector(".event_tab_lst");
   		var resultHTML = "";
   		var length = json.items.length;
   		for (i=0; i<length; i++) {
   			resultHTML += html.replace("{id}", json.items[i].id)
   							  .replace("{name}", json.items[i].name);
   		}
   		categoryUL.innerHTML += resultHTML;
   	}
   	 
	function categoryAjax(url){
		var oReq = new XMLHttpRequest();
		oReq.addEventListener("load", function () {
			var json = JSON.parse(oReq.responseText);
			categoryList(json);
		
		});
		oReq.open("GET", url);
		oReq.send();
	}
	
 	
	
	
	function addProdList(json, type){
		var template = document.querySelector("#itemList").innerText;
		
		var leftUl=document.querySelector("#leftUL");
		var rightUl=document.querySelector("#rightUL");
		var more=document.querySelector(".btn");
		var left="";
		var right=""; 
	
		
		if(type=="all"){
			for(var i=0; i<2; i++){
				left+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
					.replace("{productDescription}",json.items[i].productDescription)
					.replace("{productImageUrl}",json.items[i].productImageUrl)
					.replace("{productDescription}",json.items[i].productDescription)
					.replace("{placeName}",json.items[i].placeName)
					.replace("{productContent}",json.items[i].productContent);
			} 
			for(var i=2; i<4; i++){
				right+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
				.replace("{productDescription}",json.items[i].productDescription)
				.replace("{productImageUrl}",json.items[i].productImageUrl)
				.replace("{productDescription}",json.items[i].productDescription)
				.replace("{placeName}",json.items[i].placeName)
				.replace("{productContent}",json.items[i].productContent);
			}
			leftUl.innerHTML = left;
			rightUl.innerHTML = right;
			more.style.display="";
			
			
		}
		else if(type=="category"){
			for(var i=0; i<2; i++){
				left+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
				.replace("{productDescription}",json.items[i].productDescription)
				.replace("{productImageUrl}",json.items[i].productImageUrl)
				.replace("{productDescription}",json.items[i].productDescription)
				.replace("{placeName}",json.items[i].placeName)
				.replace("{productContent}",json.items[i].productContent);
			} 
			for(var i=2; i<4; i++){
				right+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
				.replace("{productDescription}",json.items[i].productDescription)
				.replace("{productImageUrl}",json.items[i].productImageUrl)
				.replace("{productDescription}",json.items[i].productDescription)
				.replace("{placeName}",json.items[i].placeName)
				.replace("{productContent}",json.items[i].productContent);
			}
			leftUl.innerHTML = left;
			rightUl.innerHTML = right;
			more.style.display="";
			
			
		}
	}
	
	function countProduct(json, cateName){
   		var pink=document.querySelector(".pink");
    	if(cateName=="전체리스트"){
   			pink.innerText=json.totalCount;
   		}
   		else if(cateName=="전시"){
   			pink.innerText=json.totalCount;
   		}
   		else if(cateName=="뮤지컬"){
   			pink.innerText=json.totalCount;
   		}
   		else if(cateName=="콘서트"){
   			pink.innerText=json.totalCount;
   		}
   		else if(cateName=="클래식"){
   			pink.innerText=json.totalCount;
   		}
   		else if(cateName=="연극"){
   			pink.innerText=json.totalCount;
   		} 
   	}
	
	
	function cateAjax(type, sendType, url,cateName){
		var oReq=new XMLHttpRequest();
		oReq.addEventListener("load",function(){
			var json=JSON.parse(this.responseText);
			addProdList(json, type);
			countProduct(json,cateName);
			
		});
		oReq.open(sendType, url,true);
		oReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		oReq.send(sendContent);
	}
	
	
	
	function moreProduct(json, type, startNum){
		var template = document.querySelector("#itemList").innerText;
		
		var leftUl=document.querySelector("#leftUL");
		var rightUl=document.querySelector("#rightUL");
		var left="";
		var right=""; 
		var length=0;
		
		var more=document.querySelector(".btn");
		
				
		if(type=="all"){
			length=json.items.length;
			console.log("길이: "+length);
			console.log(startNum+3);
			
				
				
				if(length==4){
					for(var i=0; i<length-2; i++){
					left+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
					.replace("{productDescription}",json.items[i].productDescription)
					.replace("{productImageUrl}",json.items[i].productImageUrl)
					.replace("{productDescription}",json.items[i].productDescription)
					.replace("{placeName}",json.items[i].placeName)
					.replace("{productContent}",json.items[i].productContent);
						}
					for(var i=2; i<length; i++){
						right+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
						.replace("{productDescription}",json.items[i].productDescription)
						.replace("{productImageUrl}",json.items[i].productImageUrl)
						.replace("{productDescription}",json.items[i].productDescription)
						.replace("{placeName}",json.items[i].placeName)
						.replace("{productContent}",json.items[i].productContent);
						
					}
					leftUl.insertAdjacentHTML('beforeend',left);
					rightUl.insertAdjacentHTML('beforeend',right); 
				}
				else if(length==3){
					

					for(var i=0; i<length-1; i++){
						left+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
						.replace("{productDescription}",json.items[i].productDescription)
						.replace("{productImageUrl}",json.items[i].productImageUrl)
						.replace("{productDescription}",json.items[i].productDescription)
						.replace("{placeName}",json.items[i].placeName)
						.replace("{productContent}",json.items[i].productContent);
							}
						for(var i=2; i<length; i++){
							right+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
							.replace("{productDescription}",json.items[i].productDescription)
							.replace("{productImageUrl}",json.items[i].productImageUrl)
							.replace("{productDescription}",json.items[i].productDescription)
							.replace("{placeName}",json.items[i].placeName)
							.replace("{productContent}",json.items[i].productContent);
							
						}
						leftUl.insertAdjacentHTML('beforeend',left);
						rightUl.insertAdjacentHTML('beforeend',right); 
						
						}
					if(startNum+3 >= json.totalCount){
						more.style.display="none";
				}
			}
						 
			
		else if(type=="category"){
			length=json.items.length
			console.log("길이: "+length);
			console.log(startNum+3);
			
			if(length==4){
				for(var i=0; i<length-2; i++){
				left+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
				.replace("{productDescription}",json.items[i].productDescription)
				.replace("{productImageUrl}",json.items[i].productImageUrl)
				.replace("{productDescription}",json.items[i].productDescription)
				.replace("{placeName}",json.items[i].placeName)
				.replace("{productContent}",json.items[i].productContent);
					}
				for(var i=2; i<length; i++){
					right+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
					.replace("{productDescription}",json.items[i].productDescription)
					.replace("{productImageUrl}",json.items[i].productImageUrl)
					.replace("{productDescription}",json.items[i].productDescription)
					.replace("{placeName}",json.items[i].placeName)
					.replace("{productContent}",json.items[i].productContent);
					
				}
				leftUl.insertAdjacentHTML('beforeend',left);
				rightUl.insertAdjacentHTML('beforeend',right); 
			}
			else if(length == 2){
				for(var i=0; i<length-1; i++){
					left+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
					.replace("{productDescription}",json.items[i].productDescription)
					.replace("{productImageUrl}",json.items[i].productImageUrl)
					.replace("{productDescription}",json.items[i].productDescription)
					.replace("{placeName}",json.items[i].placeName)
					.replace("{productContent}",json.items[i].productContent);
						}
					for(var i=1; i<length; i++){
						right+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
						.replace("{productDescription}",json.items[i].productDescription)
						.replace("{productImageUrl}",json.items[i].productImageUrl)
						.replace("{productDescription}",json.items[i].productDescription)
						.replace("{placeName}",json.items[i].placeName)
						.replace("{productContent}",json.items[i].productContent);
						
					}
					leftUl.insertAdjacentHTML('beforeend',left);
					rightUl.insertAdjacentHTML('beforeend',right); 
				
					}

			
			else if(length ==1) {
				for(var i=0; i<length; i++){
					right+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
					.replace("{productDescription}",json.items[i].productDescription)
					.replace("{productImageUrl}",json.items[i].productImageUrl)
					.replace("{productDescription}",json.items[i].productDescription)
					.replace("{placeName}",json.items[i].placeName)
					.replace("{productContent}",json.items[i].productContent);
						}
					for(var i=1; i<length; i++){
						left+=template.replace("{displayInfoId}",json.items[i].displayInfoId)
						.replace("{productDescription}",json.items[i].productDescription)
						.replace("{productImageUrl}",json.items[i].productImageUrl)
						.replace("{productDescription}",json.items[i].productDescription)
						.replace("{placeName}",json.items[i].placeName)
						.replace("{productContent}",json.items[i].productContent);
						
					}
					leftUl.insertAdjacentHTML('beforeend',left);
					rightUl.insertAdjacentHTML('beforeend',right); 
					
					}
				if(startNum+3 >= json.totalCount){
					more.style.display="none";
			}
		}
	}


			
	
		 
		
	var type="all";
 	function moreProductAjax(url, startNum){
		var oReq=new XMLHttpRequest();
		oReq.addEventListener("load",function(){
			var json=JSON.parse(this.responseText);
			moreProduct(json, type, startNum);
			console.log("sn: "+startNum);
		});
		oReq.open("POST", url, true);
		oReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		oReq.send(sendContent+"&start="+startNum);
 	}
 	
 	var startNum=0;
 	var btn=document.querySelector(".btn");
   	btn.addEventListener("click", function(){
		startNum+=4;
   	   	moreProductAjax("/reservation/api/products", startNum);
   	}); 

   	var sendContent="";
	var cateTab=document.querySelector(".event_tab_lst");
	cateTab.addEventListener("click", function(e){
		//startNum 초기화
		startNum=0;
		
        if (e.target.tagName === "A") {
        	console.log(e.target.innerText);
    		
        	//카테고리 active
    		var anchor=document.querySelectorAll(".anchor");
    		for(var i=0, len=anchor.length; i<len; i++ ){
    			anchor[i].classList.remove("active");
    		}
        	e.target.classList.add("active");
        	
        	//카테고리 ajax
            if(e.target.innerText=="전체리스트"){
            	type="all";
 				sendContent="";
 				cateAjax("all", "GET", "/reservation/api/products", e.target.innerText);
 				
        	}
            else if(e.target.innerText=="전시"){
            	type="category";
 				sendContent="categoryId=1";
 				cateAjax("category", "POST", "/reservation/api/products", e.target.innerText);
 				
        	}
        	else if(e.target.innerText=="뮤지컬"){
            	type="category";
            	sendContent="categoryId=2";
            	cateAjax("category", "POST", "/reservation/api/products", e.target.innerText);
            	
        	}
        	else if(e.target.innerText=="콘서트"){
            	type="category";
            	sendContent="categoryId=3";
            	cateAjax("category", "POST", "/reservation/api/products", e.target.innerText);
            	
        	}
			else if(e.target.innerText=="클래식"){
            	type="category";
            	sendContent="categoryId=4";
            	cateAjax("category", "POST", "/reservation/api/products", e.target.innerText);
            	
        	}
			else if(e.target.innerText=="연극"){
            	type="category";
            	sendContent="categoryId=5";
            	cateAjax("category", "POST", "/reservation/api/products", e.target.innerText);
            	
        	}
         }	 
	});
    
  
   
    </script>
   </body>
</html>