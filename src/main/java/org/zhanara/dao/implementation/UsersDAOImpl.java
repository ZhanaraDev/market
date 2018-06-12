package org.zhanara.dao.implementation;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.zhanara.dao.AbstractDAO;
import org.zhanara.dao.UsersDAO;
import org.zhanara.models.MarketUsersEntity;

import javax.transaction.Transactional;

@Repository("UsersDAO")
@Transactional
public class UsersDAOImpl extends AbstractDAO<Integer,MarketUsersEntity> implements UsersDAO {
    @Override
    public void saveUser(MarketUsersEntity user) {
        save(user);
    }

    @Override
    public MarketUsersEntity getUserByUserId(int id) {
        return (MarketUsersEntity)createEntityCriteria().add(Restrictions.eq("id",id)).uniqueResult();
    }

    @Override
    public MarketUsersEntity getUserByUsername(String username) {
        return (MarketUsersEntity)createEntityCriteria().add(Restrictions.eq("login",username)).uniqueResult();
    }
}
