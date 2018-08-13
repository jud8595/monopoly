package com.gl.mono.action;

import com.gl.mono.game.Player;

public class ActionGiveRight {

    private Player player;

    public Player askForRight(ActionNeedCurrentPlayer actionNeedCurrentPlayer) {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
