import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {
    @Test
    public void positiveOffset(){
        assertEquals("abc", new Cipher(26).encrypt("abc"));
        assertEquals("abc", new Cipher(0).encrypt("abc"));
        assertEquals("a", new Cipher(3).encrypt("x"));
    }

    @Test
    public void negativeOffset(){
        assertEquals("z", new Cipher(-3).encrypt("c"));
        assertEquals("n", new Cipher(-26).encrypt("n"));
        assertEquals("a", new Cipher(-3).encrypt("d"));
    }

    @Test
    public void testUpperCase(){
        assertEquals("BBCe", new Cipher(1).encrypt("AABd"));
    }
}
