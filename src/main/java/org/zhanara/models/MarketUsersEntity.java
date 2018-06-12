package org.zhanara.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "market_users")
public class MarketUsersEntity {
    private int id;
    private String login;
    private String password;
    private MarketRolesEntity marketRolesByRoleId;
    private Collection<MarketCashierEntity> cashierByCashierid;


    public MarketUsersEntity(String login, String password, MarketRolesEntity marketRolesByRoleId) {
        this.login = login;
        this.password = password;
        this.marketRolesByRoleId = marketRolesByRoleId;
    }

    public MarketUsersEntity() {
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
    @Column(name = "login", nullable = true, length = 30)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketUsersEntity that = (MarketUsersEntity) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public MarketRolesEntity getMarketRolesByRoleId() {
        return marketRolesByRoleId;
    }

    public void setMarketRolesByRoleId(MarketRolesEntity marketRolesByRoleId) {
        this.marketRolesByRoleId = marketRolesByRoleId;
    }

//    @OneToMany(cascade = ALL,mappedBy = "marketUsersEntity", orphanRemoval=true)
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "marketUsersEntity")
    public Collection<MarketCashierEntity> getCashierByCashierId() {
        return cashierByCashierid;
    }

    public void setCashierByCashierId(Collection<MarketCashierEntity> cashierByCashierid) {
        this.cashierByCashierid = cashierByCashierid;
    }


}
