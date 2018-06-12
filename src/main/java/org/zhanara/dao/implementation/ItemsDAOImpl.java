package org.zhanara.dao.implementation;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.zhanara.dao.AbstractDAO;
import org.zhanara.dao.ItemsDAO;
import org.zhanara.models.MarketItemsEntity;

import javax.transaction.Transactional;
import java.util.List;

@Repository("ItemsDAO")
@Transactional
public class ItemsDAOImpl extends AbstractDAO<Integer,MarketItemsEntity> implements ItemsDAO{
    @Override
    public List<MarketItemsEntity> getItemsList() {
        return createEntityCriteria().list();
    }

    @Override
    public void addItem(MarketItemsEntity item) {
        save(item);
    }

    @Override
    public MarketItemsEntity getItems(int id) {
        return (MarketItemsEntity)createEntityCriteria().add(Restrictions.eq("id",id)).uniqueResult();
    }

    @Override
    public void updateItem(MarketItemsEntity item) {
        update(item);
    }

    @Override
    public void deleteItem(MarketItemsEntity item) {
        delete(item);
    }


}
