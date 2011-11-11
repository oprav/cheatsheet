package com.wgcat.cheatsheet.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wgcat.cheatsheet.dbobjects.Theme;


public class ThemeDaoImpl extends HibernateDaoSupport implements ThemeDao {

    @Override
    public void addTheme(Theme theme) {
        getHibernateTemplate().saveOrUpdate(theme);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Theme> listThemes() {
        return getHibernateTemplate().
                find("from theme themeEntry order by themeEntry._id");
    }

    @Override
    public void removeTheme(Theme theme) {
        getHibernateTemplate().delete(theme);

    }

}
