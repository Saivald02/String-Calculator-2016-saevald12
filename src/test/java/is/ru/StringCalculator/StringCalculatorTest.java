package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
//import org.junit.rules.ExpectedException;
//import org.junit.Rule;

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
    public void testOneNumberFail()
    {
    	assertEquals(2, StringCalculator.add("1"));
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

    @Test
    public void testFirstNewLine()
    {
    	assertEquals(3, StringCalculator.add("1\n2"));
    }

    @Test
    public void testFirstNewLineFail()
    {
    	assertEquals(4, StringCalculator.add("1\n2"));
    }
    @Test
    public void testSecondNewLine()
    {
    	assertEquals(21, StringCalculator.add("1\n2,3\n4,5\n6"));
    }

    @Test
    public void testThirdNewLine()
    {
    	assertEquals(21, StringCalculator.add("1\n2\n3\n4\n5\n6"));
    }

    @Test
    public void testOneNegative()
    {
    	assertEquals(1, StringCalculator.add("-9"));
    }

    @Test
    public void testMoreNegative()
    {
    	assertEquals(21, StringCalculator.add("-1\n-2\n-3,-4,-5,-6,-10"));
    }

    @Test
    public void testLargeNumber1()
    {
    	assertEquals(1001, StringCalculator.add("1000,1"));
    }

    @Test
    public void testLargeNumber2()
    {
    	assertEquals(1, StringCalculator.add("1001,1"));
    }

    @Test
    public void testLargeNumber3()
    {
    	assertEquals(1002, StringCalculator.add("1001,1"));
    }

}