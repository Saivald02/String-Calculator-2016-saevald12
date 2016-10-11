package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest
{
    
    @Test
    public void testEmptyString()
    {
    	assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testOneNumber()
    {
    	assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testTwoNumbers()
    {
    	assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testThreeNumbers()
    {
    	assertEquals(6, StringCalculator.add("1,2,3"));
    }
    @Test
    public void testMultipleNumbers()
    {
    	assertEquals(10, StringCalculator.add("1,2,3,4"));
    }

    @Test
    public void testMultipleNumbersAgain()
    {
    	assertEquals(21, StringCalculator.add("1,2,3,4,5,6"));
    }
	
}