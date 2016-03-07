package mastermind;

import java.util.List;

public class AttemptEvaluatorImpl implements AttemptEvaluator {

	@Override
	public AttemptResult evaluateGuess(List<?> game, List<?> guess) {
		if (guess == null || game == null) {
			throw new NullPointerException();
		}
		if (game.isEmpty() || guess.isEmpty()) {
			return new AttemptResultImpl(0L, 0L);
		}
		if (game.equals(guess)) {
			return new AttemptResultImpl(new Long(game.size()), 0L);
		}
		return null;
	}

}
