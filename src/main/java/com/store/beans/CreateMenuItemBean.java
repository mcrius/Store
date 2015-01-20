package com.store.beans;

import com.store.boundary.MenuService;
import com.store.entity.Menu;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author bzzzt
 */
@ViewScoped
@ManagedBean
public class CreateMenuItemBean implements Serializable {

    @Inject
    MenuService menuService;

    private Menu item = new Menu();

    public String createMenuItem() {
        menuService.createMenuItem(item);
        return "index";
    }

    public Menu getItem() {
        return item;
    }

    public void setItem(Menu item) {
        this.item = item;
    }

}
