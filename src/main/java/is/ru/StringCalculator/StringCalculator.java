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
    	
    	if(text.contains("//"))
    	{
    		text = text.substring(4); 
    		String[] newNumbers = text.split(checkForDelimiter(text));
    		int[] arrayNumbers = GetNumbers(newNumbers);
    		return sum(arrayNumbers);
    	}
    	else
    	{
    		String[] newNumbers = text.split(",|\n");
    		int[] arrayNumbers = GetNumbers(newNumbers);
    		return sum(arrayNumbers);
    	}
    }

	private static String checkForDelimiter(String text)
	{
		String delimiter = ",|\n";
		int index = text.indexOf("//") + 2;
		delimiter = delimiter + "|" + text.substring(index, index + 1);
		return delimiter;
	}

	private static int[] GetNumbers(String[] numbers)
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
		    if(arrayNumbers[i] > 1000)
		    {
		    	arrayNumbers[i] = 0;
		    }
		}

		if(hasNegativeNumber)
		{
			negativeException(negIntList);
		}	
		return arrayNumbers;
	}

	private static void negativeException(LinkedList<Integer> negIntList)
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

	private static int sum(int arrayNumbers[])
	{
		int total = 0;
		for(int i = 0; i < arrayNumbers.length; i++)
		{
			total += arrayNumbers[i];
		}
		return total;
	}
}