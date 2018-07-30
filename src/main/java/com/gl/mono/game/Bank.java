package com.gl.mono.game;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Player, Integer> balances = new HashMap<>();

    public void playerGetMoney(Player player, int amount) {
        if (balances.get(player) == null) {
            balances.put(player, 0);
        }
        balances.put(player, balances.get(player) + amount);
    }

    public int getBalance(Player player) {
        return this.balances.get(player);
    }
}
