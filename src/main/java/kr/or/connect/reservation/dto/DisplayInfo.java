package kr.or.connect.reservation.dto;

public class DisplayInfo {
    private Integer productId;
    private Integer categoryId;
    private Integer displayInfoId;
    private String categoryName;
    private String productDescription;
    private String productContent;
    private String productEvent;
    private String openingHours;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String telephone;
    private String homepage;
    private String email;
    private String createDate;
    private String modifyDate;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(Integer displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getProductEvent() {
        return productEvent;
    }

    public void setProductEvent(String productEvent) {
        this.productEvent = productEvent;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLot() {
        return placeLot;
    }

    public void setPlaceLot(String placeLot) {
        this.placeLot = placeLot;
    }

    public String getPlaceStreet() {
        return placeStreet;
    }

    public void setPlaceStreet(String placeStreet) {
        this.placeStreet = placeStreet;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "getDisplayInfo{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", createDate='" + createDate + '\'' +
                ", displayInfoId=" + displayInfoId +
                ", email='" + email + '\'' +
                ", homepage='" + homepage + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", placeLot='" + placeLot + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeStreet='" + placeStreet + '\'' +
                ", productContent='" + productContent + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productEvent='" + productEvent + '\'' +
                ", productId=" + productId +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}