package ru.is.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {
	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("ru.is.stringcalculator.StringCalculatorTest");
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

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

	
	@Test 
	public void testNegativeNumber()
	{
		assertEquals(3, Calculator.add("3,-1,-2"));
	}

	@Test
	public void testNegativeNumbersException()
	{
		try
		{
			Calculator.thrownException("3,-1,-2");
		}
		catch (Exception e)
		{
			assertEquals("Negatives not allowed: -1,-2", e.getMessage());
		}
	}

	@Test
	public void testBigNumbers()
	{
		assertEquals(34, Calculator.add("20000,32,2,1000"));
	}

	@Test
	public void testCustomDelimeterOfAnyLength()
	{
		assertEquals(23, Calculator.add("//[***]\n3***17,2\n1"));
		assertEquals(13, Calculator.add("//[---]\n3---2,3\n3---2"));
	}

	@Test
	public void testMultipleCustomDelimeter()
	{
		assertEquals(15, Calculator.add("//[*][%]\n9*2%1\n1,2"));
	}
}