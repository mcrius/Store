package com.store;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Store session info here.
 * @author bzzzt
 */
@SessionScoped
@ManagedBean
public class SessionBean implements Serializable {

    private String user;

    @PostConstruct
    public void init(){
        //init session here
        user = "Duke";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
