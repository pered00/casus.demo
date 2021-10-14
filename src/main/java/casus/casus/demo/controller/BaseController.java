package casus.casus.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {
    @GetMapping("/")

    public @ResponseBody
    String sayHello(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails){
            String userName= ((UserDetails) (auth.getPrincipal())).getUsername();
            return "Hello "+ userName;
        }

        return "Hello stranger!";
    }

    @GetMapping("/public")
    public @ResponseBody String showPublic(){
        return  "public page";
    }

    @GetMapping("/admin")
    public @ResponseBody String showSecret(){
        return  "secret page";
    }
}
