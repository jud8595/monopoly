package com.gl.mono.action;

import com.gl.mono.game.Player;

public interface ActionNeedCurrentPlayer extends Action {

    void execute(Player player);

    void execute();
}
