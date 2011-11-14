package com.wgcat.cheatsheet.logic;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wgcat.cheatsheet.dao.ThemeDao;
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
}
