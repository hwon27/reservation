package kr.or.connect.reservation.controller;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.PromotionResponse;
import kr.or.connect.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PromotionApiController {
    @Autowired
    private ProductService productsService;

    @GetMapping("/promotions")
    public PromotionResponse promotions(){
    	List<Promotion> list = productsService.getPromotionList();
		
		PromotionResponse promotion = new PromotionResponse();
		promotion.setItems(list);
		
		return promotion;
	}
    
}