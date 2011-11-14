package com.wgcat.cheatsheet;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wgcat.cheatsheet.dao.ThemeDaoImpl;
import com.wgcat.cheatsheet.dbobjects.Theme;
import com.wgcat.cheatsheet.logic.CheatsheetLogic;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	@Resource(name = "cheatsheetLogic")
	CheatsheetLogic cheatsheetLogic;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
	    List<Theme> themes = cheatsheetLogic.getThemes(); 
	    ModelMap modelMap = new ModelMap();
	    modelMap.addAttribute("themes", themes);
		LOGGER.info("Welcome home!");
		return new ModelAndView("home", modelMap);
	}
}
