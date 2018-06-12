package org.zhanara.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zhanara.dao.CashiersDAO;
import org.zhanara.dao.ItemsDAO;
import org.zhanara.models.MarketCashierEntity;
import org.zhanara.models.MarketItemsEntity;
import org.zhanara.services.CommonService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    CommonService commonService;
    @Autowired
    CashiersDAO cashiersDAO;
    @Autowired
    ItemsDAO itemsDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        String username = commonService.getPrincipal();
        model.addAttribute("user", username);
        model.addAttribute("cashiersList", cashiersDAO.getCashiers());
        System.out.println("!!!Username: "+username);
        return "admin";
    }

    @RequestMapping(value = "/addCashier",method = RequestMethod.POST)
    public String addCashier(@RequestParam(value = "name") String name,
                             @RequestParam(value = "surname") String surname,
                             @RequestParam(value = "login") String login){
        cashiersDAO.addCashier(name,surname,login);
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/deleteCashier")
    public String addCashier(@RequestParam(value = "id") String id){
        cashiersDAO.deleteCashier(Integer.parseInt(id));
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/editCashier")
    public String editCashier(@RequestParam(value = "id") String id,ModelMap mp){
        MarketCashierEntity cashier = cashiersDAO.getCashier(Integer.parseInt(id));
        String username = commonService.getPrincipal();
        mp.addAttribute("user", username);
        mp.addAttribute("cashierEntity",cashier);
        return "edit";
    }

    @RequestMapping(value = "/editCashier", method = RequestMethod.POST)
    public String editCashier(@RequestParam(value = "name") String name,
                              @RequestParam(value = "surname") String surname,
//                              @RequestParam(value = "login") String login,
                              @RequestParam(value = "id") String id){
        MarketCashierEntity cashier = cashiersDAO.getCashier(Integer.parseInt(id));
        cashier.setName(name);cashier.setSurname(surname);
        cashiersDAO.updateCashier(cashier);
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/items")
    public String getItems(ModelMap mp){
        String username = commonService.getPrincipal();
        mp.addAttribute("user", username);
        mp.addAttribute("itemsList",itemsDAO.getItemsList());
        return "admin";
    }

    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    public String addItem(@RequestParam(value = "name")String name,
                          @RequestParam(value = "uniProdCode") String uniProdCode,
                          @RequestParam(value = "price") String price,
                          @RequestParam(value = "amounts") String amounts){
        MarketItemsEntity item = new MarketItemsEntity(name,Integer.parseInt(uniProdCode),
                Integer.parseInt(price),Integer.parseInt(amounts));
        itemsDAO.addItem(item);
        return "redirect:/admin/items";
    }

    @RequestMapping(value = "/editItem",method = RequestMethod.GET)
    public String editItem(@RequestParam(value = "id") String id,ModelMap mp){
        MarketItemsEntity item = itemsDAO.getItems(Integer.parseInt(id));
        String username = commonService.getPrincipal();
        mp.addAttribute("user", username);
        mp.addAttribute("item", item);
        return "edit";
    }

    @RequestMapping(value = "/editItem",method = RequestMethod.POST)
    public String editItem(@RequestParam(value = "name")String name,
                          @RequestParam(value = "uniProdCode") String uniProdCode,
                          @RequestParam(value = "price") String price,
                          @RequestParam(value = "id") String id,
                          @RequestParam(value = "amounts") String amounts){
        MarketItemsEntity item = itemsDAO.getItems(Integer.parseInt(id));
        item.setName(name);item.setUniversalProductCode(Integer.parseInt(uniProdCode));item.setPrice(Integer.parseInt(price));
        item.setAmounts(Integer.parseInt(amounts));
        itemsDAO.updateItem(item);
        return "redirect:/admin/items";
    }

    @RequestMapping(value = "/deleteItem")
    public String editItem(@RequestParam(value = "id")String id){
        MarketItemsEntity item = itemsDAO.getItems(Integer.parseInt(id));
        itemsDAO.deleteItem(item);
        return "redirect:/admin/items";
    }
}
