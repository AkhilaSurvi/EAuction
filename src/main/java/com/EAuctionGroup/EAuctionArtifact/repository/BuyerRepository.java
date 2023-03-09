package com.EAuctionGroup.EAuctionArtifact.repository;

import com.EAuctionGroup.EAuctionArtifact.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer,Long> {

    List<Buyer> findAllByProductId(Long productId);

    Buyer findAllByEmailAndProductId(String buyerEmailId, Long productId);

}
