package kr.or.connect.reservation.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.PromotionResponse;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;;


@Repository
public class PromotionDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
	
	public PromotionDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Promotion> promotionsList(){
		return jdbc.query(PROMOTION, Collections.emptyMap(), rowMapper);
	}
}