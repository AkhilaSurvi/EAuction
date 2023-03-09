package com.EAuctionGroup.EAuctionArtifact.model;

import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
public class ProductSeller {
    private Product product;
    private Seller seller;
    private ProductSellerMapping productSellerMapping;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public ProductSellerMapping getProductSellerMapping() {
        return productSellerMapping;
    }

    public void setProductSellerMapping(ProductSellerMapping productSellerMapping) {
        this.productSellerMapping = productSellerMapping;
    }
}


