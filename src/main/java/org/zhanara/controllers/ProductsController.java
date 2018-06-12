package org.zhanara.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zhanara.dao.CashiersDAO;
import org.zhanara.dao.ItemsDAO;
import org.zhanara.dao.TransactionsDAO;
import org.zhanara.dao.UsersDAO;
import org.zhanara.models.MarketItemsEntity;
import org.zhanara.models.MarketTransactionHistoryEntity;
import org.zhanara.models.MarketUsersEntity;
import org.zhanara.services.CommonService;

import java.sql.Date;
import java.sql.Timestamp;

@Controller
@RequestMapping(value = "/products")
public class ProductsController {

    @Autowired
    CommonService commonService;
    @Autowired
    ItemsDAO itemsDAO;
    @Autowired
    UsersDAO usersDAO;
    @Autowired
    CashiersDAO cashiersDAO;
    @Autowired
    TransactionsDAO transactionsDAO;

    @RequestMapping(value = "/")
    public String getAvailableProducts(ModelMap mp){
        String username = commonService.getPrincipal();
        MarketUsersEntity user = usersDAO.getUserByUsername(username);
        mp.addAttribute("cashier",cashiersDAO.getCashierByUser(user));
        mp.addAttribute("itemsList",itemsDAO.getItemsList());
        return "products";
    }

    @RequestMapping(value = "/commitTransaction")
    public String commitTransaction(@RequestParam(value = "item_id") String itemId,
                                    @RequestParam(value = "cashier_id") String cashierId,
                                    @RequestParam(value = "uniprodcode") String uniProdCode,
                                    @RequestParam(value = "amount") String numOfSoldProducts,
                                    ModelMap mp){
        MarketItemsEntity itemsEntity = itemsDAO.getItems(Integer.parseInt(itemId));
        if(itemsEntity.getUniversalProductCode() != Integer.parseInt(uniProdCode)){
            mp.addAttribute("errorMessage","Wrong Product Code!");
            return "redirect:/products/";
        }
        System.out.println("BYLO?");
        int numberOfSoldProducts = Integer.parseInt(numOfSoldProducts);
        int newAmount = 0;
        if(!(numberOfSoldProducts>itemsEntity.getAmounts())){
            newAmount = itemsEntity.getAmounts()-numberOfSoldProducts;
        }else{
            numberOfSoldProducts = itemsEntity.getAmounts();
        }
        itemsEntity.setAmounts(newAmount);
        itemsDAO.updateItem(itemsEntity);
        MarketTransactionHistoryEntity transaction = new MarketTransactionHistoryEntity(
                numberOfSoldProducts,new Timestamp(System.currentTimeMillis()),itemsDAO.getItems(Integer.parseInt(itemId)),
                cashiersDAO.getCashier(Integer.parseInt(cashierId))
        );
        System.out.println("TRANS "+transaction);
        transactionsDAO.addTransaction(transaction);
        return "redirect:/products/";
    }
}
