package com.gl.mono.action;

import com.gl.mono.game.Player;
import com.gl.mono.square.Estate;
import com.gl.mono.square.EstateService;

public class ActionBuyEstate implements ActionNeedCurrentPlayer, ActionWaitForInput {

    public static final String BUY_ESTATE = "buy estate";

    private EstateService estateService;
    private Estate estate;

    public ActionBuyEstate(EstateService estateService, Estate estate) {
        this.estateService = estateService;
        this.estate = estate;
    }

    @Override
    public void execute(Player player) {
        estateService.registerBuy(estate, player);
    }

    @Override
    public String describe() {
        return BUY_ESTATE;
    }
}
