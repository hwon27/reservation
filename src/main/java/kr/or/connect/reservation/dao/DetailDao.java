package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
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
public class DetailDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<CommentImage> CommentImages_rowMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);
    private RowMapper<Comment> Comments_rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
    private RowMapper<DisplayInfo> DisplayInfo_rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
    private RowMapper<DisplayInfoImage> DisplayInfoImage_rowMapper = BeanPropertyRowMapper
            .newInstance(DisplayInfoImage.class);
    private RowMapper<ProductImage> ProductImages_rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
    private RowMapper<ProductPrice> ProductPrices_rowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);

    public DetailDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Comment> getComment(int displayInfoId) {
		 Map<String, Integer> params =  new HashMap<>();
		 params.put("displayInfoId", displayInfoId);
		 
		return jdbc.query(COMMENTS, params, Comments_rowMapper);
		 
	 }
	 
	 public List<CommentImage> getCommentImage(int displayInfoId) {
		 Map<String, Integer> params =  new HashMap<>();
		 params.put("displayInfoId", displayInfoId);
	        return jdbc.query(COMMENT_IMAGES, params, CommentImages_rowMapper);
	    }
	 
	 public DisplayInfo getDisplayInfo(int displayInfoId) {
	        Map<String, Integer> params = new HashMap<>();
	        params.put("displayInfoId", displayInfoId);

	        return jdbc.queryForObject(DISPLAY_INFO, params, DisplayInfo_rowMapper);
	    }

	    public DisplayInfoImage getDisplayInfoImage(int displayInfoId) {
	        Map<String, Integer> params = new HashMap<>();
	        params.put("displayInfoId", displayInfoId);

	        return jdbc.queryForObject(DISPLAY_INFO_IMAGE, params, DisplayInfoImage_rowMapper);
	    }

	    public List<ProductImage> getProductImage(int displayInfoId) {
	        Map<String, Integer> params = new HashMap<>();
	        params.put("displayInfoId", displayInfoId);

	        return jdbc.query(PRODUCT_IMAGES, params, ProductImages_rowMapper);
	    }

	    public List<ProductPrice> getProductPrice(int displayInfoId) {
	        Map<String, Integer> params = new HashMap<>();
	        params.put("displayInfoId", displayInfoId);

	        return jdbc.query(PRODUCT_PRICES, params, ProductPrices_rowMapper);
	    }

}