package org.zhanara.dao;

import org.zhanara.models.MarketCashierEntity;
import org.zhanara.models.MarketUsersEntity;

import java.util.List;

public interface CashiersDAO {

    List<MarketCashierEntity> getCashiers();

    void addCashier(String name, String surname, String login);

    void deleteCashier(int id);

    MarketCashierEntity getCashier(int i);

    void updateCashier(MarketCashierEntity cashier);

    MarketCashierEntity getCashierByUser(MarketUsersEntity usersEntity);
}
