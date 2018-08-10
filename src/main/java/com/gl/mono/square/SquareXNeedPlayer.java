package com.gl.mono.square;

import com.gl.mono.action.ActionX;
import com.gl.mono.game.Player;

public interface SquareXNeedPlayer extends SquareX {

    ActionX getActionX(Player player);

}
