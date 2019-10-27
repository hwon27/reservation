package kr.or.connect.reservation.controller;

import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.CommentResponse;
import kr.or.connect.reservation.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ReviewApiController {
    private static final String PATH = "c:/tmp/";
    private static final String COMMENT_IMAGE = "review_img/";

    @Autowired
    ReviewService reviewService;

    @PostMapping("/reservations/{reservationInfoId}/comments")
    public CommentResponse getCommentResponse(@ModelAttribute CommentResponse commentResponse,
                                              @PathVariable Integer reservationInfoId,
                                              @RequestParam(required = false) MultipartFile reviewImg) throws Exception {

        commentResponse.setReservationInfoId(reservationInfoId);

        if (reviewImg == null) {    // 이미지 파일 없는 경우
            int commentId = reviewService.insertReviewComment(commentResponse);
            return reviewService.getCommentResponse(commentId);
        } else {                    // 이미지 파일 있는 경우
            String fileName = makeInherenceFile(reviewImg.getOriginalFilename(), reviewImg.getBytes());
            String saveFileName = COMMENT_IMAGE + fileName;
            String contentType = reviewImg.getContentType();

            saveFile(reviewImg, PATH + saveFileName);

            CommentImage commentImage = new CommentImage();
            commentImage.setFileName(fileName);
            commentImage.setSaveFileName(saveFileName);
            commentImage.setContentType(contentType);

            int commentId = reviewService.insertReviewCommentAndImage(commentResponse, commentImage);

            return reviewService.getCommentResponse(commentId);
        }
    }

    private void saveFile(MultipartFile reviewImg, String saveAddr) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(saveAddr);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             InputStream inputStream = reviewImg.getInputStream();
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {

            int readCount = 0;
            byte[] buffer = new byte[1024];

            while ((readCount = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, readCount);
            }

        } catch (Exception e) {
            throw new RuntimeException("file Save Error");
        }
    }

    // 파일명 랜덤 생성 메소드
    private String makeInherenceFile(String originalName, byte[] fileData) throws Exception {
        UUID uuid = UUID.randomUUID();
        String savedName = uuid.toString() + "_" + originalName;

        return savedName;
    }
}