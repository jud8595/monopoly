package com.gl.mono.action;

import com.gl.mono.Mono;
import com.gl.mono.game.Bank;
import com.gl.mono.game.Player;

public class ActionGetMoney implements ActionNeedCurrentPlayer {

    private int amount;
    private Bank bank;

    public ActionGetMoney(int amount, Bank bank) {
        this.amount = amount;
        this.bank = bank;
    }

    @Override
    public void execute(Player player) {
        this.bank.playerGetMoney(player, amount);
    }

    @Override
    public void execute(Mono mono) {
        Player player = mono.getCurrentPlayer();
        this.bank.playerGetMoney(player, amount);
    }

    @Override
    public String describe() {
        return "getting money. Amount=" + amount;
    }
}
