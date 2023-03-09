package com.EAuctionGroup.EAuctionArtifact.repository;

import com.EAuctionGroup.EAuctionArtifact.model.ProductSellerMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSellerRepository extends JpaRepository<ProductSellerMapping, Long> {

    ProductSellerMapping findBySellerId(Long sellerId);

}
