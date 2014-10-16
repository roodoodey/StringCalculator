package ru.is.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {
	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("ru.is.stringcalculator.StringCalculatorTest");
	}

	@Test
	public void testEmptyString()
	{
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneCharacterString()
	{
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoCharacterString()
	{
		assertEquals(3, Calculator.add("1,2"));
	}
}