package org.zhanara.dao.implementation;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.zhanara.dao.AbstractDAO;
import org.zhanara.dao.TransactionsDAO;
import org.zhanara.models.MarketCashierEntity;
import org.zhanara.models.MarketTransactionHistoryEntity;

import javax.transaction.Transactional;
import java.util.List;

@Repository("TransactionsDAO")
@Transactional
public class TransactionDAOImpl extends AbstractDAO<Integer,MarketTransactionHistoryEntity> implements TransactionsDAO {
    @Override
    public void addTransaction(MarketTransactionHistoryEntity transactionHistoryEntity) {
        save(transactionHistoryEntity);
    }

    @Override
    public List<MarketTransactionHistoryEntity> getTransactionHistoryListByCashierEntity(MarketCashierEntity cashier) {
        return (List<MarketTransactionHistoryEntity>) createEntityCriteria().add(Restrictions.eq("marketCashierByCashierId",cashier)).list();
    }

    @Override
    public List<MarketTransactionHistoryEntity> getFullTransactionsHistory() {
        return createEntityCriteria().list();
    }


}
