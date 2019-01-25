package io.catalyte.training;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;


public class LogicExerciseTest {
	
	LogicExercise exercise;
	
	@Before
	public void init() {
		
		exercise = new LogicExercise();
		
	}
	
	@Test
	public void testGet15PercentDiscount() {
		
		int quantity = 100;
		
		BigDecimal unitPrice = new BigDecimal("1.00");
		
		BigDecimal result = exercise.getDiscount(unitPrice, quantity);
		
		assertTrue("Wrong discount was given. Got: " + result, result.equals(new BigDecimal("85.00")));
		
	}
	
	@Test
	public void testGet10PercentDiscount() {
		
		int quantity = 50;
		
		BigDecimal unitPrice = new BigDecimal("1.00");
		
		BigDecimal result = exercise.getDiscount(unitPrice, quantity);
		
		assertTrue("Wrong discount was given. Got: " + result, result.equals(new BigDecimal("45.00")));
		
	}

	
	@Test
	public void testGetNoDiscount() {
		
		BigDecimal unitPrice = new BigDecimal("1.00");
		
		int quantity = 30;
		
		BigDecimal result = exercise.getDiscount(unitPrice, quantity);
		
		assertTrue("Wrong discount was given. Got: " + result, result.equals(new BigDecimal("30.00")));
		
	}
	
	@Test
	public void testGetGradeA() {
		
		int input = 93;
		
		char result = exercise.getGrade(input);
		
		assertTrue("Wrong grade was given. Got: " + result, result == 'A');

	}
	
	@Test
	public void testGetGradeB() {
		
		int input = 89;
		
		char result = exercise.getGrade(input);
		
		assertTrue("Wrong grade was given. Got: " + result, result == 'B');
		
	}	
	
	@Test
	public void testGetGradeC() {
		
		int input = 77;
		
		char result = exercise.getGrade(input);
		
		assertTrue("Wrong grade was given. Got: " + result, result == 'C');
		
	}	
	
	@Test
	public void testGetGradeD() {
		
		int input = 66;
		
		char result = exercise.getGrade(input);
		
		assertTrue("Wrong grade was given. Got: " + result, result == 'D');
		
	}	
	
	@Test
	public void testGetGradeF() {
		
		int input = 49;
		
		char result = exercise.getGrade(input);
		
		assertTrue("Wrong grade was given. Got: " + result,result == 'F');
		
	}	
	
	@Test
	public void testPowerArray() {
		
		double[] input = {2.2, 3.3, 4, 5};
		
		double[] result = exercise.powerArray(input);
		
		assertEquals("The length of the output array should equal the length of the input.", input.length, result.length);
		
		for(int i=0; i<input.length; i++) {
			
			assertEquals("Expected a square of the input: " + input[i] + ". Result: " + result[i] + ".", new Double(input[i] * input[i]), new Double(result[i]));
		
		}
	}
	
	@Test
	public void testIndexOfMax() {
		
		int[] input = {7, 91, 2, 45, 101, 6};
		
		int expected = 4;
		
		int result = exercise.indexOfMax(input);
		
		assertEquals("The wrong element was returned. Expected: " + expected + " Got: " + result, expected, result);
	}
	
	@Test
	public void testIsDivisibleBy() {
		
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(6,9,12,15));
		
		int divisor = 3;
		
		boolean result = exercise.isDivisibleBy(input, divisor);
		
