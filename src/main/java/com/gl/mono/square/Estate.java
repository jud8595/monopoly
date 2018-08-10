package com.gl.mono.square;

import com.gl.mono.action.*;
import com.gl.mono.game.Player;

public class Estate implements Square, SquareXNeedPlayer {

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
    public ActionX getActionX(Player player) {
        return new ActionXBuyEstate(estateService, this, player);
    }

    @Override
    public Action hover() {
        return new ActionDoNothing();
    }

    public String getName() {
        return name;
    }

}
