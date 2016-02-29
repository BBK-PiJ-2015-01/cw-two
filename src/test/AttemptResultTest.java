package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import mastermind.AttemptResult;
import mastermind.AttemptResultImpl;

public class AttemptResultTest {

	private AttemptResult instance;

	@Before
	public void setUp() {
	}

	@Test
	public void getExactScoreNotSetTest() {

		instance = new AttemptResultImpl();

		Long expectedScore = null;
		Long resultScore = instance.getExactScore();

		assertEquals(expectedScore, resultScore);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setExactScoreNegativeTest() {

		instance = new AttemptResultImpl();
		instance.setExactScore(-1L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setExactScoreNullArgTest() {

		instance = new AttemptResultImpl();
		instance.setExactScore(null);
	}

	@Test
	public void setExactScoreAndReadBackTest() {

		instance = new AttemptResultImpl();
		Long expectedScore = 4L;
		instance.setExactScore(expectedScore);
		Long resultScore = instance.getExactScore();
		assertEquals(expectedScore, resultScore);
	}

	@Test
	public void getNearScoreNotSetTest() {

		instance = new AttemptResultImpl();

		Long expectedScore = null;
		Long resultScore = instance.getNearScore();

		assertEquals(expectedScore, resultScore);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setNearScoreNegativeTest() {

		instance = new AttemptResultImpl();
		instance.setNearScore(-1L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setNearScoreNullArgTest() {

		instance = new AttemptResultImpl();
		instance.setNearScore(null);
	}

	@Test
	public void setNearScoreAndReadBackTest() {

		instance = new AttemptResultImpl();
		Long expectedScore = 4L;
		instance.setNearScore(expectedScore);
		Long resultScore = instance.getNearScore();
		assertEquals(expectedScore, resultScore);
	}

	@Test
	public void getMessageNotSetTest() {

		instance = new AttemptResultImpl();

		String expectedMessage = null;
		String resultMessage = instance.getMessage();

		assertEquals(expectedMessage, resultMessage);
	}

	@Test
	public void setMessageAndReadBackTest() {

		instance = new AttemptResultImpl();
		String expectedMessage = "expectedMessage";

		instance.setMessage(expectedMessage);
		String resultMessage = instance.getMessage();

		assertEquals(expectedMessage, resultMessage);
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void nullScoreConstructorsTest() {
		
		instance = new AttemptResultImpl(null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nullNearScoreConstructorsTest() {
		
		instance = new AttemptResultImpl(1L,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nullExacScoreConstructorsTest() {
		
		instance = new AttemptResultImpl(null,1L);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void negativeNearScoreConstructorsTest() {
		
		instance = new AttemptResultImpl(1L,-1L);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void negativeExactScoreConstructorsTest() {
		
		instance = new AttemptResultImpl(-1L,1L);
	}
	@Test
	public void validScoreConstructorsTest() {
		
		Long expectedExactScore = 1L;
		Long expectedNearScore = 2L;
		
		instance = new AttemptResultImpl(expectedExactScore,expectedNearScore);
		
		Long resultExactScore = instance.getExactScore();
		Long resultNearScore = instance.getNearScore();
		
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
}
