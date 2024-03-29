package javatest.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void repeat_string_once(){
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }
    @Test
    public void repeat_string_multiple_times(){
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }
    @Test
    public void repeat_string_zero_times(){
        Assert.assertEquals("", StringUtil.repeat("", 0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times(){
        StringUtil.repeat("", -1);
    }
    @Test
    public void string_is_empty(){
        String str = "";
        assertTrue(StringUtil.isEmpty(str));
    }
    @Test
    public void string_is_not_empty(){
        String str = "Im not empty";
        assertFalse(StringUtil.isEmpty(str));
    }
    @Test
    public void null_string_is_considered_empty(){
        String str = null;
        assertTrue(StringUtil.isEmpty(str));
    }
}