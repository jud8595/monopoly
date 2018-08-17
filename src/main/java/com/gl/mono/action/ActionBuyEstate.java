package com.gl.mono.action;

import com.gl.mono.Mono;
import com.gl.mono.game.Player;
import com.gl.mono.square.Estate;
import com.gl.mono.square.EstateService;

import java.util.Map;

public class ActionBuyEstate implements ActionNeedCurrentPlayer, ActionNeedBalance, ActionWaitForInput {

    public static final String BUY_ESTATE = "buy estate";

    private EstateService estateService;
    private Estate estate;

    private int balance;
    private Player player;

    public ActionBuyEstate(EstateService estateService, Estate estate) {
        this.estateService = estateService;
        this.estate = estate;
    }

    /*@Override
    public void execute(Player player, int balance) {
        estateService.registerBuy(estate, player, balance);
    }*/

    public void execute(Mono mono) {
        Player player = mono.getCurrentPlayer();
        //estateService.registerBuy(estate, player);
    }

    @Override
    public void execute() {
        estateService.registerBuy(
                estate,
                this.getPlayer(),
                this.getBalance());
    }

    @Override
    public String describe() {
        return BUY_ESTATE;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }
}
