package com.EAuctionGroup.EAuctionArtifact.controller;

import com.EAuctionGroup.EAuctionArtifact.model.Buyer;
import com.EAuctionGroup.EAuctionArtifact.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/e-auction/api/v1/buyer")
public class BuyerController {

    @Autowired
    BuyerRepository buyerRepository;

    @PostMapping("/place-bid")
    public ResponseEntity<Buyer> addBidProduct(@RequestBody Buyer _buyer) {
        try {
            Buyer buyer = buyerRepository.save(_buyer);
            return new ResponseEntity<Buyer>(buyer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-bid/{productId}/{buyerEmailId}/{newBidAmount}")
    public ResponseEntity<Buyer> updateBidProduct(@PathVariable("productId") Long productId,
                                                  @PathVariable("buyerEmailId") String buyerEmailId,@PathVariable("newBidAmount") Double newBidAmount) {
        try {
            Buyer buyer = buyerRepository.findAllByEmailAndProductId(buyerEmailId,productId);
            buyer.setBidAmount(newBidAmount);
            Buyer newBuyer = buyerRepository.save(buyer);
            return new ResponseEntity<Buyer>(newBuyer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


