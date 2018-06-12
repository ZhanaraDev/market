package org.zhanara.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zhanara.services.CommonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    CommonService commonService;


    @RequestMapping(value = "/")
    public String getLoginPage(){
        return "redirect:/login";
    }

    @RequestMapping(value = "/login")
    public String getLoginPage(@RequestParam(value="error",required=false) String error,
                               @RequestParam(value="logout",required=false) String logoutStr,
                               Model model){

        model.addAttribute("error",error != null);
        model.addAttribute("logoutStr",logoutStr != null);
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request){
        if(request.isUserInRole("ROLE_ADMIN")){

            return "redirect:/admin/";
        }
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "redirect:/cashier/";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
}
