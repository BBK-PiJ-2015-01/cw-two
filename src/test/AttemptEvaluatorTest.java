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
	private final List<?> dummySingleValueList = Arrays.asList(new String[]{""});

	@Before
	public void setUp() throws Exception {
		instance = new AttemptEvaluatorImpl();
	}

	@Test(expected=NullPointerException.class)
	public void testNullGuessValues() {
		instance.evaluateGuess(Collections.EMPTY_LIST, null);
	}
	
	@Test(expected=NullPointerException.class)
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
	
	@Test
	public void testValidGuessValue() {
		final List<?> testGameList = Arrays.asList(new Character[]{'A', 'B', 'C', 'D'});
		final List<?> testGuessList = Arrays.asList(new Character[]{'A', 'B', 'C', 'D'});
		
		AttemptResult result = instance.evaluateGuess(testGameList, testGuessList);
		Long expectedExactScore = 4L;
		Long expectedNearScore = 0L;
		Long resultExactScore = result.getExactScore();
		Long resultNearScore = result.getNearScore();
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}

}
