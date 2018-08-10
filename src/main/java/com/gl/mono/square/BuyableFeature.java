package com.gl.mono.square;

import com.gl.mono.action.Action;
import com.gl.mono.action.ActionBuyEstate;

public class BuyableFeature implements Feature {

    private EstateService estateService;

    public BuyableFeature(EstateService estateService) {
        this.estateService = estateService;
    }

    //@Override
    public ActionBuyEstate createAction(Estate estate) {
        return new ActionBuyEstate(estateService, estate);
    }
}
