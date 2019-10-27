package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.Promotion;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class ProductDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Product> Product_rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
    private RowMapper<ProductPrice> ProductPrice_rowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);

    

    
    public ProductDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Product> allProductList(Integer start, Integer limit){
		Map<String,Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		
		return jdbc.query(ALL_PRODUCT, params, Product_rowMapper);
		
	}
	
	public List<Product> allCategoryList(Integer categoryId, Integer start, Integer limit){
		Map<String,Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		
		return jdbc.query(CATE_PRODUCT, params,Product_rowMapper);
	}

	public ProductPrice getProductPrice(int productPriceId) {
		Map<String, Integer> params = new HashMap<>();
        params.put("productPriceId", productPriceId);

        return jdbc.queryForObject(GET_PRODUCT_PRICE, params, ProductPrice_rowMapper);
	}
}