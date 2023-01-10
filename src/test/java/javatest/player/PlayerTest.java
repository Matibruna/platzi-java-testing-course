package javatest.player;

import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void player_looses_when_dice_is_too_low(){

        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 3);

        assertFalse(player.play());
    }

    @Test
    public void player_wins_when_dice_is_over_min(){

        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(5);

        Player player = new Player(dice, 4);

        assertTrue(player.play());
    }

}