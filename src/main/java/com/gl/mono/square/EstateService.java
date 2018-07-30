package com.gl.mono.square;

import com.gl.mono.game.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class EstateService {

    private Map<Estate, Player> estates = new HashMap<>();

    public void registerBuy(Estate estate, Player currentPlayer) {
        this.estates.put(estate, currentPlayer);
    }

    public List<Estate> getEstates(Player player) {
        return this.estates.entrySet().stream()
                .filter(e -> e.getValue().equals(player))
                .map(e -> e.getKey())
                .collect(toList());
    }
}
