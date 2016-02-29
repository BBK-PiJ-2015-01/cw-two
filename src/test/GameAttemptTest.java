package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mastermind.AttemptResult;
import mastermind.AttemptResultImpl;
import mastermind.GameAttempt;
import mastermind.GameAttemptImpl;

public class GameAttemptTest {

	private GameAttempt instance;

	@Before
	public void setUp() {

		instance = new GameAttemptImpl();
	}

	// ************************ Attempt list tests
	// *******************************

	@Test
	public void getAttempListNotSetTest() {

		List<?> expectedAttemptList = null;
		List<?> resultAttemptList = instance.getAttempt();
		assertEquals(expectedAttemptList, resultAttemptList);
	}

	@Test
	public void setAttempListWithEmptyListTest() {

		instance.setAttempt(Collections.EMPTY_LIST);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setAttempListWithNullListTest() {

		instance.setAttempt(null);
	}

	@Test
	public void getAttempListAfterValidSetterTest() {

		List<?> expectedAttemptList = Arrays.asList(new String[] { "Any string value here" });
		instance.setAttempt(expectedAttemptList);
		List<?> resultAttemptList = instance.getAttempt();
		assertEquals(expectedAttemptList, resultAttemptList);
	}

	// ************************ GameResult tests *******************************

	@Test
	public void getAttemptResultNotSetTest() {

		AttemptResult expectedAttempResult = null;
		AttemptResult resultAttempResult = instance.getAttemptResult();
		assertEquals(expectedAttempResult, resultAttempResult);
	}

	@Test
	public void setAttempResultWithEmptyResultTest() {

		instance.setAttemptResult(new AttemptResultImpl());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setAttempResultWithNullTest() {

		instance.setAttemptResult(null);
	}

	@Test
	public void getAttempResultAfterValidSetterTest() {

		AttemptResult expectedAttempResult = new AttemptResultImpl();
		instance.setAttemptResult(expectedAttempResult);
		AttemptResult resultAttempResult = instance.getAttemptResult();
		assertEquals(expectedAttempResult, resultAttempResult);
	}

	// ************************ Message tests *******************************

	@Test
	public void getMessageNotSetTest() {

		String expectedMessage = null;
		String resultMessage = instance.getMessage();
		assertEquals(expectedMessage, resultMessage);
	}

	@Test
	public void getMessageAfterValidSetterTest() {

		String expectedMessage = "expectedMessage";
		instance.setMessage(expectedMessage);
		String resultMessage = instance.getMessage();
		assertEquals(expectedMessage, resultMessage);
	}
}
