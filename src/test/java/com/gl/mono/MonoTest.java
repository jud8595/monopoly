package com.gl.mono;

import com.gl.mono.action.Action;
import com.gl.mono.action.ActionBuyEstate;
import com.gl.mono.action.ActionDoNothing;
import com.gl.mono.action.ActionGetMoney;
import com.gl.mono.game.Bank;
import com.gl.mono.game.Dice;
import com.gl.mono.square.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MonoTest {

    private Mono mono;

    @Mock
    private Dice dice;

    private List<Square> squares;

    private EstateService estateService;
    private Bank bank;


    @Before
    public void setUp() {
        squares = new ArrayList<>();
        estateService = new EstateService();
        bank = new Bank();

        // start square
        List<Action> actionsStartSquare = new ArrayList<>();
        actionsStartSquare.add(new ActionGetMoney(5000, bank));
        StartSquare startSquare = new StartSquare(actionsStartSquare, new ActionGetMoney(1000, bank));

        // estate square
        Estate estate = new Estate("rue Rivoli");
        List<Action> actions = new ArrayList<>();
        actions.add(new ActionDoNothing());
        actions.add(new ActionBuyEstate(estateService, estate));
        EstateSquare estate1 = new EstateSquare(estate, actions);

        // bill squares
        squares.add(startSquare);
        squares.add(startSquare);
        for (int i=0; i<20; ++i) {
            squares.add(estate1);
        }

        mono = new Mono(4, dice, squares, estateService, bank);
    }

    @Test
    public void add_four_pl() {
        Assert.assertEquals(4, mono.getPlayerCount());
    }

    @Test
    public void pl1_play() {
        when(dice.throwDice()).thenReturn(8);
        mono.play();
        Assert.assertEquals(8, dice.throwDice());
        Assert.assertEquals(8, mono.getCurrentPlayer().getPos());
    }

    @Test
    public void tell_actions() {
        when(dice.throwDice()).thenReturn(8);
        List<String> actions = mono.play();
        Assert.assertEquals(ActionDoNothing.DO_NOTHING, actions.get(0));
        Assert.assertEquals(ActionBuyEstate.BUY_ESTATE, actions.get(1));
    }

    @Test
    public void buy_property() {
        when(dice.throwDice()).thenReturn(8);
        mono.play();
        mono.executeAction(1);
        Assert.assertEquals(1, mono.getCurrentPlayer().getEstates().size());
    }

    @Test
    public void hover_start() {
        when(dice.throwDice()).thenReturn(8);
        Assert.assertEquals(0, mono.getCurrentPlayer().getBalance());
        mono.play();
        Assert.assertEquals(1000, mono.getCurrentPlayer().getBalance());
    }

    @Test
    public void end_on_start() {
        when(dice.throwDice()).thenReturn(1);
        Assert.assertEquals(0, mono.getCurrentPlayer().getBalance());
        mono.play();
        Assert.assertEquals(5000, mono.getCurrentPlayer().getBalance());
    }

    @Test
    public void end_on_start_no_user_input() {
        when(dice.throwDice()).thenReturn(1);
        Assert.assertEquals(0, mono.getCurrentPlayer().getBalance());
        List<String> actions = mono.play();
        Assert.assertEquals(0, actions.size());
    }
}
