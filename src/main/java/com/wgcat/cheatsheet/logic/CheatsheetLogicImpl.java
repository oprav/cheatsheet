package com.wgcat.cheatsheet.logic;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wgcat.cheatsheet.dao.ThemeDao;
import com.wgcat.cheatsheet.dbobjects.Profile;
import com.wgcat.cheatsheet.dbobjects.Theme;

@Transactional(readOnly = true)
public class CheatsheetLogicImpl implements CheatsheetLogic 
{
    private ThemeDao dao;
    @Override
    public List<Theme> getThemes()
    {
        return dao.listThemes();
    }
    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTheme(Theme theme)
    {
        dao.addTheme(theme);
    }
    
    public void setDao(ThemeDao dao)
    {
        this.dao = dao;
    }
    
    @Override
    public String getUserName()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername().toString();
        }
        return username;
    }
    
    @Override
    public Boolean getIsAnonymous()
    {
        return getUserName().equalsIgnoreCase("anonymousUser");
    }
    
    @Override
    public List<Theme> getThemesByProfile(int profileId)
    {
        return dao.getThemesByProfile(profileId);
    }
    
    @Override 
    public List<Profile> getProfiles()
    {
        return dao.listProfiles();
    }
}
