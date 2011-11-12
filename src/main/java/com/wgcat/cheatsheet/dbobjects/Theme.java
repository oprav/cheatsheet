package com.wgcat.cheatsheet.dbobjects;
import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;


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
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public Integer getId()
    {
        return id;
    }
    
    public int getVersion()
    {
        return version;
    }
}
