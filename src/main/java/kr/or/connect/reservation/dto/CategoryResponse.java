package kr.or.connect.reservation.dto;

import java.util.List;

public class CategoryResponse {
    private List<Category> items;

    public List<Category> getItems() {
        return items;
    }

    public void setItems(List<Category> items) {
        this.items = items;
    }
}