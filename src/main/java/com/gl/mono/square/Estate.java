package com.gl.mono.square;

import com.gl.mono.action.Action;
import com.gl.mono.action.ActionDoNothing;

import java.util.List;

public class Estate implements Square {

    private List<Action> actions;
    private String name;

    public Estate(List<Action> action, String name) {
        this.actions = action;
        this.name = name;
    }

    public List<Action> getActions() {
        return actions;
    }

    @Override
    public Action hover() {
        return new ActionDoNothing();
    }

    public String getName() {
        return name;
    }
}
