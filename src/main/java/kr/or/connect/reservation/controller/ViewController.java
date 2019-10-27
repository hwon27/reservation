package kr.or.connect.reservation.controller;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.DisplayInfoResponse;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.DetailService;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class ViewController {
	 @Autowired
	 private ProductService productsService;
	 @Autowired
	 private DetailService detailService;
	 @Autowired
	 ReservationService reservationService;
	 
	 @RequestMapping(value = "/mainpage", method = {RequestMethod.GET, RequestMethod.POST}) 
		public String mainList(@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
	            				@RequestParam(name = "start", required = false, defaultValue = "0") int start,
	            				Model model) {	
			
			List<Category> categoryList = productsService.categoryList();
			int totalCount = productsService.getAllCount();
			List<Product> productList = productsService.getProductAll(start);
			List<Promotion> promotionImg = productsService.getPromotionList();
			
			
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("totalCount",totalCount);
			model.addAttribute("items", productList);
			model.addAttribute("promotionImg", promotionImg);
			
			
			return "mainpage";
		}
	 
	 @RequestMapping(value = "/detail" , method = {RequestMethod.GET, RequestMethod.POST})
	 public String productDetail(@RequestParam(name = "id") int displayInfoId, 	Model model) {
		
		DisplayInfo displayInfo = detailService.getDisplayInfo(displayInfoId);
		DisplayInfoImage displayInfoImg = detailService.getDisplayInfoImage(displayInfoId);
		List<Comment> comment = detailService.getComments(displayInfoId);
		List<CommentImage> commentImage = detailService.getCommentImages(displayInfoId);
		

		model.addAttribute("displayInfoId", displayInfoId);
		model.addAttribute("displayInfo", displayInfo);
		model.addAttribute("displayInfoImage", displayInfoImg);
		model.addAttribute("comment", comment);
		model.addAttribute("commentImage", commentImage);
	

        return "detail";
    }

	 	@RequestMapping(value="/review", method= {RequestMethod.GET,RequestMethod.POST})
		public String reviewDetail(@RequestParam(name="id") int displayInfoId, Model model) {
			
			List<Comment> comment = detailService.getComments(displayInfoId);
			List<CommentImage> commentImage = detailService.getCommentImages(displayInfoId);
			
			model.addAttribute("displayInfoId", displayInfoId);
			model.addAttribute("comment", comment);
			model.addAttribute("commentImage", commentImage);
			
			
			return "review";
		}
	    
	    @RequestMapping(value="/booking/form/{displayInfoId}", method= {RequestMethod.GET, RequestMethod.POST})
	    public String showReservationForm(@PathVariable int displayInfoId,
	                                      Model model) {
	       
	       
	    	List<ProductImage> productImagesList = detailService.getProductImages(displayInfoId);
	        DisplayInfo displayInfo = detailService.getDisplayInfo(displayInfoId);
	        model.addAttribute("displayInfo", displayInfo);
	        model.addAttribute("displayInfoResponse", productImagesList);

	        return "reserve";
	    }
	    
	    @GetMapping("/login")
	    public String loginPage() {
	        return "login";
	    }

	    @GetMapping("/booking/list")
	    public String showBookingList(@RequestParam String reservationEmail, Model model, HttpSession httpSession) {

	        if (httpSession.getAttribute("reservationEmail") == null) {
	            httpSession.setAttribute("reservationEmail", reservationEmail);
	        }

	        model.addAttribute("reservationEmail", reservationEmail);

	        return "myreservation";
	    }
	    
	    @GetMapping("/reviewWriteForm")
	    public String reviewWriteForm(@RequestParam Integer reservationInfoId, Model model) throws Exception {
	        ReservationInfo reservationInfo = reservationService.getReservationInfo(reservationInfoId);
	        model.addAttribute("reservationInfo", reservationInfo);

	        return "reviewWrite";
	    }
	    
	    

}
