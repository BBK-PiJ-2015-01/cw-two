package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mastermind.AttemptEvaluator;
import mastermind.AttemptEvaluatorImpl;
import mastermind.AttemptResult;

public class AttemptEvaluatorTest {

	private AttemptEvaluator instance;
	private final List<?> dummySingleValueList = Arrays.asList(new String[] { "" });

	@Before
	public void setUp() throws Exception {
		instance = new AttemptEvaluatorImpl();
	}

	@Test(expected = NullPointerException.class)
	public void testNullGuessValues() {
		instance.evaluateGuess(Collections.EMPTY_LIST, null);
	}

	@Test(expected = NullPointerException.class)
	public void testNullGameValue() {
		instance.evaluateGuess(null, Collections.EMPTY_LIST);
	}

	@Test
	public void testEmptyGameValue() {
		AttemptResult result = instance.evaluateGuess(Collections.EMPTY_LIST, dummySingleValueList);
		assertNotNull(result);
		Long expectedExactScore = 0L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}

	@Test
	public void testEmptyGuessValue() {
		AttemptResult result = instance.evaluateGuess(dummySingleValueList, Collections.EMPTY_LIST);
		assertNotNull(result);
		Long expectedExactScore = 0L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}

	//*************************************************************************************************
	@Test
	public void testValidGuessValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 4L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}

	@Test
	public void testInvalidGuessValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'W', 'X', 'Y', 'Z' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 0L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}

	@Test
	public void testPartialNearGuessesValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'W', 'X', 'A', 'B' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 0L;
		Long expectedNearScore = 2L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}

	@Test
	public void testPartialExactGuessesValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'A', 'B', 'Y', 'Z' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 2L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}

	@Test
	public void testPartialExactAndNearGuessesValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'A', 'C', 'Y', 'Z' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 1L;
		Long expectedNearScore = 1L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
	//*************************************************************************************************
	
	@Test
	public void testValidGuessGameLengthLessThanGuessLengthValue() {
		
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 3L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
	@Test
	public void testInvalidGuessGameLengthLessThanGuessLengthValue() {
		
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'W', 'X', 'Y', 'Z' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 0L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
	@Test
	public void testPartialNearGuessesGameLengthLessThanGuessLengthValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'W', 'X', 'A', 'B' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 0L;
		Long expectedNearScore = 1L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}

	@Test
	public void testPartialExactGuessesGameLengthLessThanGuessLengthValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'A', 'B', 'Y', 'Z' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 2L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
	@Test
	public void testPartialExactAndNearGuessesGameLengthLessThanGuessLengthValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'A', 'C', 'Y', 'B' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 1L;
		Long expectedNearScore = 1L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
	//*************************************************************************************************
	
	@Test
	public void testValidGuess_GuessLengthLessThanGameLengthValue() {
		
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'A', 'B', 'C' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 3L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
	@Test
	public void testInValidGuess_GuessLengthLessThanGameLengthValue() {
		
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'X', 'Y', 'Z' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 0L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
	@Test
	public void testPartialNearGuesses_GuessLengthLessThanGameLengthValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'W', 'X', 'A' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 0L;
		Long expectedNearScore = 1L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
	@Test
	public void testPartialExactGuesses_GuessLengthLessThanGameLengthValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'A', 'B', 'X' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 2L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
	@Test
	public void testPartialExactAndNearGuesses_GuessLengthLessThanGameLengthValue() {
		final List<?> testGameList = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D' });
		final List<?> testGuessList = Arrays.asList(new Character[] { 'A', 'C', 'Y' });
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 1L;
		Long expectedNearScore = 1L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
}
