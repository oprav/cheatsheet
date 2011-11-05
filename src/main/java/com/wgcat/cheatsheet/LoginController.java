package com.wgcat.cheatsheet;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles login page processing
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleLogin()
    {
        //LOGGER.info("loginPage");
        return "redirect:/login";
    }
    

}
