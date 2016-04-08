package mastermind;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.function.Function.identity;

/**
* Implementation for the AttemptEvaluator interface.
* 
* An AttemptEvaluator produces the score for an attempt by comparing the
* players guess with the secret code
*
**@author Simon Baird & Johannes Neethling
*/
public class AttemptEvaluatorImpl implements AttemptEvaluator {

	/**
	* {@inheritDoc}
	*/
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
	       // Limit the number of guesses to the number of game elements
        List<?> validGuesses = guess.size() > game.size() ? guess.subList(0, game.size()) : guess;
 
        // Distribution of game elements
        Map<?, Long> gameMap = game.stream().map(identity())
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));
 
        // Distribution of guesses
        Map<?, Long> guessMap = validGuesses.stream().map(identity())
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));
 
        // Number of corrects element in the right place. Use the smaller list
        // size
        Long correctGuesses = IntStream.rangeClosed(0, Math.min(game.size(), validGuesses.size()) - 1)
                .mapToLong(i -> game.get(i).equals(validGuesses.get(i)) ? 1L : 0L).sum();
 
        // Total number of all element matches
        Long allGuesses = gameMap.entrySet().stream()
                .mapToLong(
                        e -> Math.min(e.getValue(), guessMap.containsKey(e.getKey()) ? guessMap.get(e.getKey()) : 0L))
                .sum();
 
        return new AttemptResultImpl(correctGuesses, allGuesses - correctGuesses);
	}
}
