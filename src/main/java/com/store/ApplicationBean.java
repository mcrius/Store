package com.store;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Store application global config ..
 * @author bzzzt
 */
@ApplicationScoped
@ManagedBean
public class ApplicationBean {

    public ApplicationBean() {
    }

    
    @PostConstruct
    public void init(){
        //todo init variables if needed
    }
    
}
