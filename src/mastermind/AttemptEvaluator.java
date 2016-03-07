package mastermind;

import java.util.List;

public interface AttemptEvaluator { 
	 
	AttemptResult evaluateGuess(List<?> game, List<?> guess); 
}

