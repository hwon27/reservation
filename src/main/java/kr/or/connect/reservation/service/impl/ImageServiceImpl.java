package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ImageDao;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDao imageDao;

    @Override
    public CommentImage getCommentImageByFileId(Integer fileId) {
        return imageDao.getCommentImageByFileId(fileId);
    }

    @Override
    public Integer getFileIdByProductId(Integer productId) {
        return imageDao.getFileIdByProductId(productId);
    }

    @Override
    public Integer getFileIdByDisplayInfoId(Integer displayInfoId) {
        return imageDao.getFileIdByDisplayInfoId(displayInfoId);
    }
}