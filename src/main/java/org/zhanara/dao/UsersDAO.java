package org.zhanara.dao;

import org.zhanara.models.MarketUsersEntity;

public interface UsersDAO {

    void saveUser(MarketUsersEntity user);

    MarketUsersEntity getUserByUserId(int id);

    MarketUsersEntity getUserByUsername(String username);
}
