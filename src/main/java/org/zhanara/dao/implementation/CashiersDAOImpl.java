package org.zhanara.dao.implementation;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zhanara.dao.AbstractDAO;
import org.zhanara.dao.CashiersDAO;
import org.zhanara.dao.RolesDAO;
import org.zhanara.dao.UsersDAO;
import org.zhanara.models.MarketCashierEntity;
import org.zhanara.models.MarketUsersEntity;

import javax.transaction.Transactional;
import java.util.List;

@Repository("CashiersDAO")
@Transactional
public class CashiersDAOImpl extends AbstractDAO<Integer,MarketCashierEntity> implements CashiersDAO {
    @Autowired
    RolesDAO rolesDAO;
    @Autowired
    UsersDAO usersDAO;

    @Override
    public List<MarketCashierEntity> getCashiers() {
        Criteria criteria = createEntityCriteria();
        return criteria.list();
    }

    @Override
    public void addCashier(String name, String surname, String login) {
        MarketUsersEntity user = new MarketUsersEntity(login,"12345", rolesDAO.getRoleByRoleId(2));
        usersDAO.saveUser(user);
        MarketCashierEntity cashierEntity = new MarketCashierEntity(name,surname,user);
        save(cashierEntity);
    }

    @Override
    public void deleteCashier(int id) {
        delete(getCashier(id));

    }

    @Override
    public MarketCashierEntity getCashier(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id",id));
        return (MarketCashierEntity)criteria.uniqueResult();
    }

    @Override
    public void updateCashier(MarketCashierEntity cashier) {
        update(cashier);
    }

    @Override
    public MarketCashierEntity getCashierByUser(MarketUsersEntity usersEntity) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("marketUsersEntity",usersEntity));
        return (MarketCashierEntity) criteria.uniqueResult();
    }


}
