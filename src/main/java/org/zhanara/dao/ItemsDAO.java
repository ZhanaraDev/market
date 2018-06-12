package org.zhanara.dao;

import org.zhanara.models.MarketItemsEntity;

import java.util.List;

public interface ItemsDAO {

    List<MarketItemsEntity> getItemsList();

    void addItem(MarketItemsEntity item);

    MarketItemsEntity getItems(int id);

    void updateItem(MarketItemsEntity items);

    void deleteItem(MarketItemsEntity item);
}
