package com.store.beans;

import com.store.entity.Menu;
import com.store.entity.Offer;
import com.store.facade.MenuFacade;
import com.store.facade.OfferFacade;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bzzzt
 */
@ViewScoped
@ManagedBean
public class Index implements Serializable {

    @Inject
    MenuFacade menuFacade;
    @Inject
    OfferFacade offerFacade;

    private Integer counter = -1;
    private List<Menu> menuItems;
    private List<Offer> offerItems = null;

    private HttpServletRequest req = null;

    public Index() {
//	System.out.println(">>>>> " + counter);

    }

    @PostConstruct
    public void init() {
        //init home page
        counter++;
        System.out.println(">>>>> " + counter);
        menuItems = menuFacade.findAllWithoutParent();
        for (Menu mi : menuItems) {
            System.out.println(Arrays.toString(mi.getSubMenus().toArray()));
        }

        req = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
//        System.out.println(req.getParameter("property"));

        if (req != null && req.getParameter("c") != null && !req.getParameter("c").isEmpty()) {
            offerItems = offerFacade.findAllByCategory(Integer.parseInt(req.getParameter("c")));
        } else {
            offerItems = offerFacade.findAll();
        }
    }

    public void ajaxCounter(AjaxBehaviorEvent e) {
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

    public List<Offer> getOfferItems() {
        return offerItems;
    }

    public void setOfferItems(List<Offer> offerItems) {
        this.offerItems = offerItems;
    }

    public boolean notNullOrEmpty(List l) {
        return l != null && !l.isEmpty();
    }

}
