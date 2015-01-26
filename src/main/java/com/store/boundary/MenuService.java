package com.store.boundary;

import com.store.entity.Menu;
import com.store.facade.MenuFacade;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author bzzzt
 */
@Stateless
public class MenuService {

    @Inject
    MenuFacade menuFacade;

    public void createMenuItem(Menu item) {
        menuFacade.create(item);
        logCreate(item);
    }

    @Asynchronous
    public void logCreate(Menu item) {
        //log neshto si nqakde
    }

    public void createWithParent(Menu item, Integer parentId) {
        Menu parent = menuFacade.find(parentId);
        if (parent != null) {
            if (parent.getSubMenus() == null) {
                parent.setSubMenus(Arrays.asList(item));
            } else {
                parent.getSubMenus().add(item);
            }
        }
        menuFacade.edit(parent);
    }
}
