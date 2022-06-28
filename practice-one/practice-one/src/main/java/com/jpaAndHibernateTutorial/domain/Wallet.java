package com.jpaAndHibernateTutorial.domain;

import com.jpaAndHibernateTutorial.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Wallet.TABLE_NAME)
public class Wallet extends BaseEntity<Long> {
    public static final String TABLE_NAME = "wallet";
    private Long totalAmount = 0L;
    private Long cashAmount = 0L;
    private Long creditAmount = 0L;

    // @OneToOne(mappedBy = "wallet") : This relationship is implemented by wallet
    // mappedBy is used for those who do not have a relationship
    // This relationship was once mappedBy wallet

    @OneToOne(mappedBy = "optionalOneToOneWallet")
    private User user;
    // @OneToOne(mappedBy = "wallet") : This relationship is implemented by wallet

    public Wallet() {
    }

    public Wallet(Long id, Long totalAmount, Long cashAmount, Long creditAmount) {
        super(id);
        this.totalAmount = totalAmount;
        this.cashAmount = cashAmount;
        this.creditAmount = creditAmount;
    }
    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Long cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Long getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Long creditAmount) {
        this.creditAmount = creditAmount;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    /*@Override
    public String toString() {
        return "Wallet{" +
                "totalAmount=" + totalAmount +
                ", cashAmount=" + cashAmount +
                ", creditAmount=" + creditAmount +
                ", user=" + user +
                '}';
    }*/
}
