package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.DisplayInfoResponse;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;

import java.util.List;

public interface DetailService {
	double getAverageScore(int displayInfoId);

    List<Comment> getComments(int displayInfoId);
    
    List<CommentImage> getCommentImages(int displayInfoId);

    DisplayInfo getDisplayInfo(int displayInfoId);

    DisplayInfoImage getDisplayInfoImage(int displayInfoId);
    
    DisplayInfoResponse getDisplayInfoResponse();

    List<ProductImage> getProductImages(int displayInfoId);

    List<ProductPrice> getProductPrices(int displayInfoId);
}