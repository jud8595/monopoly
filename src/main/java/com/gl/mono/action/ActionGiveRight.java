package com.gl.mono.action;

import com.gl.mono.game.Player;

public class ActionGiveRight implements ActionGiveRightRead {

    private Player player;

    @Override
    public Player askForRight(ActionNeedCurrentPlayer actionNeedCurrentPlayer) {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
