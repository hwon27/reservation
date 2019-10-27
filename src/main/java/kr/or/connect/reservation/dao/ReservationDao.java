package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationParam;
import kr.or.connect.reservation.dto.ReservationPrice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class ReservationDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert reservationInfoInsertAction;
    private SimpleJdbcInsert reservationInfoPriceInsertAction;

    private RowMapper<ReservationInfo> ReservationInfo_rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
    private RowMapper<ReservationPrice> Price_rowMapper = BeanPropertyRowMapper.newInstance(ReservationPrice.class);

    public ReservationDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.reservationInfoInsertAction= new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info").usingGeneratedKeyColumns("id");
        this.reservationInfoPriceInsertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info_price").usingGeneratedKeyColumns("id");
    }

    public List<ReservationInfo> getReservationInfo(String reservationEmail){
        Map<String, String> params = new HashMap<>();
        params.put("reservationEmail", reservationEmail);

        return jdbc.query(SELECT_RESERVATION_INFO_BY_RESERVATION_EMAIL, params, ReservationInfo_rowMapper);
    }

    public ReservationInfo getReservationInfo(int reservationInfoId){
        Map<String, Integer> params = new HashMap<>();
        params.put("reservationInfoId", reservationInfoId);

        return jdbc.queryForObject(SELECT_RESERVATION_INFO_BY_RESERVATION_INFO_ID, params, ReservationInfo_rowMapper);
    }

    public List<ReservationPrice> getReservationPrice(int reservationInfoId){
        Map<String, Integer> params = new HashMap<>();
        params.put("reservationInfoId", reservationInfoId);

        return jdbc.query(GET_RESERVATION_PRICE, params, Price_rowMapper);
    }

    public int insertReservationInfo(ReservationParam reservationParam){
        Map<String ,Object> params = new HashMap<>();
        params.put("display_info_id", reservationParam.getDisplayInfoId());
        params.put("product_id", reservationParam.getProductId());
        params.put("reservation_email", reservationParam.getReservationEmail());
        params.put("reservation_name", reservationParam.getReservationName());
        params.put("reservation_tel", reservationParam.getReservationTelephone());
        LocalDateTime reservationDate = LocalDateTime.parse(reservationParam.getReservationYearMonthDay());
        params.put("reservation_date", reservationDate);
        params.put("cancel_flag", false);
        params.put("create_date", LocalDateTime.now());
        params.put("modify_date", LocalDateTime.now());

        return reservationInfoInsertAction.executeAndReturnKey(params).intValue();
    }

    public int insertReservationInfoPrice(ReservationPrice reservationPrice){
        Map<String, Object> parmas = new HashMap<>();
        parmas.put("reservation_info_id", reservationPrice.getReservationInfoId());
        parmas.put("product_price_id", reservationPrice.getProductPriceId());
        parmas.put("count", reservationPrice.getCount());

        return reservationInfoPriceInsertAction.executeAndReturnKey(parmas).intValue();
    }

    public void updateReservationInfoCancelYn(int reservationInfoId){
        Map<String, Object> params = new HashMap<>();
        params.put("reservationInfoId", reservationInfoId);

        jdbc.update(UPDATE_RESERVATION_INFO_CANCEL_FLAG, params);
    }
}