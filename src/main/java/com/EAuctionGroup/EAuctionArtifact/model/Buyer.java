package com.EAuctionGroup.EAuctionArtifact.model;



import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Buyer")
public class Buyer{


    @Id
    private Long buyerId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String phone;
    private String email;
    private Long productId;
    private Double bidAmount;

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }
}

