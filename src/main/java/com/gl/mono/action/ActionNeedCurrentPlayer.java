package com.gl.mono.action;

import com.gl.mono.Mono;
import com.gl.mono.game.Player;

public interface ActionNeedCurrentPlayer extends Action {

    /*void execute(Player player);

    void execute(Mono mono);*/

    Player getPlayer();

    void setPlayer(Player player);
}
