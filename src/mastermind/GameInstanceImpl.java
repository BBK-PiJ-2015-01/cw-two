package mastermind;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
* Implementation of the GameInstance interface.
* 
* A GameInstance manages the instances of a game by generating a secret code,
* controlling the evaluation of attempts and maintaining the game status
*
*@author Simon Baird & Johannes Neethling
*/

public class GameInstanceImpl implements GameInstance {

	private final GameDetails gameDetails;
	private final GameState gameState;
	private final AttemptEvaluator evaluator;

	Long attemptCounter = 0L;

	/**
	 * Constructor
	 * 
	 * @param GameDetails: the configuration of the game instance
	 *
	 */
	public GameInstanceImpl(GameDetails gameDetails) {
		super();
		this.gameDetails = gameDetails;
		gameState = new GameStateImpl();
		// Generate the secret code
		Random r = new Random();
		List<?> solution = java.util.stream.LongStream
				.rangeClosed(1, gameDetails.getNumberOfPermutations()).mapToObj(i -> (gameDetails.getGameChoices()
						.toArray()[r.nextInt(gameDetails.getGameChoices().size())]))
				.collect(Collectors.toList());
		gameState.setSolution(solution);
		gameState.setGameStatus(GameStatus.IN_PLAY);
		evaluator = new AttemptEvaluatorImpl();
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public GameState evaluateAttempt(GameAttempt attempt) {

		if (attempt == null) {
			throw new NullPointerException();
		}

		if (!gameIsOver() && attemptCounter < gameDetails.getNumberOfAttempts()) {

			attemptCounter++;
			AttemptResult result = evaluator.evaluateGuess(gameState.getSolution(), attempt.getAttempt());
			
	        // Add the evaluation result to the attempt
	        attempt.setAttemptResult(result);
	        
			if (result.getExactScore().equals(gameDetails.getNumberOfPermutations())) {
				gameState.setGameStatus(GameStatus.SOLVED);
			}
			if (getRemainingAttempts() <= 0 && !result.getExactScore().equals(gameDetails.getNumberOfPermutations())) {
				gameState.setGameStatus(GameStatus.EXPIRED);
			}

			gameState.addAttempt(attempt);
		}
		return gameState;
	}

    private boolean gameIsOver() {
        
        // conditions for game-over status
        return gameState.getGameStatus() == GameStatus.EXPIRED 
                || gameState.getGameStatus() ==GameStatus.SOLVED;
    }
    
	/**
	* {@inheritDoc}
	*/
	@Override
	public GameState getGameState() {

		return gameState;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public GameDetails getGameDetails() {

		return gameDetails;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public Long getRemainingAttempts() {

		return gameDetails.getNumberOfAttempts() - attemptCounter;
	}
}
