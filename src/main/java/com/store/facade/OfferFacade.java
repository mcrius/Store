/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.facade;

import com.store.entity.Menu;
import com.store.entity.Offer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bzzzt
 */
@Stateless
public class OfferFacade extends AbstractFacade<Offer> {

    @PersistenceContext(unitName = "com_Store_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OfferFacade() {
        super(Offer.class);
    }

    /**
     * All that have a parent will be queried in the relation @OneToMany and
     * lazily loaded
     *
     * @return
     */
    public List<Offer> findAll() {
        return em.createNamedQuery("Offer.findAll", Offer.class).getResultList();
    }
    
    public List<Offer> findAllByCategory(String c) {
	System.out.println("CategoryID = " + c);
	return em.createNamedQuery("Offer.findByCategoryId", Offer.class).setParameter("categoryId", c).getResultList();
    }

}
