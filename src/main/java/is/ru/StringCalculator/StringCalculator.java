package is.ru.StringCalculator;

public class StringCalculator 
{
    public static int add(String text) 
    {
    	if(text.equals(""))
    	{
    		return 0;
    	}
    	else if(text.contains("\n"))
    	{
    		String cleanText = cleanNumbers(text);
    		return sum(splitNumbers(cleanText));
    	}
    	else if(text.contains(","))
    	{
    		return sum(splitNumbers(text));
    	}
    	else
    	{
    		return 1;
    	}
	}

	private static String cleanNumbers(String numbers)
    {
		char[] stringCleaner = numbers.toCharArray();
		boolean strCleaned = false;
		for(int i = 0; i < numbers.length(); i++)
	        {
	            if(stringCleaner[i] == '\n')
	            {
		        stringCleaner[i]= ',';
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
		return total;
	}
}