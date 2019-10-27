package kr.or.connect.reservation.controller;

import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.service.ImageService;
import kr.or.connect.reservation.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;

@RestController
public class ImageApiController {
    private static final String PATH = "c:/tmp/";

    @Autowired
    ReviewService reviewService;

    @Autowired
    ImageService imageService;

    // 한줄평 코멘트 이미지
    @GetMapping("/review_img")
    public void getReviewImg(HttpServletResponse response, @RequestParam int imageId) {
        int commentId = reviewService.getCommentIdByImageId(imageId);
        CommentImage commentImage = reviewService.getCommentResponse(commentId).getCommentImage();

        setImageResponse(response, commentImage);
    }

    // 상품 상세 이미지
    @GetMapping("/image")
    public void getImage(HttpServletResponse response, @RequestParam int fileInfoId) {
        CommentImage commentImage = imageService.getCommentImageByFileId(fileInfoId);

        setImageResponse(response, commentImage);
    }

    // 오는길 맵 이미지
    @GetMapping("/map_image")
    public void getMapImage(HttpServletResponse response, @RequestParam int displayInfoId) {
        int fileInfoId = imageService.getFileIdByDisplayInfoId(displayInfoId);
        CommentImage commentImage = imageService.getCommentImageByFileId(fileInfoId);

        setImageResponse(response, commentImage);
    }

    // 프로모션 이미지
    @GetMapping("/promotion")
    public void getPromotionImage(HttpServletResponse response, @RequestParam int productId) {
        int fileInfoId = imageService.getFileIdByProductId(productId);
        CommentImage commentImage = imageService.getCommentImageByFileId(fileInfoId);

        setImageResponse(response, commentImage);
    }

    // 상품 이미지
    @GetMapping("/productImage")
    public void getProductImage(HttpServletResponse response, @RequestParam int productId) {
        int fileInfoId = imageService.getFileIdByProductId(productId);
        CommentImage commentImage = imageService.getCommentImageByFileId(fileInfoId);

        setImageResponse(response, commentImage);
    }

    private void setImageResponse(HttpServletResponse response, CommentImage commentImage) {
        String fileName = commentImage.getFileName();
        String saveFileName = PATH + commentImage.getSaveFileName();
        String contentType = commentImage.getContentType();

        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", contentType);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        responseImage(response, saveFileName);
    }

    private void responseImage(HttpServletResponse response, String saveFileName) {
        try (
                FileInputStream fis = new FileInputStream(saveFileName);
                BufferedInputStream bs = new BufferedInputStream(fis);
                OutputStream out = response.getOutputStream();
                BufferedOutputStream bo = new BufferedOutputStream(out)
        ) {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = bs.read(buffer)) != -1) {
                bo.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            throw new RuntimeException("file Download Error");
        }
    }
}