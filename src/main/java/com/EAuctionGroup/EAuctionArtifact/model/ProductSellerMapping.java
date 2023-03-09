package com.EAuctionGroup.EAuctionArtifact.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ProductSellerMapping")
public class ProductSellerMapping {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productSellerId;

    public Long getProductSellerId() {
        return productSellerId;
    }

    public void setProductSellerId(Long productSellerId) {
        this.productSellerId = productSellerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    private Long productId;
    private Long sellerId;
}


