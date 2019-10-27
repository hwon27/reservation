package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.*;

import java.io.IOException;
import java.util.List;

public interface ReservationService {
    List<ReservationInfo> getReservationInfoList(String reservationEmail) throws IOException;

    ReservationParam getReservationParamFromString(String reservationParamBody) throws IOException;

    ReservationResponse addProductReservation(ReservationParam reservationParam) throws Exception;

    void updateReservationInfoCancelYn(int reservationInfoId) throws IOException;

    ReservationResponse getReservationResponse(int reservationInfoId) throws IOException;

    ReservationInfo getReservationInfo(int reservationInfoId) throws Exception;
}