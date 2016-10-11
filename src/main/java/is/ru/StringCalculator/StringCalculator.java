package is.ru.StringCalculator;

import java.util.*;

public class StringCalculator 
{
    public static int add(String text) 
    {

    	if(text.equals(""))
    	{
    		return 0;
    	}
    	
    	if(text.contains("\n"))
    	{
    		text = cleanNumbers(text);
    		
    	}
    	
    	String[] newNumbers = text.split(",");

    	checkForNegativeNumbers(newNumbers);

    	return sum(newNumbers);
    	
	}

	private static int[] checkForNegativeNumbers(String[] numbers)
	{
		
		LinkedList<Integer> negIntList = new LinkedList<Integer>();
		int[] arrayNumbers = new int[numbers.length];

		boolean hasNegativeNumber = false;
		
		for(int i = 0; i < arrayNumbers.length; i++)
		{   
		    arrayNumbers[i] = Integer.parseInt(numbers[i]);
		    if(arrayNumbers[i] < 0)
		    {
		    	hasNegativeNumber = true;
		    	negIntList.add(arrayNumbers[i]);
		    }
		}

		if(hasNegativeNumber)
		{
			String negNumbers = "";
			int counter = 0;
			for(Integer number : negIntList)
			{
				counter++;
				if(counter == negIntList.size())
				{
					negNumbers += number;
				}
				else
				{
					negNumbers += number + ", ";
				}
			    
			}
			throw new IllegalArgumentException("Negatives not allowed: " + negNumbers);
		}
		return arrayNumbers;
	}

	private static String cleanNumbers(String numbers)
    {
		char[] stringCleaner = numbers.toCharArray();
		boolean strCleaned = false;
		for(int i = 0; i < numbers.length(); i++)
	        {
	            if(stringCleaner[i] == '\n')
	            {
		        stringCleaner[i] = ',';
		        strCleaned = true;
		    } 
		}
	
		if(strCleaned == true)
		{
		    numbers = String.valueOf(stringCleaner);
	    }
			return numbers;
    }

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers)
	{
		return numbers.split(",");
	}

	private static int sum(String[] numbers)
	{
		int total = 0;
		for(String number : numbers)
		{
			total += toInt(number);
		}
		//System.out.println(total);
		return total;
	}
}