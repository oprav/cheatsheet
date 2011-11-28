package com.wgcat.cheatsheet.dbobjects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

@Entity
@Table(name="theme")
public class Theme implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="id")
    @SequenceGenerator(name="theme_id_seq", sequenceName="theme_id_seq")
    @GeneratedValue(generator="theme_id_seq")
    private Integer id;
    
    @Column(name="title")
    private String title;
    
    @Version
    @Column(name = "version")
    private int version = 0;
    
    @Column(name="descr")
    private String descr;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @OrderBy("sort_id")
    @JoinTable(
            name="topic",
            joinColumns = { @JoinColumn( name="theme_id") },
            inverseJoinColumns = @JoinColumn( name="id")
    )
    private List<Topic> topics;
    
    
    public Theme()
    {
        topics = 
                LazyList.decorate(new ArrayList(), FactoryUtils.instantiateFactory(com.wgcat.cheatsheet.dbobjects.Topic.class));
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getDescription()
    {
        return descr;
    }
    
    public void setDescription(String descr)
    {
        this.descr = descr;
    }
    
    public String getDescr()
    {
        return descr;
    }
    
    public void setDescr(String descr)
    {
        this.descr = descr;
    }
    
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
    
    public List getTopics()
    {
        return topics;
    }
    
    public void setTopics(List topics)
    {
        this.topics = topics;
    }
    
}
