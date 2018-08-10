package com.gl.mono.square;

import com.gl.mono.action.Action;

import java.util.List;

public class Start implements Square {

    private final Action hoverAction;
    //private final List<Action> actions;

    public Start(/*List<Action> actions,*/ Action hoverAction) {
        //this.actions = actions;
        this.hoverAction = hoverAction;
    }

    @Override
    public Action getAction() {
        return null;
    }

    @Override
    public Action hover() {
        return hoverAction;
    }
}
