package com.gl.mono.action;

import com.gl.mono.game.Player;

public interface ActionXNeedPlayer extends ActionX {

    ActionX getActionX(Player player);
}
