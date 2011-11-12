package com.wgcat.cheatsheet.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wgcat.cheatsheet.dbobjects.Theme;

@Transactional(readOnly = true)
public class ThemeDaoImpl extends HibernateDaoSupport implements ThemeDao {

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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
