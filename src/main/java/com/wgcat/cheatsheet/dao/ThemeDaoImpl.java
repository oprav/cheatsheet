package com.wgcat.cheatsheet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wgcat.cheatsheet.dbobjects.Profile;
import com.wgcat.cheatsheet.dbobjects.Theme;
import com.wgcat.cheatsheet.dbobjects.Topic;

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
        List<Theme> themes = getHibernateTemplate().
                find("select distinct themeEntry from Theme themeEntry left join fetch themeEntry.topics order by themeEntry.id");
        return themes;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void removeTheme(Theme theme) {
        getHibernateTemplate().delete(theme);

    }
    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Theme getThemeById(Integer id)
    {
        Theme theme = getHibernateTemplate().get(Theme.class, id);
        if (theme.getId() != id) {
            logger.warn("Can't find hibernated object with id: "+id.toString());
        }
        return theme;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Theme> getThemesByProfile(Integer id)
    {
        Session hqlsession = getHibernateTemplate().getSessionFactory().openSession();
        String query = "select themeEntry from Theme themeEntry left join fetch themeEntry.topics where profile_id = ? order by themeEntry.id";
        Transaction t = hqlsession.beginTransaction();
        List<Theme> themesByProfile = hqlsession.createQuery(query).setInteger(0, id).list();
        t.commit();
        return themesByProfile;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Profile> listProfiles()
    {
        List<Profile> profiles = getHibernateTemplate().
                find("select * from profile order by id");
        return profiles;
    }
}
