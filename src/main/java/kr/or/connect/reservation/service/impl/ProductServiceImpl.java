package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	PromotionDao promotionDao;
	
	@Override
	public List<Category> categoryList() {
		List<Category> list = categoryDao.categoryList();
		return list;
	}
	
	@Override
	@Transactional
	public int getCount(Integer categoryId) {
		
			return categoryDao.categoryCount(categoryId);
		
	}


	@Override
	@Transactional
	public List<Product> getProductList(Integer categoryId, Integer start) {

			return productDao.allCategoryList(categoryId, start, LIMIT);
		
	}




	@Override
	@Transactional
	public List<Promotion> getPromotionList() {
		List<Promotion> list = promotionDao.promotionsList();
		return list;
	}

	@Override
	@Transactional
	public int getAllCount() {
		
		return categoryDao.allCount();
	}

	@Override
	@Transactional
	public List<Product> getProductAll(Integer start) {
		
		return productDao.allProductList(start, LIMIT);
	}
}