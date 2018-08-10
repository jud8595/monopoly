package com.gl.mono.square;

import com.gl.mono.action.Action;
import com.gl.mono.action.ActionBuyEstate;
import com.gl.mono.action.ActionDoNothing;

import java.util.ArrayList;
import java.util.List;

public class Estate implements Square {

    private List<Action> actions = new ArrayList<>();
    private EstateService estateService;
    private String name;

    public Estate(EstateService estateService, String name) {
        this.actions.add(new ActionDoNothing());
        this.actions.add(new ActionBuyEstate(estateService, this));
        this.name = name;
    }

    @Override
    public List<Action> getActions() {
        return this.actions;
    }

    @Override
    public Action hover() {
        return new ActionDoNothing();
    }

    public String getName() {
        return name;
    }

}
