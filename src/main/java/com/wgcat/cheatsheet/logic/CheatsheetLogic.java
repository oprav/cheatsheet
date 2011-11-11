package com.wgcat.cheatsheet.logic;

import com.wgcat.cheatsheet.dbobjects.Theme;

import java.util.List;

public interface CheatsheetLogic {
    public List<Theme> getThemes();
    public void saveTheme(Theme theme);
}
