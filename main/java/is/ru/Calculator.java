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
			for (int i = 0; i < numbers.length; i++) 
			{
				sum += toInt(numbers[i]);
			}

			return sum;
		}
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}
}