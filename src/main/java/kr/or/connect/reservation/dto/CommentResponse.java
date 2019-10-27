package kr.or.connect.reservation.dto;

public class CommentResponse {
    private Integer commentId;
    private Integer productId;
    private Integer reservationInfoId;
    private Integer score;
    private String comment;
    private String createDate;
    private String modifyDate;
    private CommentImage commentImage;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(Integer reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public CommentImage getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(CommentImage commentImage) {
        this.commentImage = commentImage;
    }

    @Override
    public String toString() {
        return "CommentResponse{" +
                "comment='" + comment + '\'' +
                ", commentId=" + commentId +
                ", commentImage=" + commentImage +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", productId=" + productId +
                ", reservationInfoId=" + reservationInfoId +
                ", score=" + score +
                '}';
    }
}