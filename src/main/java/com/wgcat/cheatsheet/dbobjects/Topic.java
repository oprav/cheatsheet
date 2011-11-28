package com.wgcat.cheatsheet.dbobjects;

import java.io.Serializable;
import javax.jdo.annotations.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


@Entity
@Table(name="topic")
public class Topic implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    @SequenceGenerator(name="topic_id_seq", sequenceName="topic_id_seq")
    @GeneratedValue(generator="topic_id_seq")
    private Integer id;
    
    @Version
    @Column(name = "version")
    private int version = 0;
    
    @Column(name="theme_id")
    private int theme_id;
    
    @Column(name = "title", length=500)
    String title;
    
    @Column(name = "descr")
    String descr;
    
    @Column(name = "sort_id")
    private int sort_id;
    
    @Column(name = "is_delete")
    private boolean is_delete;
    
    @ManyToOne
    @JoinColumn(name="theme_id", insertable=false, updatable=false)
    private Theme theme;
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public int getVersion()
    {
        return version;
    }
    
    public int getTheme_id()
    {
        return theme_id;
    }
    
    public void setTheme_id(int themeId)
    {
        this.theme_id = themeId;
    }
    
    public int getSort_id()
    {
        return sort_id;
    }
    
    public void setSort_id(int sortId)
    {
        this.sort_id = sortId;
    }
    
    public boolean getIs_delete()
    {
        return is_delete;
    }
    
    public void setIs_delete(boolean isDelete)
    {
        this.is_delete = isDelete;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getDescription()
    {
        return this.descr;
    }
    
    public String getDescr()
    {
        return descr;
    }
    
    public void setDescr(String descr)
    {
        this.descr = descr;
    }
    
    public void setDescription(String descr)
    {
        this.descr = descr;
    }
    
    public Theme getTheme()
    {
        return theme;
    }
}
