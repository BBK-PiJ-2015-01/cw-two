package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import mastermind.AttemptResult;
import mastermind.AttemptResultImpl;

public class AttemptResultTest {
	
	private AttemptResult instance;

	@Before
	public void setUp()  {
	}

	@Test
	public void getExactScoreNullTest() {
		
		instance = new AttemptResultImpl();
		
		Long expectedScore = null;
		Long resultScore = instance.getExactScore();
		
		assertEquals(expectedScore, resultScore );
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void setExactScoreNegativeTest() {
		
		instance = new AttemptResultImpl();
		instance.setExactScore(-1L);
	}
	
	@Test(expected=IllegalArgumentException.class)
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
		assertEquals(expectedScore, resultScore );
	}
	
	@Test
	public void getNearScoreNullTest() {
		
		instance = new AttemptResultImpl();
		
		Long expectedScore = null;
		Long resultScore = instance.getNearScore();
		
		assertEquals(expectedScore, resultScore );
	}
}
