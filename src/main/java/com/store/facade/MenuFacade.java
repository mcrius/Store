/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.facade;

import com.store.entity.Menu;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bzzzt
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> {

    @PersistenceContext(unitName = "com_Store_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }

    /**
     * All that have a parent will be queried in the relation @OneToMany and
     * lazily loaded
     *
     * @return
     */
    public List<Menu> findAllWithoutParent() {
        return em.createNativeQuery("SELECT * FROM menu m where m.parent_id is null", Menu.class).getResultList();
    }

}
