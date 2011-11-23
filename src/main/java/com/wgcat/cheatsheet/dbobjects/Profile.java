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
@Table(name="profile")
public class Profile implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    @SequenceGenerator(name="profile_id_seq", sequenceName="profile_id_seq")
    @GeneratedValue(generator="profile_id_seq")
    private Integer id;
    
    @Column(name = "title", length=100)
    String title;
    
    @Version
    @Column(name = "version")
    private int version = 0;
        
    public Integer getId()
    {
        return id;
    }
    
    public int getVersion()
    {
        return version;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
}
