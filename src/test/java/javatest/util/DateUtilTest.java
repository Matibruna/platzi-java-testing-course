package javatest.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void leap_year_true_when_year_is_divisible_by_400(){
        assertTrue(DateUtil.isLeapYear(2000));
        assertTrue(DateUtil.isLeapYear(1600));
        assertTrue(DateUtil.isLeapYear(1200));
    }

    @Test
    public void leap_year_true_when_year_is_divisible_by_4_but_not_by_100(){
        assertTrue(DateUtil.isLeapYear(1996));
        assertTrue(DateUtil.isLeapYear(2004));
        assertTrue(DateUtil.isLeapYear(2008));
    }

    @Test
    public void leap_year_false_when_year_is_divisible_by_100_but_not_by_400(){
        assertFalse(DateUtil.isLeapYear(1700));
        assertFalse(DateUtil.isLeapYear(1800));
        assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    public void leap_year_false_when_year_is_not_divisible_by_4(){
        assertFalse(DateUtil.isLeapYear(1707));
        assertFalse(DateUtil.isLeapYear(2001));
        assertFalse(DateUtil.isLeapYear(1583));
    }

}