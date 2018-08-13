package com.gl.mono;

import com.gl.mono.action.*;
import com.gl.mono.game.Bank;
import com.gl.mono.game.Dice;
import com.gl.mono.game.Player;
import com.gl.mono.square.EstateService;
import com.gl.mono.square.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mono {

    private int currentPlayer;
    private Dice dice;
    private List<Player> players;
    private List<Square> squares;
    private List<Integer> positions;
    private List<Integer> balances;
    private EstateService estateService;
    private Bank bank;

    public Mono(int playerCount, Dice dice, List<Square> squares, EstateService estateService, Bank bank) {
        players = new ArrayList<>();
        for (int i=0; i<playerCount; ++i) {
            players.add(new Player("player" + i));
        }
        currentPlayer = 0;
        this.estateService = estateService;
        this.bank = bank;
        this.dice = dice;
        this.squares = squares;
        this.positions = new ArrayList<>();
        this.balances = new ArrayList<>();
        this.players.stream().forEach(p -> {
            this.positions.add(0);
            this.balances.add(0);
            this.bank.playerGetMoney(p, 0);
        });
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<String> play() {
        int num = this.dice.throwDice();
        List<Action> hoverActions = new ArrayList<>();

        for (int i=1; i<num; ++i) {
            hoverActions.add(squares.get(positions.get(currentPlayer) + i).hover());
        }
        hoverActions.forEach(a -> {
            executeAction(a);
            System.out.println(a.describe());
        });

        positions.set(currentPlayer, positions.get(currentPlayer) + num);
        // Actions which do not wait for user input
        squares.get(getCurrentPlayer().getPos()).getActions()
                .stream()
                .filter(a -> !(a instanceof ActionWaitForInput))
                .forEach(a -> {
                    executeAction(a);
                    System.out.println(a.describe());
                });

        List<String> actions = squares.get(getCurrentPlayer().getPos()).getActions()
                .stream()
                .filter(a -> a instanceof ActionWaitForInput)
                .map(a -> a.describe())
                .collect(Collectors.toList());

        return actions;
    }

    public Player nextTurn() {
        currentPlayer = (currentPlayer+1)%players.size();
        Player player = getCurrentPlayer();
        return player;
    }

    public Player getCurrentPlayer() {
        Player cur = players.get(currentPlayer);
        cur.setPos(positions.get(currentPlayer));
        cur.setEstates(this.estateService.getEstates(cur));
        cur.setBalance(this.bank.getBalance(cur));
        return cur;
    }

    public void executeAction(int actionNum) {
        Action action = squares.get(getCurrentPlayer().getPos()).getActions().stream()
                .filter(a -> a instanceof ActionWaitForInput)
                .collect(Collectors.toList())
                .get(actionNum);

        executeAction(action);
    }

    private void executeAction(Action action) {
        if (action instanceof ActionNeedCurrentPlayer) {
            //((ActionNeedCurrentPlayer) action).execute(getCurrentPlayer());
            ((ActionNeedCurrentPlayer) action).execute(this);
        } else if (action instanceof ActionNeedNothing) {
            ((ActionNeedNothing) action).execute();
        } else {
            throw new IllegalArgumentException("Unknown type of action");
        }
    }
}
