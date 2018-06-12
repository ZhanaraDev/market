package org.zhanara.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zhanara.dao.CashiersDAO;
import org.zhanara.dao.TransactionsDAO;
import org.zhanara.dao.UsersDAO;
import org.zhanara.models.MarketCashierEntity;
import org.zhanara.models.MarketTransactionHistoryEntity;
import org.zhanara.models.MarketUsersEntity;
import org.zhanara.services.CommonService;

import java.util.List;

@Controller
@RequestMapping(value = "/cashier")
public class CashierController {

    @Autowired
    CommonService commonService;

    @Autowired
    CashiersDAO cashiersDAO;

    @Autowired
    UsersDAO usersDAO;

    @Autowired
    TransactionsDAO transactionsDAO;

    @RequestMapping(value = "/")
    public String cashierProfile(ModelMap mp){
        String username = commonService.getPrincipal();
        MarketUsersEntity user = usersDAO.getUserByUsername(username);
        MarketCashierEntity cashierEntity = cashiersDAO.getCashierByUser(user);
        mp.addAttribute("cashier",cashierEntity);
        List<MarketTransactionHistoryEntity> transactionsOfaCashier = transactionsDAO.getTransactionHistoryListByCashierEntity(cashierEntity);
        mp.addAttribute("transactionsOfACashier",transactionsOfaCashier);
        return "cashier";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editCashier(@RequestParam(value = "id") String id,
                              @RequestParam(value = "name") String name,
                              @RequestParam(value = "surname") String surname){
        MarketCashierEntity cashierEntity = cashiersDAO.getCashier(Integer.parseInt(id));
        cashierEntity.setName(name);cashierEntity.setSurname(surname);
        cashiersDAO.updateCashier(cashierEntity);
        return "redirect:/cashier/";
    }
}
