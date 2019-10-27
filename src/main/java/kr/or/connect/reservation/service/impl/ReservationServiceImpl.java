package kr.or.connect.reservation.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.or.connect.reservation.dao.DetailDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationParam;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.ReservationResponse;
import kr.or.connect.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private DetailDao detailDao;

    @Override
    public List<ReservationInfo> getReservationInfoList(String reservationEmail) {
        List<ReservationInfo> reservationInfoList = reservationDao.getReservationInfo(reservationEmail);

        for (ReservationInfo reservationInfo : reservationInfoList) {
            addDisplayInfo(reservationInfo);
            addTotalPrice(reservationInfo);
        }

        return reservationInfoList;
    }

    private void addDisplayInfo(ReservationInfo reservationInfo) {
        int displayInfoId = reservationInfo.getDisplayInfoId();
        DisplayInfo displayInfo = detailDao.getDisplayInfo(displayInfoId);

        reservationInfo.setDisplayInfo(displayInfo);
    }

    private void addTotalPrice(ReservationInfo reservationInfo) {
        int reservationInfoId = reservationInfo.getReservationInfoId();
        List<ReservationPrice> reservationPriceList = reservationDao.getReservationPrice(reservationInfoId);

        int totalPrice = getTotalPrice(reservationPriceList);

        reservationInfo.setTotalPrice(totalPrice);
    }

    private int getTotalPrice(List<ReservationPrice> reservationPriceList) {
        int totalPrice = 0;

        for (ReservationPrice reservationPrice : reservationPriceList) {
            int productPriceId = reservationPrice.getProductPriceId();
            ProductPrice productPrice = productDao.getProductPrice(productPriceId);

            totalPrice += productPrice.getPrice() * reservationPrice.getCount();
        }

        return totalPrice;
    }

    @Override
    public ReservationParam getReservationParamFromString(String reservationParamBody) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = objectMapper.readValue(reservationParamBody, new TypeReference<Map<String, Object>>() {
        });


        ReservationParam reservationParam = new ReservationParam();
        reservationParam.setDisplayInfoId((Integer) jsonMap.get("displayInfoId"));
        List<ReservationPrice> reservationPriceList = objectMapper.readValue(jsonMap.get("prices").toString(), new TypeReference<List<ReservationPrice>>() {
        });
        reservationParam.setPrices(reservationPriceList);
        reservationParam.setProductId((Integer) jsonMap.get("productId"));
        reservationParam.setReservationEmail((String) jsonMap.get("reservationEmail"));
        reservationParam.setReservationName((String) jsonMap.get("reservationName"));
        reservationParam.setReservationTelephone((String) jsonMap.get("reservationTelephone"));
        reservationParam.setReservationYearMonthDay((String) jsonMap.get("reservationYearMonthDay"));

        return reservationParam;
    }

    @Transactional
    @Override
    public ReservationResponse addProductReservation(ReservationParam reservationParam) throws Exception {
        int reservationInfoId = reservationDao.insertReservationInfo(reservationParam);

        for (ReservationPrice reservationPrice : reservationParam.getPrices()) {
            reservationPrice.setReservationInfoId(reservationInfoId);
            reservationDao.insertReservationInfoPrice(reservationPrice);
        }

        ReservationResponse reservationResponse = getReservationResponse(reservationInfoId);
        return reservationResponse;
    }

    @Override
    public ReservationResponse getReservationResponse(int reservationInfoId) {
        ReservationInfo reservationInfo = reservationDao.getReservationInfo(reservationInfoId);
        List<ReservationPrice> reservationPriceList = reservationDao.getReservationPrice(reservationInfoId);

        return convertReservationResponse(reservationInfo, reservationPriceList);
    }

    private ReservationResponse convertReservationResponse(ReservationInfo reservationInfo,
                                                           List<ReservationPrice> reservationPriceList){
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setReservationInfoId(reservationInfo.getReservationInfoId());
        reservationResponse.setProductId(reservationInfo.getProductId());
        reservationResponse.setDisplayInfoId(reservationInfo.getDisplayInfoId());
        reservationResponse.setReservationName(reservationInfo.getReservationName());
        reservationResponse.setReservationTelephone(reservationInfo.getReservationTelephone());
        reservationResponse.setReservationEmail(reservationInfo.getReservationEmail());
        reservationResponse.setReservationDate(reservationInfo.getReservationDate());
        reservationResponse.setCancelYn(reservationInfo.isCancelYn());
        reservationResponse.setCreateDate(reservationInfo.getCreateDate());
        reservationResponse.setModifyDate(reservationInfo.getModifyDate());
        reservationResponse.setPrices(reservationPriceList);

        return reservationResponse;
    }

    @Override
    public void updateReservationInfoCancelYn(int reservationInfoId) {
        reservationDao.updateReservationInfoCancelYn(reservationInfoId);
    }

    @Override
    public ReservationInfo getReservationInfo(int reservationInfoId) {
        ReservationInfo reservationInfo = reservationDao.getReservationInfo(reservationInfoId);
        addDisplayInfo(reservationInfo);
        addTotalPrice(reservationInfo);

        return reservationInfo;
    }
}