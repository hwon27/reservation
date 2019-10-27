package kr.or.connect.reservation.controller;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.DisplayInfoResponse;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ProductResponse;
import kr.or.connect.reservation.dto.ReservationParam;
import kr.or.connect.reservation.dto.ReservationResponse;
import kr.or.connect.reservation.service.DetailService;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.impl.DetailServiceImpl;
import kr.or.connect.reservation.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductApiController {
    @Autowired
    private ProductService productsService;

    @Autowired
    private DetailService detailService;

    // 메인페이지 카테고리에 따른 상품 목록 API

	@RequestMapping(value="/api/products", method = {RequestMethod.GET, RequestMethod.POST}) 
	public ProductResponse productApi (@RequestParam(name="categoryId", required=false, defaultValue="0") int categoryId,
										@RequestParam(name="start", required=false, defaultValue="0") int start)  {
		List<Product> productList = null;
		int count  = 0;
				
		if(categoryId != 0) {
			productList = productsService.getProductList(categoryId, start);
			count = productsService.getCount(categoryId);
		}
		else {	
			productList =  productsService.getProductAll(start);
			count = productsService.getAllCount();
		}
	
		
		
		ProductResponse productResponse = new ProductResponse();
		
		productResponse.setItems(productList);
		productResponse.setTotalCount(count);
		
		
		return productResponse;
	}

	@RequestMapping(value="/api/products/{displayInfoId}", method = {RequestMethod.GET, RequestMethod.POST}) 
	public DisplayInfoResponse detailApi(@PathVariable(name="displayInfoId") int displayInfoId) {

		
		double averageScore = detailService.getAverageScore(displayInfoId);
        List<Comment> commentsList = detailService.getComments(displayInfoId);
        
        DisplayInfo displayInfo = detailService.getDisplayInfo(displayInfoId);
        DisplayInfoImage displayInfoImage = detailService.getDisplayInfoImage(displayInfoId);
        List<ProductImage> productImagesList = detailService.getProductImages(displayInfoId);
        List<ProductPrice> productPrices = detailService.getProductPrices(displayInfoId);

        DisplayInfoResponse displayInfoResponse = new DisplayInfoResponse();
        displayInfoResponse.setAverageScore(averageScore);
        displayInfoResponse.setComments(commentsList);
        
        displayInfoResponse.setDisplayInfo(displayInfo);
        displayInfoResponse.setDisplayInfoImage(displayInfoImage);
        displayInfoResponse.setProductImages(productImagesList);
        displayInfoResponse.setProductPrices(productPrices);

       

        return displayInfoResponse;
	}
	
}