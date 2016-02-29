package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mastermind.GameAttempt;
import mastermind.GameAttemptImpl;

public class GameAttemptTest {

	private GameAttempt instance;
	
	@Before
	public void setUp() {
		
		instance = new GameAttemptImpl();
	}

	@Test
	public void getAttempListNotSetTest() {
		
		List<?> expectedAttemptList = null;
		List<?> resultAttemptList = instance.getAttempt();
		assertEquals(expectedAttemptList, resultAttemptList);
	}

}
