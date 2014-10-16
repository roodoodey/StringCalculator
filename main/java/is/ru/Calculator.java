package ru.is.stringcalculator;

import java.util.Arrays;
import java.util.*;

public class Calculator
{
	public static int add(String text) {

		if (text.equals("")) 
		{
			return 0;
		}
		else
		{
			String customDelimiter = "";
			String[] numbers;

			if (text.startsWith("//")) 
			{
				int endOfDelimiter = text.indexOf("\n");
				customDelimiter = text.substring(2, endOfDelimiter);
				// removes the new line and the // prefix for a custom delimeter (hence we eliminate 3)
				// pkus the length of the delimeter itself.
				String stringWithoutCustomDelimeter = text.substring(3 + customDelimiter.length());
				
				numbers = stringWithoutCustomDelimeter.split(",|\n" + "|" + customDelimiter);
			}
			else 
			{
				numbers = text.split(",|\n");
			}

			int sum = 0;

			try
			{
				for (int i = 0; i < numbers.length; i++) 
				{
					int convertedInt = toInt(numbers[i]);

					if (convertedInt < 0) 
					{
						throw new Exception("Negatives not allowed: " + negativeStringNumbers(numbers));
					}

					if (convertedInt < 1000) 
					{
						sum += convertedInt;
					}
				}

			}
			catch(Exception expected)
			{
				System.out.println(expected);
			}

			return sum;
		}
	}

	public static void thrownException(String text) throws Exception
	{
		String[] numbers = text.split(",");

		for (int i = 0; i < numbers.length; i++ ) {

			int convertedNumber = toInt(numbers[i]);
			if (convertedNumber < 0) {
				throw new Exception("Negatives not allowed: " + negativeStringNumbers(numbers));
			}
		}
	}

	private static int toInt(String number)
	{

		return Integer.parseInt(number);
	}

	private static String negativeStringNumbers(String[] numbers)
	{
		String negativeString = "";
		for(int i = 0; i < numbers.length; i++)
		{
			int convertedInt = toInt(numbers[i]);
			if (convertedInt < 0) {
				
				if (negativeString.equals("")) 
				{
					negativeString = negativeString.concat(numbers[i]);
				}
				else
				{
					negativeString = negativeString.concat("," + numbers[i]);
				}
			}
		}

		return negativeString;
	}
}