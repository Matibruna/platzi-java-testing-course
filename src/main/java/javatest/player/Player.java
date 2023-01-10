package javatest.player;

public class Player {

    private Dice dice;
    private int minNumberToWin;

    public boolean play(){
        return dice.roll() > minNumberToWin;
    }

    public Player(Dice dice, int minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }
}
