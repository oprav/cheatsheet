package com.wgcat.cheatsheet.logic;

import com.wgcat.cheatsheet.dbobjects.Theme;
import com.wgcat.cheatsheet.dbobjects.Profile;

import java.util.List;

public interface CheatsheetLogic {
    public List<Theme> getThemes();
    public List<Theme> getThemesByProfile(Integer profileId);
    
    public Theme getThemeById(Integer themeId);
    
    public List<Profile> getProfiles();
    public void saveTheme(Theme theme);
    
    public String getUserName();
    public Boolean getIsAnonymous();
}
