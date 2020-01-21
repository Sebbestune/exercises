package fi.beanbakers.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Some examples and asserts on some basic programming problems.
 * 
 * @author Peter
 * 
 * @solutions Sebastian
 */
public class BeanBakersTests {

	@Test
	public void testReverseList() {
		List<String> input = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
		List<String> expectedResult = Arrays.asList("g", "f", "e", "d", "c", "b", "a");

		List<String> result = doReverseList(input);
		Assert.assertArrayEquals(expectedResult.toArray(new String[expectedResult.size()]),
				result.toArray(new String[result.size()]));
	}

	/**
	 * Write your method here that returns the provided input list reversed.
	 * 
	 * @param input list
	 * @return provided list reversed
	 */
	private <T> List<T> doReverseList(List<T> input) {
		Stack<T> tmp = new Stack<T>();
		List<T> output = new ArrayList<T>();
		
		input.stream().forEach((c) -> tmp.push((T) c));
		
		while(!tmp.isEmpty()) { 
		    output.add(tmp.pop()); 
		}
		
		return (List<T>) output;
	}

	@Test
	public void testFibonacciSequence() {
		int sequenceLength = 8;
		int[] expectedResult = { 1, 1, 2, 3, 5, 8, 13, 21};
		int[] result = doFibonacciSequence(sequenceLength);
		Assert.assertArrayEquals(expectedResult, result);
	}

	/**
	 * Write your method here that returns the fibonacci sequence up to the provided
	 * sequence length.
	 * 
	 * @param sequenceLength the amount of fibonacci sequence items to calculate
	 * @return int array containing the calculated fibonacci sequence
	 */
	private int[] doFibonacciSequenceRecursive(int sequenceLength) {
		int[] output = new int[sequenceLength];
		
		for(int i = 0; i < sequenceLength; i++) {
			output[i] = fibo_rec(i);
		}
		
		return output;
	}
	
	private int fibo_rec(int n) {
		if(n <= 1)
			return 1;
		return fibo_rec(n-1) + fibo_rec(n-2);
	}
	
	private int[] doFibonacciSequence(int sequenceLength) {
		int[] output = new int[sequenceLength];
		
		if(sequenceLength < 3)
		{
			for(int i = 0; i < sequenceLength; i++) {
				output[i] = 1;
			}
			
			return output;
		}
		
		sequenceLength=sequenceLength-1;
		
		output[0] = 1;
		output[1] = 1;
		
		for(int i = 2; i <= sequenceLength; i++) {
			output[i] = output[i-1] + output[i-2];
		}
		
		return output;
	}

	@Test
	public void testAscendingAndDescendingSeries() {
		List<Integer> testSeriesA = Arrays.asList(1, 2, 5, 8, 15, 27, 31, 50);
		List<Integer> testSeriesB = Arrays.asList(1, 2, 1, 8, 7, 27, 31, 50);

		Assert.assertTrue(isAscendingSeries(testSeriesA));
		Assert.assertFalse(isAscendingSeries(testSeriesB));
		Assert.assertTrue(isDescendingSeries(doReverseList(testSeriesA)));
		Assert.assertFalse(isDescendingSeries(doReverseList(testSeriesB)));
	}

	/**
	 * Write your method here that returns true if the provided list of integers is
	 * ascending, false otherwise.
	 * 
	 * @param series
	 * @return true if provided series ascends, false otherwise.
	 */
	private boolean isAscendingSeries(List<Integer> series) {
		ListIterator<Integer> listIterator = series.listIterator();
		int i = listIterator.next();
		int j;
		 
		while(listIterator.hasNext()) {
			j = listIterator.next();
		    if (i > j)
		    	return false;
		    i = j;
		}
		
		return true;
	}

	/**
	 * Write your method here that returns true if the provided list of integers is
	 * descending, false otherwise.
	 * 
	 * @param series
	 * @return true if the provided series descends, false otherwise.
	 */
	private boolean isDescendingSeries(List<Integer> series) {
		ListIterator<Integer> listIterator = series.listIterator();
		int i = listIterator.next();
		int j;
		 
		while(listIterator.hasNext()) {
			j = listIterator.next();
		    if (i < j)
		    	return false;
		    i = j;
		}
		
		return true;
	}
}
