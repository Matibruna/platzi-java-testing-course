package javatest.util;

import javatest.util.PasswordUtil.SecurityLevel;
import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_caracters(){
        assertEquals(SecurityLevel.WEAK, PasswordUtil.assesPassword("3!kdS5"));
    }

    @Test
    public void weak_when_has_only_letters(){
        assertEquals(SecurityLevel.WEAK, PasswordUtil.assesPassword("abcdefasdgwqdghijk"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){
        assertEquals(SecurityLevel.MEDIUM, PasswordUtil.assesPassword("abcdef1234567"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols(){
        assertEquals(SecurityLevel.STRONG, PasswordUtil.assesPassword("a9?+2?4#"));
    }

}