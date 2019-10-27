package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.CommentImage;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class ImageDao {
    private NamedParameterJdbcTemplate jdbc;

    private RowMapper<CommentImage> CommentImage_rowMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);

    public ImageDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public CommentImage getCommentImageByFileId(Integer fileId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("fileId", fileId);

        return jdbc.queryForObject(GET_IMAGE_BY_FILE_ID, params, CommentImage_rowMapper);
    }

    public int getFileIdByProductId(Integer productId){
        Map<String, Integer> params = new HashMap<>();
        params.put("productId", productId);

        return jdbc.queryForObject(GET_FILE_ID_BY_PRODUCT_ID, params, Integer.class);
    }

    public int getFileIdByDisplayInfoId(Integer displayInfoId){
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);

        return jdbc.queryForObject(GET_FILE_ID_BY_DISPLAY_INFO_ID, params, Integer.class);
    }
}