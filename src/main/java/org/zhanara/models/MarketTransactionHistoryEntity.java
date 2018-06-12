package org.zhanara.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "market_transaction_history")
public class MarketTransactionHistoryEntity {
    private int id;
    private Integer amount;
    private Timestamp transactionTime;
    private MarketItemsEntity marketItemsByItemId;
    private MarketCashierEntity marketCashierByCashierId;

    public MarketTransactionHistoryEntity(Integer amount, Timestamp transactionTime, MarketItemsEntity marketItemsByItemId, MarketCashierEntity marketCashierByCashierId) {
        this.amount = amount;
        this.transactionTime = transactionTime;
        this.marketItemsByItemId = marketItemsByItemId;
        this.marketCashierByCashierId = marketCashierByCashierId;
    }

    public MarketTransactionHistoryEntity() {
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
    @Column(name = "amount", nullable = true)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "transaction_time", nullable = true)
    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketTransactionHistoryEntity that = (MarketTransactionHistoryEntity) o;

        if (id != that.id) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (transactionTime != null ? !transactionTime.equals(that.transactionTime) : that.transactionTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (transactionTime != null ? transactionTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    public MarketItemsEntity getMarketItemsByItemId() {
        return marketItemsByItemId;
    }

    public void setMarketItemsByItemId(MarketItemsEntity marketItemsByItemId) {
        this.marketItemsByItemId = marketItemsByItemId;
    }

    @ManyToOne
    @JoinColumn(name = "cashier_id", referencedColumnName = "id")
    public MarketCashierEntity getMarketCashierByCashierId() {
        return marketCashierByCashierId;
    }

    public void setMarketCashierByCashierId(MarketCashierEntity marketCashierByCashierId) {
        this.marketCashierByCashierId = marketCashierByCashierId;
    }
}
