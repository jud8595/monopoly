package com.gl.mono.square;

import com.gl.mono.action.Action;

import java.util.List;

public class StartSquare implements Square {

    private List<Action> actions;
    private Action hoverAction;

    public StartSquare(List<Action> actions, Action hoverAction) {
        this.actions = actions;
        this.hoverAction = hoverAction;
    }

    @Override
    public List<Action> getActions() {
        return this.actions;
    }

    @Override
    public Action hover() {
        return hoverAction;
    }
}
