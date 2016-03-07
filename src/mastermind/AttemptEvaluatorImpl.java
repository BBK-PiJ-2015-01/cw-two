package mastermind;

import java.util.List;

public class AttemptEvaluatorImpl implements AttemptEvaluator {

	@Override
	public AttemptResult evaluateGuess(List<?> game, List<?> guess) {
		if (guess == null || game == null) {
			throw new NullPointerException();
		}
		return null;
	}

}
