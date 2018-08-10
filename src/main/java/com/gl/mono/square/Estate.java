package com.gl.mono.square;

import com.gl.mono.action.Action;
import com.gl.mono.action.ActionBuyEstate;
import com.gl.mono.action.ActionDoNothing;

public class Estate implements Square {

    private ActionBuyEstate action;
    private String name;

    public Estate(BuyableFeature feature, String name) {
        this.action = feature.createAction(this);
        this.name = name;
    }

    @Override
    public Action getAction() {
        return this.action;
    }

    @Override
    public Action hover() {
        return new ActionDoNothing();
    }

    public String getName() {
        return name;
    }

}
