package com.gl.mono.action;

import com.gl.mono.game.Bank;
import com.gl.mono.CurrentPlayer;

public class ActionGetMoney implements Action {

    private int amount;
    private CurrentPlayer currentPlayer;
    private Bank bank;

    public ActionGetMoney(int amount, CurrentPlayer currentPlayer, Bank bank) {
        this.amount = amount;
        this.currentPlayer = currentPlayer;
        this.bank = bank;
    }

    @Override
    public void execute() {
        this.bank.playerGetMoney(this.currentPlayer.getCurrentPlayer(), amount);
    }

    @Override
    public String describe() {
        return "getting money. Amount=" + amount;
    }
}
