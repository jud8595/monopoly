package com.gl.mono;

import com.gl.mono.action.Action;
import com.gl.mono.action.ActionBuyEstate;
import com.gl.mono.action.ActionDoNothing;
import com.gl.mono.game.Bank;
import com.gl.mono.game.Dice;
import com.gl.mono.square.Estate;
import com.gl.mono.square.EstateService;
import com.gl.mono.square.Square;
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
        //Square start = new Start(Arrays.asList(new ActionDoNothing()), new ActionGetMoney(5000));
        //squares.add(start);
        //squares.add(start);
        List<Action> actions = new ArrayList<>();
        Estate estate1 = new Estate(actions, "rue Rivoli");
        for (int i=0; i<20; ++i) {
            squares.add(estate1);
        }
        when(dice.throwDice()).thenReturn(8);
        mono = new Mono(4, dice, squares, estateService, bank);
        actions.add(new ActionDoNothing());
        CurrentPlayer currentPlayer = new CurrentPlayer(mono);
        actions.add(new ActionBuyEstate(estateService, estate1, currentPlayer));
    }

    @Test
    public void add_four_pl() {
        Assert.assertEquals(4, mono.getPlayerCount());
    }

    @Test
    public void pl1_play() {
        mono.play();
        Assert.assertEquals(8, dice.throwDice());
        Assert.assertEquals(8, mono.getCurrentPlayer().getPos());
    }

    @Test
    public void tell_actions() {
        List<String> actions = mono.play();
        Assert.assertEquals("do nothing", actions.get(0));
        Assert.assertEquals("buy estate", actions.get(1));
    }

    @Test
    public void do_nothing() {
        mono.play();
        mono.executeAction(0);
        // Hard to test result
    }

    @Test
    public void buy_property() {
        mono.play();
        mono.executeAction(1);
        Assert.assertEquals(1, mono.getCurrentPlayer().getEstates().size());
    }

    /*@Test
    public void hover_start() {
        mono.play();
        Assert.assertEquals(5000, mono.getCurrentPlayer().getBalance());
    }*/
}
