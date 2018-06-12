package org.zhanara.services.implementation;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.zhanara.services.CommonService;


@Service("CommonServiceI")
public class CommonServiceImpl implements CommonService{

    @Override
    public String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Entered peincipal: "+principal.toString());
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
            System.out.println("!!!USERNAME - "+userName);
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
