package mastermind;

public interface GameInstance { 

	GameState evaluateAttempt(GameAttempt attempt);

	GameState getGameState(); 

	GameDetails getGameDetails(); 

	Long getRemainingAttempts(); 
}
