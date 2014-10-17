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
			String delimiter = "";
			String[] numbers;

			if (text.startsWith("//")) 
			{

				int endOfDelimiter = text.indexOf("\n");
				delimiter = customDelimiter(text.substring(2, endOfDelimiter));
				// removes the new line and the // prefix for a custom delimeter (hence we eliminate 3)
				// pkus the length of the delimeter itself.
				String newDelimiter = text.substring(2, endOfDelimiter);
				String regexForSplit = ",|\n";

				// Replace all regular expression meta characters
				// witht he appropriate characters, the methods
				// take little overhead.
				newDelimiter = newDelimiter.replace("*", "\\*");
				newDelimiter = newDelimiter.replace("?", "\\?");
				newDelimiter = newDelimiter.replace("+", "\\+");
				newDelimiter = newDelimiter.replace("$", "\\$");
				newDelimiter = newDelimiter.replace("^", "\\^")	;
				
				// If the string contains a long delimeter or multiple
				// ones handle them accordingly and add them to the
				// regex that is used to split the strings
				// otherwise the string is ready to be added to the regex
				if (newDelimiter.contains("[") || newDelimiter.contains("]")) 
				{
					newDelimiter = newDelimiter.replaceAll("\\[", "");
					newDelimiter = newDelimiter.replaceAll("\\]", ",");

					int indexOfLastComma = newDelimiter.lastIndexOf(",");
					newDelimiter = newDelimiter.substring(0, indexOfLastComma);

					String[] allDelimiters = newDelimiter.split(",");

					for (int i = 0; i < allDelimiters.length; i++) 
					{
						String currentDelimiter = allDelimiters[i];

						regexForSplit = regexForSplit.concat("|" + currentDelimiter);

					}
				}
				else
				{
					regexForSplit = regexForSplit.concat("|" + newDelimiter);
				}

				String stringWithoutCustomDelimeter = text.substring(text.indexOf("\n") + 1);
				numbers = stringWithoutCustomDelimeter.split(regexForSplit);
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

	public static String customDelimiter(String withoutPrefix)
	{
		String delimiter = withoutPrefix.substring(0);

		delimiter = delimiter.replaceAll("\\[", "");
		delimiter = delimiter.replaceAll("\\]", "");
		delimiter = delimiter.replaceAll("\n", "");


		return delimiter;
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