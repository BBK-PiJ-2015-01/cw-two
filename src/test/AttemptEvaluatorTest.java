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
		AttemptResult expected = instance.evaluateGuess(Collections.EMPTY_LIST, dummySingleValueList);
		assertNotNull(expected);
	}

}
