package com.gl.mono.action;

import com.gl.mono.Mono;
import com.gl.mono.game.Player;

public interface ActionNeedCurrentPlayerAndBalance extends Action {

    void execute(Player player, int balance);

    void execute(Mono mono);
}
