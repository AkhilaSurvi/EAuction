package com.EAuctionGroup.EAuctionArtifact.repository;

import com.EAuctionGroup.EAuctionArtifact.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteByProductId(long productId);
}
