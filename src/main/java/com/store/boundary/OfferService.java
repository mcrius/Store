package com.store.boundary;

import com.store.entity.Menu;
import com.store.entity.Offer;
import com.store.facade.OfferFacade;
import java.util.Arrays;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author bzzzt
 */
@Stateless
public class OfferService {

    @Inject
    OfferFacade offerFacade;

    public void createOfferItem(Offer item) {
        offerFacade.create(item);
        logCreate(item);
    }

    @Asynchronous
    public void logCreate(Offer item) {
        //log neshto si nqakde
    }
    
    public void createOffer(Offer item) {
        //
    }

//    public void createWithParent(Menu item, Integer parentId) {
//        Menu parent = menuFacade.find(parentId);
//        if (parent != null) {
//            if (parent.getSubMenus() == null) {
//                parent.setSubMenus(Arrays.asList(item));
//            } else {
//                parent.getSubMenus().add(item);
//            }
//        }
//        menuFacade.edit(parent);
//    }
}
