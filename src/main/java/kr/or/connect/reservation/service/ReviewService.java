package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.CommentResponse;

public interface ReviewService {
    CommentResponse getCommentResponse(Integer commentId);

    int insertReviewCommentAndImage(CommentResponse commentResponse, CommentImage commentImage);

    int insertReviewComment(CommentResponse commentResponse);

    int getCommentIdByImageId(Integer commentId);
}