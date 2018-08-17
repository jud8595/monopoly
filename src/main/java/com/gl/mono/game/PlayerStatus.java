package com.gl.mono.game;

import com.gl.mono.square.Estate;

import java.util.List;

public class PlayerStatus {

    private int pos;
    private int balance;
    private List<Estate> estates;

    public PlayerStatus(int pos, int balance, List<Estate> estates) {
        this.pos = pos;
        this.balance = balance;
        this.estates = estates;
    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
