package com.gl.mono.action;

import com.gl.mono.game.Player;
import com.gl.mono.square.Estate;
import com.gl.mono.square.EstateService;

public class ActionBuyEstate implements ActionNeedCurrentPlayer, ActionWaitForInput {

    public static final String BUY_ESTATE = "buy estate";

    private EstateService estateService;
    private Estate estate;
    private ActionGiveRightRead actionGiveRightRead;

    public ActionBuyEstate(EstateService estateService, Estate estate, ActionGiveRightRead actionGiveRightRead) {
        this.estateService = estateService;
        this.estate = estate;
        this.actionGiveRightRead = actionGiveRightRead;
    }

    @Override
    public void execute(Player player) {
        estateService.registerBuy(estate, player);
    }

    public void execute() {
        ((ActionGiveRight) this.actionGiveRightRead).setPlayer(null);
        Player currentPlayer = this.actionGiveRightRead.askForRight(this);
        estateService.registerBuy(estate, currentPlayer);
    }

    @Override
    public String describe() {
        return BUY_ESTATE;
    }
}