		assertEquals("Array is divisible by divisor 3.", result, true);
		
	}
	
	@Test
	public void testIsNotDivisibleBy() {

		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(4,7,6,97,153));
		
		int divisor = 2;
		
		boolean result = exercise.isDivisibleBy(input, divisor);
		
		assertEquals("Array is not divisible by divisor 2.", result, false);
		
	}
	
	@Test
	public void testIsAbecedarian() {
		
		String input = "biopsy";
		
		boolean result = exercise.isAbecedarian(input);
		
		assertEquals("Input is abecedarian: " + input, result, true);
		
	}
	
	@Test
	public void testIsNotAbecedarian() {
		
		String input = "baby";
		
		boolean result = exercise.isAbecedarian(input);
		
		assertEquals("Input is not abecedarian: " + input, result, false);
		
	}
	
	@Test
	public void testAreAnagrams() {
		
		String input1 = "statue";
		
		String input2 = "astute";
		
		boolean result = exercise.areAnagrams(input1, input2);
		
		assertEquals("Inputs are anagrams.", result, true);
		
	}
	
	@Test
	public void testAreAnagramsWithCapitals() {
		
		
		String input1 = "Statue";
		
		String input2 = "Astute";
		
		boolean result = exercise.areAnagrams(input1, input2);
		
		assertEquals("Inputs are anagrams: " + input1 + " " + input2, result, true);
		
	}
	
	@Test
	public void testAreNotAnagrams() {
		
		String input1 = "elephant";
		
		String input2 = "eggplant";
		
		boolean result = exercise.areAnagrams(input1, input2);
		
		assertEquals("Inputs are not anagrams: " + input1 + " " + input2, result, false);
		
	}
	
	@Test
	public void testCountUniqueCharacters() {
		
		String input1 = "engineering";
		
		int result = exercise.countUniqueCharacters(input1);
		
		assertEquals("Wrong number of unique characters found. Expected: 5. Got: " + result, result, 5);
		
	}
	
	
	@Test
	public void testRemoveEvenLength() {
		
		ArrayList<String> input = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
		
		ArrayList<String> expected = new ArrayList<>(Arrays.asList("one", "two", "three", "six", "seven", "eight", "ten"));
		
		ArrayList<String> result = exercise.removeEvenLength(input);
		
		assertEquals("Result does not have expected values: " + expected.toString() + " Got: " + result.toString(), expected, result);
		
	}
	
	@Test
	public void testIsPalindrome() {
		
		String input = "madam";
		
		boolean expected = exercise.isPalindrome(input);
		
		assertEquals("Input was not recognized as a palindrome: " + input, expected, true);
	
	}
	
	
	@Test
	public void testIsNotAPalindrome() {
		
		String input = "zoomzoom";
		
		boolean expected = exercise.isPalindrome(input);
		
		assertEquals("Input was recognized as a palindrome: " + input, expected, false);	
		
	}
	
	@Test
	public void testConcordanceForGoodString(){
		
		HashMap<String, ArrayList<Integer>> expected = new HashMap<>();
		
		String input1 = "engineering";
		
		expected.put("e", new ArrayList<>(Arrays.asList(0,5,6)));
		
		expected.put("n", new ArrayList<>(Arrays.asList(1,4,9)));
		
		expected.put("g", new ArrayList<>(Arrays.asList(2,10)));
		
		expected.put("i", new ArrayList<>(Arrays.asList(3,8)));
		
		expected.put("r", new ArrayList<>(Arrays.asList(7)));
		
		HashMap<String, ArrayList<Integer>> result = exercise.concordanceForString(input1);
		
		assertEquals("Wrong number of entries in Concordance. Expected: " + expected.size() + ". Got: " + result.size(), result.size(), 5);
		
		ArrayList<Integer> locations = result.get("e");
		
		assertTrue("Missing location for letter 'e'", locations.contains(new Integer(0)));
		
		assertTrue("Missing location for letter 'e'", locations.contains(new Integer(5)));
		
		assertTrue("Missing location for letter 'e'", locations.contains(new Integer(6)));
		
		locations = result.get("n");
		
		assertTrue("Missing location for letter 'n'", locations.contains(new Integer(1)));
		
		assertTrue("Missing location for letter 'n'", locations.contains(new Integer(4)));
		
		assertTrue("Missing location for letter 'n'", locations.contains(new Integer(9)));
		
		locations = result.get("g");
		
		assertTrue("Missing location for letter 'g'", locations.contains(new Integer(2)));
		
		assertTrue("Missing location for letter 'g'", locations.contains(new Integer(10)));
		
		locations = result.get("i");
		
		assertTrue("Missing location for letter 'i'", locations.contains(new Integer(3)));
		
		assertTrue("Missing location for letter 'i'", locations.contains(new Integer(8)));
		
		locations = result.get("r");
		
		assertTrue("Missing location for letter 'r'", locations.contains(new Integer(7)));
		
	}

}

