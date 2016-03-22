package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AttemptEvaluatorTest.class, AttemptResultTest.class, GameAttemptTest.class, GameDetailsTest.class,
		GameInstanceTest.class, GameStateTest.class })
public class AllTests {

}
