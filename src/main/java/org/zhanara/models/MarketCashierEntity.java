package org.zhanara.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "market_cashier")
public class MarketCashierEntity {
    private int id;
    private String name;
    private String surname;
    private MarketUsersEntity marketUsersEntity;
    private Collection<MarketTransactionHistoryEntity> transactionHistoryBytransactionHistoryid;

    public MarketCashierEntity(String name, String surname, MarketUsersEntity marketUsersEntity) {
        this.name = name;
        this.surname = surname;
        this.marketUsersEntity = marketUsersEntity;
    }

    public MarketCashierEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 30)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ManyToOne(targetEntity = MarketUsersEntity.class,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false)
    public MarketUsersEntity getMarketUsersEntity() {
        return marketUsersEntity;
    }

    public void setMarketUsersEntity(MarketUsersEntity marketUsersEntity) {
        this.marketUsersEntity = marketUsersEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketCashierEntity that = (MarketCashierEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "marketCashierByCashierId")
    public Collection<MarketTransactionHistoryEntity> getTransactionHistoryBytransactionHistoryid() {
        return transactionHistoryBytransactionHistoryid;
    }

    public void setTransactionHistoryBytransactionHistoryid(Collection<MarketTransactionHistoryEntity> transactionHistoryBytransactionHistoryid) {
        this.transactionHistoryBytransactionHistoryid = transactionHistoryBytransactionHistoryid;
    }
}
