package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.CommentImage;

public interface ImageService {
    CommentImage getCommentImageByFileId(Integer fileId);

    Integer getFileIdByProductId(Integer productId);

    Integer getFileIdByDisplayInfoId(Integer displayInfoId);
}