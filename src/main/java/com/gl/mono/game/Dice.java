package com.gl.mono.game;

import java.util.Random;

public class Dice {

    private int max;
    private Random rand;

    public Dice(int max) {
        this.max = max;
        rand = new Random();
    }

    public int throwDice() {
        return rand.nextInt(max) + 1;
    }
}
