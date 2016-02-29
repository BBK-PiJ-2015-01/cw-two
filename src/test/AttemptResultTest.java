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

}
