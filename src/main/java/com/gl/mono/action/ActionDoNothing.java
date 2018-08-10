package com.gl.mono.action;

public class ActionDoNothing implements ActionNeedNothing, ActionWaitForInput {

    public static final String DO_NOTHING = "do nothing";

    @Override
    public void execute() {
        // do nothing
    }

    @Override
    public String describe() {
        return DO_NOTHING;
    }
}
