package javatest.player;

import java.util.Random;

public class Dice {

    private int sides;
    private Random rng = new Random();

    public int roll(){
        return rng.nextInt(sides) + 1;
    }

    public Dice(int sides){
        this.sides = sides;
    };
}
