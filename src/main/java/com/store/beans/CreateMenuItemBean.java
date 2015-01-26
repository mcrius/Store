package com.store.beans;

import com.store.boundary.MenuService;
import com.store.entity.Menu;
import com.store.facade.MenuFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
    @Inject
    MenuFacade menuFacade;

    private Menu item = new Menu();
    private Integer parentId;
    private List<Menu> parents;

    @PostConstruct
    public void init() {
        parents = menuFacade.findAllWithoutParent();
    }

    public String createMenuItem() {
        if (parentId != null && parentId != -1) {
            menuService.createWithParent(item, parentId);
        } else {
            menuService.createMenuItem(item);
        }
        return "index";
    }

    public Menu getItem() {
        return item;
    }

    public void setItem(Menu item) {
        this.item = item;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getParents() {
        return parents;
    }

    public void setParents(List<Menu> parents) {
        this.parents = parents;
    }

}
