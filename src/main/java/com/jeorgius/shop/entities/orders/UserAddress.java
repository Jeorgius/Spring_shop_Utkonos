package com.jeorgius.shop.entities.orders;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="useraddress", schema = "goods")
@SequenceGenerator(name="h", sequenceName = "goods.hibernate_sequence")
public class UserAddress {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "h")
    private Integer id;
    private String country;
    private String city;
    private Integer index;

    @OneToOne
    private Purchase purchase;

//    @OneToMany(mappedBy = "address")
//    List<Purchase> purchaseList;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
