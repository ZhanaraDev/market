package org.zhanara.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zhanara.dao.CashiersDAO;
import org.zhanara.dao.TransactionsDAO;
import org.zhanara.models.MarketTransactionHistoryEntity;
import org.zhanara.services.CommonService;

import java.util.List;

@Controller
@RequestMapping(value = "/transactions")
public class TransactionsController {

    @Autowired
    TransactionsDAO transactionsDAO;
    @Autowired
    CashiersDAO cashiersDAO;
    @Autowired
    CommonService commonService;

//    @RequestMapping(value = "/")
//    public String getTransactionsListOfCurrentCashier(@RequestParam(value = "id") String id,
//                                                      ModelMap mp){
//        List<MarketTransactionHistoryEntity> transactionsOfaCashier = transactionsDAO.getTransactionHistoryListByCashierEntity(cashiersDAO.getCashier(Integer.parseInt(id)));
//        mp.addAttribute("cashier",cashiersDAO.getCashier(Integer.parseInt(id)));
//        mp.addAttribute("transactionsOfACashier",transactionsOfaCashier);
//        return "transactions";
//    }

    @RequestMapping(value = "/all")
    public String getTransactionsList(ModelMap mp){
        List<MarketTransactionHistoryEntity> transactionsList = transactionsDAO.getFullTransactionsHistory();
        mp.addAttribute("transactionsList",transactionsList);
        return "admin";
    }
}
