package com.gl.mono.action;

import com.gl.mono.Mono;
import com.gl.mono.game.Player;

public interface ActionNeedBalance extends Action {
/*
    void execute(int balance);

    void execute(Mono mono);*/

    int getBalance();

    void setBalance(int balance);
}
