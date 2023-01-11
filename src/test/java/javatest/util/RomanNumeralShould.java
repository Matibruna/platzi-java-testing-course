package javatest.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralShould {
    @Test
    public void return_MM_when_two_thousend(){
        assertEquals("MM", RomanNumerals.arabicToRoman(2000));
    }
    @Test
    public void return_M_when_a_thousend(){
        assertEquals("M", RomanNumerals.arabicToRoman(1000));
    }
    @Test
    public void return_DCCC_when_a_eight_hundred(){
        assertEquals("DCCC", RomanNumerals.arabicToRoman(800));
    }    @Test
    public void return_CCD_when_a_three_hundred(){
        assertEquals("CCD", RomanNumerals.arabicToRoman(300));
    }
    @Test
    public void return_D_when_five_hundred(){
        assertEquals("D", RomanNumerals.arabicToRoman(500));
    }
    @Test
    public void return_C_when_hundred(){
        assertEquals("C", RomanNumerals.arabicToRoman(100));
    }
    @Test
    public void return_XC_when_ninety(){
        assertEquals("XC", RomanNumerals.arabicToRoman(90));
    }
    @Test
    public void return_XXC_when_eighty(){
        assertEquals("XXC", RomanNumerals.arabicToRoman(80));
    }
    @Test
    public void return_LX_when_sixty(){
        assertEquals("LX", RomanNumerals.arabicToRoman(60));
    }
    @Test
    public void return_LIV_when_fiftyfour(){
        assertEquals("LIV", RomanNumerals.arabicToRoman(54));
    }
    @Test
    public void return_L_when_fifty(){
        assertEquals("L", RomanNumerals.arabicToRoman(50));
    }
    @Test
    public void return_XLIX_when_fourty_nine(){
        assertEquals("XLIX", RomanNumerals.arabicToRoman(49));
    }
    @Test
    public void return_XX_when_twenty(){
        assertEquals("XX", RomanNumerals.arabicToRoman(20));
    }
    @Test
    public void return_XIX_when_nineteen(){
        assertEquals("XIX", RomanNumerals.arabicToRoman(19));
    }
    @Test
    public void return_X_when_ten(){
        assertEquals("X", RomanNumerals.arabicToRoman(10));
    }
    @Test
    public void return_IX_when_nine(){
        assertEquals("IX", RomanNumerals.arabicToRoman(9));
    }
    @Test
    public void return_IIX_when_eight(){
        assertEquals("IIX", RomanNumerals.arabicToRoman(8));
    }
    @Test
    public void return_III_when_three(){
        assertEquals("III", RomanNumerals.arabicToRoman(3));
    }

    @Test
    public void return_I_when_one(){
        assertEquals("I", RomanNumerals.arabicToRoman(1));
    }
}