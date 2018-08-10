package com.gl.mono.square;

import com.gl.mono.action.Action;
import com.gl.mono.action.ActionBuyEstate;
import com.gl.mono.action.ActionDoNothing;

public class Estate implements Square {

    private ActionBuyEstate action;
    private EstateService estateService;
    private String name;

    public Estate(EstateService estateService, String name) {
        this.action = new ActionBuyEstate(estateService, this);
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
