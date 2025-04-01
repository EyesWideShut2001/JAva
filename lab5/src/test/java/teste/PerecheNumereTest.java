package teste;

import org.junit.jupiter.api.Test;
import tema.PerecheNumere;

import static org.junit.jupiter.api.Assertions.*;

class PerecheNumereTest
{
    @Test
    void testEstePătratPerfect()
    {
        PerecheNumere pereche = new PerecheNumere();

        // Test with 9 (which is a perfect square)
        assertTrue(pereche.estePătratPerfect(9), "9 should be a perfect square.");

        // Test with 3 (which is not a perfect square)
        assertFalse(pereche.estePătratPerfect(3), "3 should not be a perfect square.");
    }
    @Test
    void testEsteInFibonacci()
    {
        PerecheNumere pereche = new PerecheNumere();

        // Test if 3 is in the Fibonacci sequence
        assertTrue(pereche.esteInFibonacci(3), "3 should be a Fibonacci number.");

        // Test if 4 is NOT in the Fibonacci sequence
        assertFalse(pereche.esteInFibonacci(4), "4 should not be a Fibonacci number.");
    }

    // Test for LCM (Least Common Multiple)
    @Test
    void testLCM()
    {
        PerecheNumere pereche = new PerecheNumere(4, 6);

        // LCM of 4 and 6 is 12
        assertEquals(12, pereche.lcm(), "LCM of 4 and 6 should be 12.");
    }

    // Test for GCD (Greatest Common Divisor)
    @Test
    void testGCD()
    {
        PerecheNumere pereche = new PerecheNumere();

        // GCD of 4 and 6 is 2
        assertEquals(2, pereche.gcd(4, 6), "GCD of 4 and 6 should be 2.");
    }

}