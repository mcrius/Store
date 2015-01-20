package com.store.beans;

import com.store.entity.Menu;
import com.store.facade.MenuFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;

/**
 *
 * @author bzzzt
 */
@ViewScoped
@ManagedBean
public class Index implements Serializable {

    @Inject
    MenuFacade menuFacade;

    private Integer counter = -1;
    private List<Menu> menuItems;

    public Index() {
        System.out.println(">>>>> " + counter);
        
    }

    @PostConstruct
    public void init() {
        //init home page
        counter++;
        System.out.println(">>>>> " + counter);
        menuItems = menuFacade.findAll();
    }
    
    public void ajaxCounter(AjaxBehaviorEvent e){
        counter++;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public List<Menu> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<Menu> menuItems) {
        this.menuItems = menuItems;
    }

}
