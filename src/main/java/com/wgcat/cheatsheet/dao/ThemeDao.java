package com.wgcat.cheatsheet.dao;

import java.util.List;

import com.wgcat.cheatsheet.dbobjects.Theme;


public interface ThemeDao {
    public void addTheme(Theme theme);
    public List<Theme> listThemes();
    public void removeTheme(Theme theme);
}
