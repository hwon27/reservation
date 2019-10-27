package kr.or.connect.reservation.controller;

import kr.or.connect.reservation.dto.*;
import kr.or.connect.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationApiController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public ReservationInfoResponse getReservationInfoResponse(@RequestParam String reservationEmail) throws IOException {
        List<ReservationInfo> reservationInfoList = reservationService.getReservationInfoList(reservationEmail);

        ReservationInfoResponse reservationInfoResponse = new ReservationInfoResponse();
        reservationInfoResponse.setReservations(reservationInfoList);
        reservationInfoResponse.setSize(reservationInfoList.size());

        return reservationInfoResponse;
    }

    @PostMapping("/reservations")
    public ReservationResponse addReservation(@RequestBody String reservationParamBody) throws Exception {
        ReservationParam reservationParam = reservationService.getReservationParamFromString(reservationParamBody);

        return reservationService.addProductReservation(reservationParam);
    }

    @PutMapping("/reservations/{reservationInfoId}")
    public ReservationResponse updateReservation(@PathVariable int reservationInfoId) throws Exception{
        reservationService.updateReservationInfoCancelYn(reservationInfoId);

        return reservationService.getReservationResponse(reservationInfoId);
    }

    @GetMapping("/reservationInfo")
    public ReservationInfo getReservationInfo(@RequestParam int reservationInfoId) throws Exception{
        return reservationService.getReservationInfo(reservationInfoId);
    }

    @GetMapping("/timenow")
    public String getTimenow() {
        int randomValue = (int) (Math.random() * 5);

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime addedLocalDateTime = localDateTime.plusDays(randomValue);

        return addedLocalDateTime.toString();
    }
}