package com.example.jpa.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "address")
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    
    public Address(User user) {
    	this.user = user;
    }
    
    public Address(String street, String city, User user) {
    	this.street = street;
    	this.city = city;
    	this.user = user;
    }
}
