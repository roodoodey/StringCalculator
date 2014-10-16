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

	@Test
	public void testThreeCharacterString()
	{
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testFourCharacterString()
	{
		assertEquals(7, Calculator.add("3,2,1,1"));
	}

	@Test
	public void testThreeCharacterStringWithNewline()
	{
		assertEquals(7, Calculator.add("3\n2,2"));
	}

	@Test
	public void testFourCharacterStringWithNewline()
	{
		assertEquals(9, Calculator.add("2\n1\n5,1"));
	}

	@Test
	public void testCustomDelimiter()
	{
		assertEquals(9, Calculator.add("//;\n1;3,2\n1;2"));
	}
}