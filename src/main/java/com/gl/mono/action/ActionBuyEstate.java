package com.gl.mono.action;

import com.gl.mono.CurrentPlayer;
import com.gl.mono.square.Estate;
import com.gl.mono.square.EstateService;

public class ActionBuyEstate implements Action {

    private EstateService estateService;
    private Estate estate;
    private CurrentPlayer currentPlayer;

    public ActionBuyEstate(EstateService estateService, Estate estate, CurrentPlayer currentPlayer) {
        this.estateService = estateService;
        this.estate = estate;
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void execute() {
        estateService.registerBuy(estate, currentPlayer.getCurrentPlayer());
    }

    @Override
    public String describe() {
        return "buy estate";
    }
}
