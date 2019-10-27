package kr.or.connect.reservation.dto;

public class ProductPrice {
    private Integer productPriceId;
    private Integer productId;
    private String priceTypeName;
    private Integer price;
    private Integer discountRate;
    private String createDate;
    private String modifyDate;

    public Integer getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(Integer productPriceId) {
        this.productPriceId = productPriceId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPriceTypeName() {
        return priceTypeName;
    }

    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
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

    @Override
    public String toString() {
        return "ProductPrice{" +
                "createDate='" + createDate + '\'' +
                ", discountRate=" + discountRate +
                ", modifyDate='" + modifyDate + '\'' +
                ", price=" + price +
                ", priceTypeName='" + priceTypeName + '\'' +
                ", productId=" + productId +
                ", productPriceId=" + productPriceId +
                '}';
    }
}