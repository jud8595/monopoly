package com.gl.mono.square;

import com.gl.mono.action.Action;

import java.util.List;

public interface Square {

    List<Action> getActions();

    Action hover();
}
