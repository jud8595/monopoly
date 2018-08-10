package com.gl.mono.square;

import com.gl.mono.action.Action;
import com.gl.mono.action.ActionDoNothing;

import java.util.ArrayList;
import java.util.List;

public class Start implements Square {

    private Action hoverAction;
    private List<Action> actions = new ArrayList<>();

    public Start() {
        this.actions.add(new ActionDoNothing());
        this.hoverAction = new ActionDoNothing();
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
