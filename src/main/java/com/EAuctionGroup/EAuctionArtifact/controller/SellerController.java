package com.EAuctionGroup.EAuctionArtifact.controller;

import com.EAuctionGroup.EAuctionArtifact.model.*;
import com.EAuctionGroup.EAuctionArtifact.repository.BuyerRepository;
import com.EAuctionGroup.EAuctionArtifact.repository.ProductRepository;
import com.EAuctionGroup.EAuctionArtifact.repository.ProductSellerRepository;
import com.EAuctionGroup.EAuctionArtifact.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/e-auction/api/v1/seller")
public class SellerController {

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductSellerRepository productSellerRepository;


    @PostMapping("/add-product")
    public ResponseEntity<ProductSeller> createProductSeller(@RequestBody ProductSeller _productSeller) {
        try {
            Product _product = productRepository.save(_productSeller.getProduct());
            Seller _seller = sellerRepository.save(_productSeller.getSeller());
            ProductSellerMapping productSellerMapping = new ProductSellerMapping();
            productSellerMapping.setProductId(_productSeller.getProduct().getProductId());
            productSellerMapping.setSellerId(_productSeller.getSeller().getSellerId());
            ProductSellerMapping _productSellerMapping = productSellerRepository.save(productSellerMapping);
            _productSeller.setProductSellerMapping(_productSellerMapping);
            return new ResponseEntity<ProductSeller>(_productSeller, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{productId}")
    @Transactional
    public void deleteProduct(@PathVariable("productId") Long productId) {
        try {
            productRepository.deleteByProductId(productId);
        } catch (Exception e) {
            System.out.println("Some Exception while deleting product");
        }
    }

    @GetMapping("/show-bids/{productId}")
    public List<Buyer> getBidDetails(@PathVariable("productId") Long sellerId) {
        try {
            ProductSellerMapping productSellerMapping = productSellerRepository.findBySellerId(sellerId);
            Long productId = productSellerMapping.getProductId();
            List<Buyer> buyers = buyerRepository.findAllByProductId(productId);
            return buyers;
        } catch (Exception e) {
            System.out.println("Some Exception while getting Bid details");
            return null;
        }
    }
}


