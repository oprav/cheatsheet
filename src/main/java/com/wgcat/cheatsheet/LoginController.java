package com.wgcat.cheatsheet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles login page processing
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleLogin()
    {
        LOGGER.info("loginPage");
        return "redirect:/login";
    }
    

}
