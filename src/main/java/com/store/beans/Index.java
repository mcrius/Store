package com.store.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author bzzzt
 */

@ViewScoped
@ManagedBean
public class Index implements Serializable{
    
    
    @PostConstruct
    public void init(){
        //init home page
    }
    
}
