package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.CommentResponse;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class ReviewDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert reservationUserCommentAction;
    private SimpleJdbcInsert reservationUserCommentImageAction;
    private SimpleJdbcInsert fileInfoAction;

    private RowMapper<CommentResponse> CommentResponse_rowMapper = BeanPropertyRowMapper.newInstance(CommentResponse.class);
    private RowMapper<CommentImage> CommentImage_rowMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);

    public ReviewDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.reservationUserCommentAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_user_comment").usingGeneratedKeyColumns("id");
        this.reservationUserCommentImageAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_user_comment_image").usingGeneratedKeyColumns("id");
        this.fileInfoAction = new SimpleJdbcInsert(dataSource)
                .withTableName("file_info").usingGeneratedKeyColumns("id");
    }

    public CommentResponse getCommentResponseByCommentId(Integer commentId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("commentId", commentId);

        return jdbc.queryForObject(COMMENTS_BY_ID, params, CommentResponse_rowMapper);
    }

    public CommentImage getCommentImageByCommentId(Integer commentId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("commentId", commentId);

        return jdbc.queryForObject(COMMENT_IMAGE_BY_COMMENTID, params, CommentImage_rowMapper);
    }

    public int insertReservationUserComment(CommentResponse commentResponse) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_id", commentResponse.getProductId());
        params.put("reservation_info_id", commentResponse.getReservationInfoId());
        params.put("score", commentResponse.getScore());
        params.put("comment", commentResponse.getComment());
        params.put("create_date", LocalDateTime.now());
        params.put("modify_date", LocalDateTime.now());

        return reservationUserCommentAction.executeAndReturnKey(params).intValue();
    }

    public int insertFileInfo(CommentImage commentImage) {
        Map<String, Object> params = new HashMap<>();
        params.put("file_name", commentImage.getFileName());
        params.put("save_file_name", commentImage.getSaveFileName());
        params.put("content_type", commentImage.getContentType());
        params.put("delete_flag", false);
        params.put("create_date", LocalDateTime.now());
        params.put("modify_date", LocalDateTime.now());

        return fileInfoAction.executeAndReturnKey(params).intValue();
    }

    public void insertReservationUserCommentImage(Integer reservationInfoId, Integer commentId, Integer fileId) {
        Map<String, Object> params = new HashMap<>();
        params.put("reservation_info_id", reservationInfoId);
        params.put("reservation_user_comment_id", commentId);
        params.put("file_id", fileId);

        reservationUserCommentImageAction.execute(params);
    }

    public int getCommentIdByImageId(Integer imageId){
        Map<String, Integer> params = new HashMap<>();
        params.put("imageId", imageId);

        return jdbc.queryForObject(GET_COMMENT_ID_BY_IMAGE_ID, params, Integer.class);
    }
}