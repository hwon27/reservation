package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;
import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	
	public CategoryDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> categoryList(){
		return jdbc.query(CATEGORYS, rowMapper);
	}
	
	public int allCount() {
		return jdbc.queryForObject(ALL_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	public int categoryCount(Integer categoryId) {
		Map<String,Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		
		return jdbc.queryForObject(CATE_COUNT, params,Integer.class);
	}
}