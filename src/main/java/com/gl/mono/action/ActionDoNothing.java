package com.gl.mono.action;

public class ActionDoNothing implements ActionNeedNothing {

    @Override
    public void execute() {
        // do nothing
    }

    @Override
    public String describe() {
        return "do nothing";
    }
}
