package com.passion_share_track.share_track.DTO;

public class CartDTO {
    private Long userId;
    private Long itemId;
    private int quantity;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "userId=" + userId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                '}';
    }
}
