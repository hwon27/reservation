package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;

import java.util.List;

public interface ProductService {
    Integer LIMIT = 4;

    public List<Category> categoryList();
	
	public int getAllCount();
	
	public int getCount(Integer categoryId);
	
	public List<Product> getProductAll (Integer start);
	
	public List<Product> getProductList(Integer categoryId, Integer start);
	
	public List<Promotion> getPromotionList();
}