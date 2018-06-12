package org.zhanara.dao;

import org.zhanara.models.MarketCashierEntity;
import org.zhanara.models.MarketTransactionHistoryEntity;

import java.util.List;

public interface TransactionsDAO {

    void addTransaction(MarketTransactionHistoryEntity transactionHistoryEntity);

    List<MarketTransactionHistoryEntity>  getTransactionHistoryListByCashierEntity(MarketCashierEntity cashier);

    List<MarketTransactionHistoryEntity> getFullTransactionsHistory();
}
