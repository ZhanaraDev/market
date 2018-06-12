package org.zhanara.dao.implementation;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.zhanara.dao.AbstractDAO;
import org.zhanara.dao.RolesDAO;
import org.zhanara.models.MarketRolesEntity;

import javax.transaction.Transactional;


@Repository("RolesDAO")
@Transactional
public class RolesDAOIpml extends AbstractDAO<Integer,MarketRolesEntity> implements RolesDAO{

    @Override
    public MarketRolesEntity getRoleByRoleId(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id",id));
        return (MarketRolesEntity) criteria.uniqueResult();
    }
}
