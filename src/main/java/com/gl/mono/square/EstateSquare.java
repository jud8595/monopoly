package com.gl.mono.square;

import com.gl.mono.action.Action;
import com.gl.mono.action.ActionDoNothing;

import java.util.List;

public class EstateSquare implements Square {

    private Estate estate;
    private List<Action> actions;

    public EstateSquare(Estate estate, List<Action> actions) {
        this.estate = estate;
        this.actions = actions;
    }

    @Override
    public List<Action> getActions() {
        return this.actions;
    }

    @Override
    public Action hover() {
        return new ActionDoNothing();
    }
}
