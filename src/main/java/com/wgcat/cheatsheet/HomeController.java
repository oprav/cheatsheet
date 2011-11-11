package com.wgcat.cheatsheet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wgcat.cheatsheet.dao.ThemeDaoImpl;
import com.wgcat.cheatsheet.dbobjects.Theme;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
	    /*Theme theme = new Theme();
	    theme.setTitle("Bla Bla");
	    ThemeDaoImpl dao = new ThemeDaoImpl();
	    dao.addTheme(theme);*/
		LOGGER.info("Welcome home!");
		return "home";
	}
	
	
}
