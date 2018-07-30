package com.gl.mono;

import com.gl.mono.game.Player;

public class CurrentPlayer {

    private Mono mono;

    public CurrentPlayer(Mono mono) {
        this.mono = mono;
    }

    public Player getCurrentPlayer() {
        return this.mono.getCurrentPlayer();
    }
}
