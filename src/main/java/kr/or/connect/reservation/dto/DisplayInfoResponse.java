package kr.or.connect.reservation.dto;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;

import java.util.List;

public class DisplayInfoResponse {
    private Double averageScore;
    private List<Comment> comments;
    private DisplayInfo displayInfo;
    private DisplayInfoImage displayInfoImage;
    private List<ProductImage> productImages;
    private List<ProductPrice> productPrices;

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    public void setDisplayInfo(DisplayInfo displayInfo) {
        this.displayInfo = displayInfo;
    }

    public DisplayInfoImage getDisplayInfoImage() {
        return displayInfoImage;
    }

    public void setDisplayInfoImage(DisplayInfoImage displayInfoImage) {
        this.displayInfoImage = displayInfoImage;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return "DisplayInfoResponse{" +
                "averageScore=" + averageScore +
                ", comments=" + comments +
                ", displayInfo=" + displayInfo +
                ", displayInfoImage=" + displayInfoImage +
                ", productImages=" + productImages +
                ", productPrices=" + productPrices +
                '}';
    }
}