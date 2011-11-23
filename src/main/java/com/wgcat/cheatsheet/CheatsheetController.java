package com.wgcat.cheatsheet;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wgcat.cheatsheet.dao.ThemeDaoImpl;
import com.wgcat.cheatsheet.dao.ThemeDao;
import com.wgcat.cheatsheet.dbobjects.Theme;
import com.wgcat.cheatsheet.logic.CheatsheetLogic;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CheatsheetController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CheatsheetController.class);
	@Resource(name = "cheatsheetLogic")
	CheatsheetLogic cheatsheetLogic;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
	    
	    List<Theme> themes = cheatsheetLogic.getThemes();
	    String username = cheatsheetLogic.getUserName();
	    Boolean isAnonymous =cheatsheetLogic.getIsAnonymous();
	    
	    ModelMap modelMap = new ModelMap();
	    modelMap.addAttribute("themes", themes);
	    modelMap.addAttribute("username", username);
	    modelMap.addAttribute("is_anonymous", isAnonymous);
		LOGGER.info("Welcome home!");
		return new ModelAndView("home", modelMap);
	}
	
	@RequestMapping(value = "/showtheme", method = RequestMethod.GET)
	public ModelAndView showDefaultThemes(Model model) {
	    LOGGER.info("/theme handler entry");
	    ThemeDaoImpl dao = new ThemeDaoImpl();
	    List<Theme> themes = cheatsheetLogic.getThemes(); 
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("themes", themes);
        LOGGER.info("/theme handler return");
        return new ModelAndView("showtheme", modelMap);
	}
	
	@RequestMapping(value = "/theme/{profileId}", method = RequestMethod.GET)
    public String addTheme(@PathVariable String profileId, Model model) {
        LOGGER.info("/theme/{profileId} handler entry");
        ThemeDaoImpl dao = new ThemeDaoImpl();
        List<Theme> themes = cheatsheetLogic.getThemes(); 
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("themes", themes);
        LOGGER.info("/theme/{profileId} handler return");
        //return new ModelAndView("theme", modelMap);
        return "redirect:/badPage";
    }
	
	@RequestMapping(value = "/edittheme", method = RequestMethod.GET)
    public ModelAndView editTheme(Model model) {
	    LOGGER.info("Edit theme");
	    LOGGER.info(System.getProperty("user.name"));
        ThemeDaoImpl dao = new ThemeDaoImpl();
        List<Theme> themes = cheatsheetLogic.getThemes(); 
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("themes", themes);
        return new ModelAndView("edittheme", modelMap);
    }
}
