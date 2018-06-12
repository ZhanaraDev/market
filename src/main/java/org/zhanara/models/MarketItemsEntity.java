package org.zhanara.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "market_items")
public class MarketItemsEntity {
    private int id;
    private String name;
    private Integer universalProductCode;
    private Integer price;
    private Integer amounts;
    Collection<MarketTransactionHistoryEntity> marketTransactionHistory;

    public MarketItemsEntity(String name, Integer universalProductCode, Integer price, Integer amounts) {
        this.name = name;
        this.universalProductCode = universalProductCode;
        this.price = price;
        this.amounts = amounts;
    }

    public MarketItemsEntity() {
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
    @Column(name = "universal_product_code", nullable = true, length = 30)
    public int getUniversalProductCode() {
        return universalProductCode;
    }

    public void setUniversalProductCode(int universalProductCode) {
        this.universalProductCode = universalProductCode;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "amounts", nullable = true)
    public Integer getAmounts() {
        return amounts;
    }

    public void setAmounts(Integer amounts) {
        this.amounts = amounts;
    }

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "marketItemsByItemId")
    public Collection<MarketTransactionHistoryEntity> getMarketTransactionHistory() {
        return marketTransactionHistory;
    }

    public void setMarketTransactionHistory(Collection<MarketTransactionHistoryEntity> marketTransactionHistory) {
        this.marketTransactionHistory = marketTransactionHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketItemsEntity that = (MarketItemsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (universalProductCode != null ? !universalProductCode.equals(that.universalProductCode) : that.universalProductCode != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (amounts != null ? !amounts.equals(that.amounts) : that.amounts != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (universalProductCode != null ? universalProductCode.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (amounts != null ? amounts.hashCode() : 0);
        return result;
    }
}
