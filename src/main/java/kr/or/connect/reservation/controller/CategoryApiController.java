package kr.or.connect.reservation.controller;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.CategoryResponse;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CategoryApiController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value ="/api/categories", method = {RequestMethod.GET, RequestMethod.POST})
    public CategoryResponse categories(){
    	List<Category> list = productService.categoryList();
		
		CategoryResponse category = new CategoryResponse();
		category.setItems(list);
		
		return category;
    }
}