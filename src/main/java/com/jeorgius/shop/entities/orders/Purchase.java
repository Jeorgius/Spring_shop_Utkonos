package com.jeorgius.shop.entities.orders;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="purchase", schema = "goods")
@SequenceGenerator(name="h", sequenceName = "goods.hibernate_sequence")
public class Purchase {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "h")
    private Integer id;
    private boolean Confirmed = false;

    private String payMethod;
    private Integer total;

    @OneToMany(mappedBy="purchase")
    private List<ItemInPurchase> itemInPurchases;

    @OneToOne
    private UserAddress userAddress;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        Confirmed = confirmed;
    }

    public List<ItemInPurchase> getItemInPurchases() {
        return itemInPurchases;
    }

    public void setItemInPurchases(List<ItemInPurchase> itemInPurchases) {
        this.itemInPurchases = itemInPurchases;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
