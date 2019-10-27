package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.DetailDao;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.DisplayInfoResponse;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailDao detailDao;

    @Override
	public List<CommentImage> getCommentImages(int displayInfoId){
		List<CommentImage> commentImage = detailDao.getCommentImage(displayInfoId);
		return commentImage;
	}

	@Override
	public double getAverageScore(int displayInfoId) {
		int sum = 0;
		
		List<Comment> commentList = detailDao.getComment(displayInfoId);
		float commentLength = commentList.size();
		
		
		for (Comment c : commentList) {
			sum+=c.getScore();
		}
		double avg = sum / commentLength;
		if(sum==0) {
			return 0.0;
			
		}else {
			return avg;
		}
		
	}

	@Override
	@Transactional
	public List<Comment> getComments(int displayInfoId) {
		List<Comment> commentList = detailDao.getComment(displayInfoId);
		List<CommentImage> commentImages  = detailDao.getCommentImage(displayInfoId);
		
		 for(Comment comment : commentList) {
			 List<CommentImage> list = new LinkedList<CommentImage>(); 				
				for(CommentImage commentImg : commentImages) {
					if(comment.getCommentId() == commentImg.getReservationUserCommentId()) {
						list.add(commentImg);
						comment.setCommentImages(list);
					}
				}
		 }
			
		return commentList;
	}
	
 
    	
    
	@Override
	@Transactional
	public DisplayInfo getDisplayInfo(int displayInfoId) {
		
		return detailDao.getDisplayInfo(displayInfoId);
	}
	
	@Override
	@Transactional
	public DisplayInfoImage getDisplayInfoImage(int displayInfoId) {
		
		return detailDao.getDisplayInfoImage(displayInfoId);
	}

	@Override
	@Transactional
	public List<ProductImage> getProductImages(int displayInfoId) {
		List<ProductImage> list = detailDao.getProductImage(displayInfoId);
		return list;
	}

	@Override
	@Transactional
	public List<ProductPrice> getProductPrices(int displayInfoId) {
		List<ProductPrice> list = detailDao.getProductPrice(displayInfoId);
		return list;
	}

	@Override
	public DisplayInfoResponse getDisplayInfoResponse() {
		
		return null;
	}

}