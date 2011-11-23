package com.wgcat.cheatsheet.dao;

import java.util.List;

import com.wgcat.cheatsheet.dbobjects.Profile;
import com.wgcat.cheatsheet.dbobjects.Theme;


public interface ThemeDao {
    public void addTheme(Theme theme);
    public List<Theme> listThemes();
    public void removeTheme(Theme theme);
    public Theme getThemeById(Integer id);
    public List<Theme> getThemesByProfile(Integer id);
    public List<Profile> listProfiles();
}
