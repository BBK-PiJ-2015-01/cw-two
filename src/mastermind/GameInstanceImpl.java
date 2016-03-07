package mastermind;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameInstanceImpl implements GameInstance {

	private final GameDetails gameDetails;
	private final GameState gameState;
	private final AttemptEvaluator evaluator;
	
	Long attemptCounter = 0L;
	
	
	
	public GameInstanceImpl(GameDetails gameDetails) {
		super();
		this.gameDetails = gameDetails;
		gameState = new GameStateImpl();
	       // Generate the secret code
        Random r = new Random();
        List<?> solution = java.util.stream.LongStream
                .rangeClosed(1, gameDetails.getNumberOfPermutations()).mapToObj(i -> (gameDetails.getGameChoices()
                        .keySet().toArray()[r.nextInt(gameDetails.getGameChoices().size())]))
                .collect(Collectors.toList());
        gameState.setSolution(solution);
        gameState.setGameStatus(GameStatus.IN_PLAY);
        evaluator = new AttemptEvaluatorImpl();
	}

	@Override
	public GameState evaluateAttempt(GameAttempt attempt) {
		
		if (attempt == null ) {
			throw new NullPointerException();
		}
		attemptCounter++;
		AttemptResult result = evaluator.evaluateGuess(gameState.getSolution(), attempt.getAttempt());
		if (result.getExactScore().equals(gameDetails.getNumberOfPermutations())) {
			gameState.setGameStatus(GameStatus.SOLVED);
		}
		if (getRemainingAttempts() <= 0 && !result.getExactScore().equals(gameDetails.getNumberOfPermutations())) {
			gameState.setGameStatus(GameStatus.EXPIRED);
		}		

		gameState.addAttempt(attempt);
		return null;
	}

	@Override
	public GameState getGameState() {
		// TODO Auto-generated method stub
		return gameState;
	}

	@Override
	public GameDetails getGameDetails() {

		return gameDetails;
	}

	@Override
	public Long getRemainingAttempts() {

		return gameDetails.getNumberOfAttempts() - attemptCounter;
	}
}
