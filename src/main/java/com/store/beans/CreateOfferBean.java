package com.store.beans;

import com.store.boundary.OfferService;
import com.store.entity.Offer;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author bzzzt
 */
@ManagedBean
@ViewScoped
public class CreateOfferBean implements Serializable {

    @Inject
    OfferService offerService;

    private Offer offer = new Offer();

    public String createOffer() {
        if (validate()) {
            offerService.createOfferItem(offer);
            return "index";
        } else {
            //error message
            return null;
        }
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    // ----- private 
    /**
     * To-do complex validations if needed
     *
     * @return
     */
    private boolean validate() {
        return true;
    }

}
