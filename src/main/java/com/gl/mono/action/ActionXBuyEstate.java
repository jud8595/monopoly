package com.gl.mono.action;

import com.gl.mono.game.Player;
import com.gl.mono.square.Estate;
import com.gl.mono.square.EstateService;

public class ActionXBuyEstate implements ActionXNeedPlayer {

    private EstateService estateService;
    private Estate estate;
    private Player player;

    public ActionXBuyEstate(EstateService estateService, Estate estate, Player player) {
        this.estateService = estateService;
        this.estate = estate;
        this.player = player;
    }

    @Override
    public void execute() {
        estateService.registerBuy(estate, player);
    }

    @Override
    public String describe() {
        return "buy estate";
    }

    @Override
    public Action getActionX(Player player) {
        return null;
    }
}
