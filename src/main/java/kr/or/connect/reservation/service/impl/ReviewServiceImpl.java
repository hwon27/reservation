package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ReviewDao;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.CommentResponse;
import kr.or.connect.reservation.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewDao reviewDao;

    @Override
    public CommentResponse getCommentResponse(Integer commentId) {
        CommentResponse commentResponse = reviewDao.getCommentResponseByCommentId(commentId);
        commentResponse.setCommentImage(reviewDao.getCommentImageByCommentId(commentId));

        return commentResponse;
    }

    @Override
    @Transactional
    public int insertReviewCommentAndImage(CommentResponse commentResponse, CommentImage commentImage) {
        int commentId = reviewDao.insertReservationUserComment(commentResponse);
        int fileId = reviewDao.insertFileInfo(commentImage);
        reviewDao.insertReservationUserCommentImage(commentResponse.getReservationInfoId(), commentId, fileId);

        return commentId;
    }

    @Override
    @Transactional
    public int insertReviewComment(CommentResponse commentResponse) {
        return reviewDao.insertReservationUserComment(commentResponse);
    }

    @Override
    public int getCommentIdByImageId(Integer imageId) {
        return reviewDao.getCommentIdByImageId(imageId);
    }
}